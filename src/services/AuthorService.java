package services;

import model.Author;
import repositories.AuthorRepository;

import java.sql.SQLException;
import java.util.List;

public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService() {
        this.authorRepository = new AuthorRepository();
    }

    public List<Author> getAllAuthors() throws SQLException {
        return authorRepository.getAllAuthors();
    }

    public void addAuthor(Author author) throws SQLException {
        authorRepository.addAuthor(author);
    }

    public void updateAuthor(Author author) throws SQLException {
        authorRepository.updateAuthor(author);
    }

    public void deleteAuthor(String id) throws SQLException {
        authorRepository.deleteAuthor(id);
    }
}
