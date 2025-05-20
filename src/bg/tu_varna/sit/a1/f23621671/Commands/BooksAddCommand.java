package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.BookGenres;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.BadDataException;

import java.util.Locale;

public class BooksAddCommand implements Command {
    @Override
    public void runCommand(String input[]) throws BadDataException {
        Book book;
        try {
            book = new Book.BookBuilder(input[0], input[1], BookGenres.valueOf(input[2].toUpperCase(Locale.ROOT)), input[3])
                    .withBookDescription(input[4]).withBookYear(Integer.parseInt(input[5])).withRating(Float.parseFloat(input[6])).withTags(input[7]).build();
        } catch (Exception e) {
            throw new BadDataException("Invalid data entered. Command help: "+CommandEnums.BOOKS_ADD.getDescText());
        }
        if (!Library.getInstance().getBooks().contains(book)) {
            Library.getInstance().addBook(book);
            System.out.println("Book successfully added!");
        } else throw new BadDataException("Book already in library!");
    }
}
