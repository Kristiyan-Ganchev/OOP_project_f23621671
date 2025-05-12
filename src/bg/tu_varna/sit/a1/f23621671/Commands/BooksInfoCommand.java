package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class BooksInfoCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        for (Book book: CommandProcessor.getBooks())
        {
            if(book.getIsbn().equalsIgnoreCase(input[0]))
                System.out.println(book);
        }
    }
}
