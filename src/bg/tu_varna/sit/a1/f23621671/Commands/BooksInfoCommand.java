package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;

/**
 * Command implementation to display detailed information about a book given its ISBN.
 * Prints the book details if found; otherwise, throws a {@link NoDataException}.
 */
public class BooksInfoCommand implements Command {
    /**
     * Executes the info command to find and display a book by its ISBN.
     *
     * @param input an array of input strings where input[0] is the ISBN of the book to find
     * @throws NoDataException if no book with the given ISBN is found in the library
     */
    @Override
    public void runCommand(String input[]) throws NoDataException {
        boolean bookFound = false;
        for (Book book : Library.getInstance().getBooks()) {
            if (book.getIsbn().equalsIgnoreCase(input[0])) {
                bookFound = true;
                System.out.println(book);
            }
        }
        if (!bookFound) throw new NoDataException("No such book");
    }
}