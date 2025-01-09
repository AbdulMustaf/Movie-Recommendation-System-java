import java.util.*;

public class MovieRecommendationSystem {

    // Binary Search Tree Node for Movies
    static class MovieNode {
        int rating;
        Movie movie;
        MovieNode left, right;

        MovieNode(Movie movie) {
            this.movie = movie;
            this.rating = movie.getRating();
            this.left = this.right = null;
        }
    }

    // Movie Class
    static class Movie {
        private final String title;
        private final int rating;
        private final String genre;

        public Movie(String title, int rating, String genre) {
            this.title = title;
            this.rating = rating;
            this.genre = genre;
        }

        public String getTitle() {
            return title;
        }

        public int getRating() {
            return rating;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return "\"" + title + "\" [" + genre + "] (" + rating + ")";
        }
    }

    // User Profile Class
    static class UserProfile {
        String username;
        List<Movie> watchHistory;

        public UserProfile(String username) {
            this.username = username;
            this.watchHistory = new ArrayList<>();
        }

        public void addToHistory(Movie movie) {
            watchHistory.add(movie);
        }

        public List<Movie> getWatchHistory() {
            return watchHistory;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("Watch History for " + username + ":\n");
            for (Movie movie : watchHistory) {
                sb.append("\t").append(movie).append("\n");
            }
            return sb.toString();
        }
    }

    // Movie Recommendation System
    static class MovieTree {
        private MovieNode root;
        private Map<String, UserProfile> userProfiles;

        public MovieTree() {
            this.root = null;
            this.userProfiles = new HashMap<>();
        }

        // Insert a Movie into the BST
        public void insert(Movie movie) {
            root = insertRecursive(root, movie);
        }

        private MovieNode insertRecursive(MovieNode node, Movie movie) {
            if (node == null) {
                return new MovieNode(movie);
            }
            if (movie.getRating() < node.rating) {
                node.left = insertRecursive(node.left, movie);
            } else {
                node.right = insertRecursive(node.right, movie);
            }
            return node;
        }

        // Search Movies by Genre
        public void searchByGenre(String genre) {
            System.out.println("Movies in the genre \"" + genre + "\":");
            searchByGenreRecursive(root, genre);
        }

        private void searchByGenreRecursive(MovieNode node, String genre) {
            if (node == null) return;
            searchByGenreRecursive(node.left, genre);
            if (node.movie.getGenre().equalsIgnoreCase(genre)) {
                System.out.println("\t" + node.movie);
            }
            searchByGenreRecursive(node.right, genre);
        }

        // Search Movies by Minimum Rating
        public void searchByRating(int minRating) {
            System.out.println("Movies with a rating of " + minRating + " or higher:");
            searchByRatingRecursive(root, minRating);
        }

        private void searchByRatingRecursive(MovieNode node, int minRating) {
            if (node == null) return;
            searchByRatingRecursive(node.left, minRating);
            if (node.rating >= minRating) {
                System.out.println("\t" + node.movie);
            }
            searchByRatingRecursive(node.right, minRating);
        }

        // Add User Profile
        public void addUser(String username) {
            userProfiles.putIfAbsent(username, new UserProfile(username));
        }

        // Add a Movie to User's Watch History
        public void addMovieToHistory(String username, Movie movie) {
            UserProfile user = userProfiles.get(username);
            if (user == null) {
                System.out.println("User not found.");
                return;
            }
            user.addToHistory(movie);
            System.out.println("Added " + movie + " to " + username + "'s watch history.");
        }

        // Recommend Movies Based on Shared Interests
        public void recommendMovies(String username) {
            UserProfile user = userProfiles.get(username);
            if (user == null) {
                System.out.println("User not found.");
                return;
            }

            Set<String> watchedGenres = new HashSet<>();
            for (Movie movie : user.getWatchHistory()) {
                watchedGenres.add(movie.getGenre());
            }

            System.out.println("Recommendations for " + username + ":");
            recommendRecursive(root, watchedGenres, user.getWatchHistory());
        }

        private void recommendRecursive(MovieNode node, Set<String> genres, List<Movie> history) {
            if (node == null) return;

            recommendRecursive(node.left, genres, history);
            if (genres.contains(node.movie.getGenre()) && !history.contains(node.movie)) {
                System.out.println("\t" + node.movie);
            }
            recommendRecursive(node.right, genres, history);
        }
    }

    public static void main(String[] args) {
        MovieTree system = new MovieTree();

        // Predefined Movies
        system.insert(new Movie("The Matrix", 90, "Sci-Fi"));
        system.insert(new Movie("Inception", 87, "Sci-Fi"));
        system.insert(new Movie("Avengers: Endgame", 85, "Action"));
        system.insert(new Movie("Interstellar", 92, "Sci-Fi"));
        system.insert(new Movie("The Godfather", 97, "Crime"));
        system.insert(new Movie("Toy Story", 95, "Animation"));
        system.insert(new Movie("Frozen", 80, "Animation"));
        system.insert(new Movie("The Dark Knight", 94, "Action"));

        // User Profiles
        system.addUser("Alice");
        system.addUser("Bob");

        // Adding Movies to User Watch History
        system.addMovieToHistory("Alice", new Movie("The Matrix", 90, "Sci-Fi"));
        system.addMovieToHistory("Alice", new Movie("Interstellar", 92, "Sci-Fi"));
        system.addMovieToHistory("Bob", new Movie("The Godfather", 97, "Crime"));

        // Search and Recommendations
        system.searchByGenre("Sci-Fi");
        System.out.println();

        system.searchByRating(85);
        System.out.println();

        system.recommendMovies("Alice");
        System.out.println();

        system.recommendMovies("Bob");
    }
}
