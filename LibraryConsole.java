/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Library;

import java.util.List;
import java.util.Scanner;

public class LibraryConsole {

    private static final Scanner input = new Scanner(System.in);
    private static final Library library = new Library();

    public static void main(String[] args) {
        while (true) {
            printMenu();
            int choice = scanChoice();
            handleCommand(choice);
        }

    }

    private static void printMenu() {
        System.out.println("1. List Books");
        System.out.println("2. Add Book");
        System.out.println("3. Update Book");
        System.out.println("4. Delete Book");
        System.out.println("5. Show Book Details");
        System.out.println("6. Load Books");
        System.out.println("7. Store Books");
        System.out.println("0. Exit");

    }

    private static int scanChoice() {
        System.out.println("Enter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    private static void handleCommand(int choice) {
        System.out.println("Processing choice: " + choice);
        switch (choice) {
            case 1:
                listBooks();
                break;
            case 2:
                insertBook();
                break;
            case 3:
                updateBook();
                break;
            case 4:
                deleteBook();
                break;
            case 5:
                selectBook();
                break;
            case 6:
                loadBooks();
                break;
            case 7:
                storeBooks();
                break;
            case 0:
                exitLibrary();
                break;
            default:
                System.out.println("Invalid choice, please try again: ");
        }

    }

    private static Book findBook(long bookId) {
        for (Book book : library.getBookList()) {
            if (bookId == book.getBookId()) {
                return book;
            }
        }
        System.out.println("No Such Book With This Id. Please Try Again Student ID: ");
        long otherbookId = input.nextLong();
        return findBook(otherbookId);
    }

    private static void listBooks() {
        System.out.println("Listing Books...");
        List<Book> bookList = library.getBookList();
        if (!bookList.isEmpty()) {
            bookList.forEach(System.out::println);
        } else {
            System.out.println("No books found in the Library.");
        }
    }

    private static void insertBook() {
        System.out.println("Adding Book...");
        System.out.println("Book ID: ");
        long bookId = input.nextLong();
        System.out.println("Name of the Book: ");
        String nameOfBook = input.next();
        System.out.println("Category of the Book: ");
        String categoryOfBook = input.next();
        System.out.println("Author of the Book: ");
        String authorOfBook = input.next();
        System.out.println("Publishing House of the Book: ");
        String publishingHouseOfBook = input.next();
        Book book = new Book(bookId, nameOfBook, categoryOfBook, authorOfBook, publishingHouseOfBook);
        library.getBookList().add(book);
        System.out.println("Book has been added to the library");
    }

    private static void updateBook() {
        System.out.println("Updating Book...");
        System.out.println("Book ID: ");
        long bookId = input.nextLong();
        Book book = findBook(bookId);
        System.out.println("Name of the Book: ");
        String booknameOfBook = input.next();
        book.setNameOfBook(booknameOfBook);
        System.out.println("Category of the Book: ");
        String categoryOfBook = input.next();
        book.setCategoryOfBook(categoryOfBook);
        System.out.println("Author of the Book: ");
        String authorOfBook = input.next();
        book.setAuthorOfBook(authorOfBook);
        System.out.println("Publishing House of the Book: ");
        String publishingHouseOfBook = input.next();
        book.setPublishingHouseOfBook(publishingHouseOfBook);
        System.out.println("Book has been updated successfully");

    }

    private static void deleteBook() {
        System.out.println("Deleting Book...");
        System.out.println("Book ID: ");
        long bookId = input.nextLong();
        Book book = findBook(bookId);
        library.getBookList().remove(book);
        System.out.println("Book has been deleted successfully");

    }

    private static void selectBook() {
        System.out.println("Displaying Book...");
        System.out.println("Book ID: ");
        long bookId = input.nextLong();
        Book book = findBook(bookId);
        System.out.println(book);

    }

    private static void loadBooks() {
        System.out.println("Loading Books...");
        Loader loader = new Loader();
        library.setBookList(loader.load());
        System.out.println("Books have been loaded successfully");

    }

    private static void storeBooks() {
        System.out.println("Storing Books...");
        Storer storer = new Storer();
        Runnable runnable = () -> {
            storer.store(library.getBookList());
            System.out.println("Books have been stored");
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    private static void exitLibrary() {
        System.out.println("Exiting the Library.");
        System.exit(0);
    }
}
