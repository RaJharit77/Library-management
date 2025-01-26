package controllers;

import model.Book;
import services.BookService;

import java.util.List;

public class BookController {
    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    public Book getBookById(String bookId) {
        return bookService.getBookById(bookId);
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public void createBook(Book book) {
        bookService.createBook(book);
    }

    public void updateBook(Book book) {
        bookService.updateBook(book);
    }

    public void deleteBook(String bookId) {
        bookService.deleteBook(bookId);
    }
}
