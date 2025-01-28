package test;

import model.Author;
import model.Book;
import model.Sex;
import model.Topic;
import controllers.AuthorController;
import controllers.BookController;

public class Main {
    public static void main(String[] args) {
        // Création des contrôleurs
        AuthorController authorController = new AuthorController();
        BookController bookController = new BookController();

        // Création d'un auteur
        Author author = new Author("A1", "John Doe", Sex.MALE);
        authorController.createAuthor(author);

        // Création d'un livre associé à l'auteur
        Book book = new Book("B1", "Java Programming", author, 300, Topic.OTHER, "2023-10-01");
        bookController.createBook(book);

        // Récupération et affichage de tous les auteurs
        System.out.println("Liste des auteurs :");
        authorController.getAllAuthors();

        // Récupération et affichage de tous les livres
        System.out.println("Liste des livres :");
        bookController.getAllBooks().forEach(b -> System.out.println(b.toString()));

        // Mise à jour de l'auteur
        author.setName("Jane Doe");
        authorController.updateAuthor(author);

        // Mise à jour du livre
        book.setPageNumbers(350);
        bookController.updateBook(book);

        // Récupération et affichage de l'auteur mis à jour
        System.out.println("Auteur mis à jour :");
        authorController.getAllAuthors();

        // Récupération et affichage du livre mis à jour
        System.out.println("Livre mis à jour :");
        bookController.getAllBooks().forEach(b -> System.out.println(b.toString()));

        // Suppression du livre
        bookController.deleteBook("B1");

        // Suppression de l'auteur
        authorController.deleteAuthor("A1");

        // Récupération et affichage de tous les auteurs après suppression
        System.out.println("Liste des auteurs après suppression :");
        authorController.getAllAuthors();

        // Récupération et affichage de tous les livres après suppression
        System.out.println("Liste des livres après suppression :");
        bookController.getAllBooks().forEach(b -> System.out.println(b.toString()));
    }
}