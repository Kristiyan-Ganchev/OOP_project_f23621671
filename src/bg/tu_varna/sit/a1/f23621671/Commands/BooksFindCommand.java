package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

import java.util.Locale;
import java.util.function.Predicate;

public class BooksFindCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        Predicate<Book> filter;
        switch (input[0].toLowerCase(Locale.ROOT)){
            case "author":{
                    filter=b -> b.getAuthorName().toLowerCase().contains(input[1]);
                break;
            }
            case "title":{
                filter=b -> b.getBookTitle().toLowerCase().contains(input[1]);
                break;
            }
            case "tag":{
                filter=b -> b.getTags().toLowerCase().contains(input[1]);
                break;
            }
            default:
                System.out.println("No such search field: " + input[1]);
                return;
        }
        boolean found = CommandProcessor.getBooks().stream()
                .filter(filter)
                .peek(book -> System.out.println("Book found!\n" + book))
                .count() > 0;
        if(!found) System.out.println("Book not found");
    }
}
