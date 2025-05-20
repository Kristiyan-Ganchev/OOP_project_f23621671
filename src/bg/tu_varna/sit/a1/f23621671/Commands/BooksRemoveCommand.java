package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.BookNotFoundException;

/**
 * Command implementation to remove a book from the library based on its ISBN.
 */
public class BooksRemoveCommand implements Command {
    /**
     * Executes the remove book command by removing the book with the given ISBN.
     *
     * @param input an array of input strings where input[0] is the ISBN of the book to remove
     * @throws BookNotFoundException if the book with the specified ISBN does not exist in the library
     */
    @Override
    public void runCommand(String input[]) throws BookNotFoundException {
        Library.getInstance().removeBook(input[0]);
    }
}
