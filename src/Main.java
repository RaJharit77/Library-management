import prog3.management.library.controllers.AuthorController;
import prog3.management.library.controllers.BookController;
import prog3.management.library.model.Author;
import prog3.management.library.model.Book;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        try {
            // Book CRUD
            System.out.println("=== BOOK CRUD OPERATIONS ===");
            BookController bookController = new BookController();

            // Create a new book
            Author bookAuthor = new Author("Auth123", "John Doe", "M");
            Book newBook = new Book("1", "Legendary Book", bookAuthor, 257, "Fiction", "2025-01-01");
            bookController.createBook(newBook);
            System.out.println("Book created: " + newBook.getBookName());

            // Retrieve all books
            List<Book> books = bookController.getAllBooks();
            System.out.println("List of books:");
            for (Book book : books) {
                System.out.println(" - " + book.getBookName());
            }

            // Update a book
            newBook.setBookName("Updated Book Title");
            bookController.updateBook(newBook);
            System.out.println("Book updated: " + newBook.getBookName());

            // Retrieve the updated book
            Book updatedBook = bookController.getBookById("1");
            System.out.println("Retrieved updated book: " + updatedBook.getBookName());

            // Delete a book
            bookController.deleteBook("1");
            System.out.println("Book deleted with ID: 1");

            // Author CRUD Example
            System.out.println("\n=== AUTHOR CRUD OPERATIONS ===");
            AuthorController authorController = new AuthorController();
            Author newAuthor = new Author("A1", "John Doe", "M");
            authorController.createAuthor(newAuthor);
            System.out.println("Author created: " + newAuthor.getName());

            // Retrieve all authors
            List<Author> authors = authorController.getAllAuthors();
            System.out.println("List of authors:");
            for (Author author : authors) {
                System.out.println(" - " + author.getName());
            }

            // Student CRUD
            System.out.println("\n=== STUDENT CRUD OPERATIONS ===");
            StudentController studentController = new StudentController();
            Student newStudent = new Student("1", "Alice Doe", "F", "1995-05-10", "STD25001", "L1");
            studentController.createStudent(newStudent);
            System.out.println("Student created: " + newStudent.getName());

            // Retrieve all students
            List<Student> students = studentController.getAllStudents();
            System.out.println("List of students:");
            for (Student student : students) {
                System.out.println(" - " + student.getName());
            }

            } catch (SQLException e) {
                    System.err.println("Database error: " + e.getMessage());
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("Unexpected error: " + e.getMessage());
                    e.printStackTrace();
                }
            }

        /**BookController bookController = new BookController();

        // Create a new book
        Author author = new Author("Auth123", "John Doe", "M");
        Book book = new Book("1", "Legendary Book", author, 300, "Fiction", "2025-01-01");
        bookController.createBook(book);

        // Retrieve all books
        List<Book> books = bookController.getAllBooks();
        for (Book b : books) {
            System.out.println(b.getBookName());
        }

        // Update a book
        book.setBookName("Updated Book Title");
        bookController.updateBook(book);

        // Retrieve the updated book
        Book updatedBook = bookController.getBookById("1");
        System.out.println(updatedBook.getBookName());

        // Delete a book
        bookController.deleteBook("1");

        // Author CRUD Example
        AuthorController authorController = new AuthorController();
        Author newAuthor = new Author("A1", "John Doe", "M");
        authorController.createAuthor(newAuthor);
        System.out.println("Created Author: " + newAuthor.getName());

        // Student CRUD Example
        StudentController studentController = new StudentController();
        Student newStudent = new Student("1", "Alice Doe", "F", "1995-05-10", "STD25001", "L1");
        studentController.createStudent(newStudent);
        System.out.println("Created Student: " + newStudent.getName());
         */
}
