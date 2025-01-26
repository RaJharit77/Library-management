package services;

import model.Book;
import repositories.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService() {
        this.bookRepository = new BookRepository();
    }

    public Book getBookById(String bookId) {
        return bookRepository.findById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void createBook(Book book) {
        bookRepository.createBook(book);
    }

    public void updateBook(Book book) {
        bookRepository.update(book);
    }

    public void deleteBook(String bookId) {
        bookRepository.delete(bookId);
    }
}
