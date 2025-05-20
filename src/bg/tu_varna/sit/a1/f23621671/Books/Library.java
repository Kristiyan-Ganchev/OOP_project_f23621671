package bg.tu_varna.sit.a1.f23621671.Books;

import bg.tu_varna.sit.a1.f23621671.Exceptions.BookNotFoundException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Singleton class representing a library that manages a collection of {@link Book} objects.
 * Provides functionality to add, remove, retrieve, and clear books.
 */
public class Library {
    private static Set<Book> bookSet;
    private static Library instance = null;

    /**
     * Private constructor to prevent instantiation from outside and initialize the book collection.
     */
    private Library() {
        bookSet = new HashSet<>();
    }

    /**
     * Returns the singleton instance of the Library.
     *
     * @return the single instance of Library
     */
    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    /**
     * Returns an unmodifiable view of the set of books currently in the library.
     *
     * @return an unmodifiable set of books
     */
    public Set<Book> getBooks() {
        return Collections.unmodifiableSet(bookSet);
    }

    /**
     * Adds a book to the library collection.
     * If a book with the same ISBN already exists, it will not be added and a message is printed.
     *
     * @param book the book to add
     */
    public void addBook(Book book) {
        if (!bookSet.add(book)) {
            System.out.println("Book with ISBN " + book.getIsbn() + " already exists!");
        }
    }

    /**
     * Removes a book with the specified ISBN from the library.
     *
     * @param isbn the ISBN of the book to remove
     * @throws BookNotFoundException if no book with the given ISBN is found
     */
    public void removeBook(String isbn) throws BookNotFoundException {
        if (bookSet.contains(new Book.BookBuilder("", "", BookGenres.DEFAULT, isbn)
                .withBookDescription("").withBookYear(0).withRating(0).withTags("").build())) {
            bookSet.remove(new Book.BookBuilder("", "", BookGenres.DEFAULT, isbn)
                    .withBookDescription("").withBookYear(0).withRating(0).withTags("").build());
            System.out.println("Book removed!");
        } else throw new BookNotFoundException("Book not found!");
    }

    /**
     * Clears all books from the library.
     */
    public void clearBooks() {
        bookSet.clear();
    }

    /**
     * Returns the string content of all books in the library formatted for writing,
     * concatenating all book entries separated by newlines.
     *
     * @return a string representing all books in the library
     */
    public static String toContent() {
        StringBuilder content = new StringBuilder();
        for (Book book : getInstance().getBooks()) {
            content.append(book.toWrite());
        }
        if (Library.getInstance().getBooks().isEmpty()) {
            content.setLength(content.length() - 1);
        }
        return content.toString();
    }
}
