package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.Library;

/**
 * Command implementation to display all books currently stored in the library.
 * Prints basic information (title, author, genre, ISBN) for each book to the console.
 */
public class BooksAllCommand implements Command {
    /**
     * Executes the command to list all books in the library.
     * Ignores the input parameter.
     *
     * @param input an array of input strings (not used)
     */
    @Override
    public void runCommand(String input[]) {
        for (Book book : Library.getInstance().getBooks()) {
            System.out.println("TITLE: " + book.getBookTitle() + " AUTHOR: " + book.getAuthorName() + " GENRE: " + book.getBookGenre() + " ISBN: " + book.getIsbn());
        }
    }
}
