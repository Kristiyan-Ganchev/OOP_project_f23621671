package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.BookNotFoundException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.InvalidCommandArgumentsException;

import java.util.Locale;
import java.util.function.Predicate;

public class BooksFindCommand implements Command {
    @Override
    public void runCommand(String input[]) throws InvalidCommandArgumentsException, BookNotFoundException {
        Predicate<Book> filter;
        switch (input[0].toLowerCase(Locale.ROOT)) {
            case "author": {
                filter = b -> b.getAuthorName().toLowerCase().contains(input[1]);
                break;
            }
            case "title": {
                filter = b -> b.getBookTitle().toLowerCase().contains(input[1]);
                break;
            }
            case "tag": {
                filter = b -> b.getTags().toLowerCase().contains(input[1]);
                break;
            }
            default:
                throw new InvalidCommandArgumentsException("No such search field: " + input[0]);
        }
        boolean found = Library.getInstance().getBooks().stream()
                .filter(filter)
                .peek(book -> System.out.println("Book found!\n" + book))
                .count() > 0;
        if (!found) throw new BookNotFoundException("Book not found!");
    }
}
