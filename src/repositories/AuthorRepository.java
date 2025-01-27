package repositories;

import config.DatabaseConnection;
import model.Author;
import model.Sex;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private final DatabaseConnection databaseConnection;

    public AuthorRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public AuthorRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public List<Author> getAllAuthors() throws SQLException {
        List<Author> authors = new ArrayList<>();
        String query = "SELECT * FROM Authors";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                authors.add(new Author(
                        resultSet.getString("author_id"),
                        resultSet.getString("name"),
                        Sex.valueOf(resultSet.getString("sex"))
                ));
            }
        }

        return authors;
    }

    public void addAuthor(Author author) throws SQLException {
        String query = "INSERT INTO Authors (author_id, name, sex) VALUES (?, ?, ?)";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, author.getId());
            statement.setString(2, author.getName());
            statement.setString(3, String.valueOf(author.getSex()));
            statement.executeUpdate();
        }
    }

    public void updateAuthor(Author author) throws SQLException {
        String query = "UPDATE Authors SET name = ?, sex = ? WHERE author_id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, author.getName());
            statement.setString(2, String.valueOf(author.getSex()));
            statement.setString(3, author.getId());
            statement.executeUpdate();
        }
    }

    public void deleteAuthor(String id) throws SQLException {
        String query = "DELETE FROM Authors WHERE author_id = ?";

        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, id);
            statement.executeUpdate();
        }
    }

    public Author findById(String authorId) {
        String query = "SELECT * FROM Authors WHERE author_id = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, authorId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return new Author(
                        resultSet.getString("author_id"),
                        resultSet.getString("name"),
                        Sex.valueOf(resultSet.getString("sex"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
