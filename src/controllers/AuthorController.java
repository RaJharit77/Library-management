package controllers;

import model.Author;
import services.AuthorService;

import java.sql.SQLException;
import java.util.*;

public class AuthorController {
    private final AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    public List<Author> getAllAuthors() {
        try {
            List<Author> authors = authorService.getAllAuthors();
            authors.forEach(author -> System.out.println(author.getId() + " - " + author.getName() + " - " + author.getSex()));
        } catch (SQLException e) {
            System.err.println("Error fetching authors: " + e.getMessage());
        }
        return null;
    }

    public void createAuthor(Author author) {
        try {
            authorService.addAuthor(author);
            System.out.println("Author added successfully.");
        } catch (SQLException e) {
            System.err.println("Error adding author: " + e.getMessage());
        }
    }

    public void updateAuthor(Author author) {
        try {
            authorService.updateAuthor(author);
            System.out.println("Author updated successfully.");
        } catch (SQLException e) {
            System.err.println("Error updating author: " + e.getMessage());
        }
    }

    public void deleteAuthor(String id) {
        try {
            authorService.deleteAuthor(id);
            System.out.println("Author deleted successfully.");
        } catch (SQLException e) {
            System.err.println("Error deleting author: " + e.getMessage());
        }
    }
}
