package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.BookGenres;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.BadDataException;

import java.util.Locale;

/**
 * Command implementation for adding a new book to the library.
 * Parses input data, creates a {@link Book} instance, and adds it to the {@link Library}.
 * Throws {@link BadDataException} if the input data is invalid or the book already exists.
 */
public class BooksAddCommand implements Command {
    /**
     * Executes the add book command using the provided input data.
     * The input array is expected to contain:
     * <ul>
     *     <li>input[0] - author name</li>
     *     <li>input[1] - book title</li>
     *     <li>input[2] - book genre (case-insensitive, must match {@link BookGenres})</li>
     *     <li>input[3] - ISBN</li>
     *     <li>input[4] - book description</li>
     *     <li>input[5] - publication year (integer)</li>
     *     <li>input[6] - rating (float)</li>
     *     <li>input[7] - tags</li>
     * </ul>
     *
     * @param input the array of book details
     * @throws BadDataException if the data is invalid or the book already exists in the library
     */
    @Override
    public void runCommand(String input[]) throws BadDataException {
        Book book;
        try {
            book = new Book.BookBuilder(input[0], input[1], BookGenres.valueOf(input[2].toUpperCase(Locale.ROOT)), input[3])
                    .withBookDescription(input[4]).withBookYear(Integer.parseInt(input[5])).withRating(Float.parseFloat(input[6])).withTags(input[7]).build();
        } catch (Exception e) {
            throw new BadDataException("Invalid data entered. Command help: " + CommandEnums.BOOKS_ADD.getDescText());
        }
        if (!Library.getInstance().getBooks().contains(book)) {
            Library.getInstance().addBook(book);
            System.out.println("Book successfully added!");
        } else throw new BadDataException("Book already in library!");
    }
}