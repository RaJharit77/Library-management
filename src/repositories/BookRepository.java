package repositories;

import config.DatabaseConnection;
import model.Author;
import model.Book;
import model.Topic;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final DatabaseConnection databaseConnection;

    public BookRepository(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public BookRepository() {
        this.databaseConnection = new DatabaseConnection();
    }

    public void createBook(Book book) {
        String query = "INSERT INTO Books (id_books, book_name, author_id, page_numbers, topic, release_date) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, book.getId());
            stmt.setString(2, book.getBookName());
            stmt.setString(3, book.getAuthor_id().getId());
            stmt.setInt(4, book.getPageNumbers());
            stmt.setString(5, String.valueOf(book.getTopic()));
            stmt.setDate(6, Date.valueOf(book.getReleaseDate()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(Book book) {
        String query = "UPDATE Books SET book_name = ?, author_id = ?, page_numbers = ?, topic = ?, release_date = ? WHERE id_books = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, book.getBookName());
            stmt.setString(2, book.getAuthor_id().getId());
            stmt.setInt(3, book.getPageNumbers());
            stmt.setString(4, String.valueOf(book.getTopic()));
            stmt.setDate(5, Date.valueOf(book.getReleaseDate()));
            stmt.setString(6, book.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String bookId) {
        String query = "DELETE FROM Books WHERE id_books = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, bookId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book findById(String bookId) {
        String query = "SELECT * FROM Books WHERE id_books = ?";
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, bookId);
            ResultSet rs = stmt.executeQuery();
            AuthorRepository authorRepository = new AuthorRepository();

            if (rs.next()) {
                Author author = authorRepository.findById(rs.getString("author_id"));
                return new Book(rs.getString("id_books"), rs.getString("book_name"), author,
                        rs.getInt("page_numbers"), Topic.valueOf(rs.getString("topic")), rs.getString("release_date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM Books";
        try (Connection connection = databaseConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            AuthorRepository authorRepository = new AuthorRepository();
            while (rs.next()) {
                Author author = authorRepository.findById(rs.getString("author_id"));
                books.add(new Book(rs.getString("id_books"), rs.getString("book_name"), author,
                        rs.getInt("page_numbers"), Topic.valueOf(rs.getString("topic")), rs.getString("release_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
