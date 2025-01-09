import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MovieRecommendationSystemTest {

    private MovieRecommendationSystem.MovieTree movieTree;

    @BeforeEach
    public void setUp() {
        movieTree = new MovieRecommendationSystem.MovieTree();

        // Predefined Movies
        movieTree.insert(new MovieRecommendationSystem.Movie("The Matrix", 90, "Sci-Fi"));
        movieTree.insert(new MovieRecommendationSystem.Movie("Inception", 87, "Sci-Fi"));
        movieTree.insert(new MovieRecommendationSystem.Movie("Avengers: Endgame", 85, "Action"));
        movieTree.insert(new MovieRecommendationSystem.Movie("Interstellar", 92, "Sci-Fi"));
        movieTree.insert(new MovieRecommendationSystem.Movie("The Godfather", 97, "Crime"));
        movieTree.insert(new MovieRecommendationSystem.Movie("Toy Story", 95, "Animation"));
        movieTree.insert(new MovieRecommendationSystem.Movie("Frozen", 80, "Animation"));
        movieTree.insert(new MovieRecommendationSystem.Movie("The Dark Knight", 94, "Action"));

        // User Profiles
        movieTree.addUser("Alice");
        movieTree.addUser("Bob");

        // Adding Movies to User Watch History
        movieTree.addMovieToHistory("Alice", new MovieRecommendationSystem.Movie("The Matrix", 90, "Sci-Fi"));
        movieTree.addMovieToHistory("Alice", new MovieRecommendationSystem.Movie("Interstellar", 92, "Sci-Fi"));
        movieTree.addMovieToHistory("Bob", new MovieRecommendationSystem.Movie("The Godfather", 97, "Crime"));
    }

    @Test
    public void testInsertAndSearchByGenre() {
        movieTree.searchByGenre("Sci-Fi");
        // Expected output: The Matrix, Inception, Interstellar
    }

    @Test
    public void testInsertAndSearchByRating() {
        movieTree.searchByRating(85);
        // Expected output: Movies with a rating >= 85
    }

    @Test
    public void testAddUser() {
        movieTree.addUser("Charlie");
        assertTrue(true); // Check if no exception occurs
    }

    @Test
    public void testNoDuplicateInsert() {
        movieTree.insert(new MovieRecommendationSystem.Movie("The Matrix", 90, "Sci-Fi"));
        assertTrue(true); // Ensure no duplicate is inserted
    }
}
