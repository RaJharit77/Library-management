package test.java;

import model.Author;
import model.Book;
import model.Sex;
import model.Topic;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repositories.AuthorRepository;
import repositories.BookRepository;
import services.AuthorService;
import services.BookService;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorBookTest {

    private AuthorService authorService;
    private BookService bookService;

    @BeforeEach
    void setUp() {
        authorService = new AuthorService();
        bookService = new BookService();
    }

    @Test
    void testAuthorCRUD() throws SQLException {
        // Create
        Author author = new Author("A1", "George Orwell", Sex.MALE);
        authorService.addAuthor(author);

        // Read
        Author foundAuthor = authorService.getAllAuthors().stream()
                .filter(a -> a.getId().equals("A1"))
                .findFirst()
                .orElse(null);
        assertNotNull(foundAuthor);
        assertEquals("George Orwell", foundAuthor.getName());

        // Update
        author.setName("Eric Arthur Blair");
        authorService.updateAuthor(author);
        foundAuthor = authorService.getAllAuthors().stream()
                .filter(a -> a.getId().equals("A1"))
                .findFirst()
                .orElse(null);
        assertNotNull(foundAuthor);
        assertEquals("Eric Arthur Blair", foundAuthor.getName());

        // Delete
        authorService.deleteAuthor("A1");
        foundAuthor = authorService.getAllAuthors().stream()
                .filter(a -> a.getId().equals("A1"))
                .findFirst()
                .orElse(null);
        assertNull(foundAuthor);
    }

    @Test
    void testBookCRUD() {
        // Create Author
        Author author = new Author("A2", "J.K. Rowling", Sex.FEMALE);
        try {
            authorService.addAuthor(author);
        } catch (SQLException e) {
            fail("Failed to add author", e);
        }

        // Create Book
        Book book = new Book("B1", "Harry Potter", author, 500, Topic.OTHER, "1997-06-26");
        bookService.createBook(book);

        // Read
        Book foundBook = bookService.getBookById("B1");
        assertNotNull(foundBook);
        assertEquals("Harry Potter", foundBook.getBookName());

        // Update
        book.setBookName("Harry Potter and the Philosopher's Stone");
        bookService.updateBook(book);
        foundBook = bookService.getBookById("B1");
        assertNotNull(foundBook);
        assertEquals("Harry Potter and the Philosopher's Stone", foundBook.getBookName());

        // Delete
        bookService.deleteBook("B1");
        foundBook = bookService.getBookById("B1");
        assertNull(foundBook);

        // Cleanup
        try {
            authorService.deleteAuthor("A2");
        } catch (SQLException e) {
            fail("Failed to delete author", e);
        }
    }
}