package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class BooksInfoCommand implements Command{
    @Override
    public void runCommand(String input) {
        /*if(CommandProcessor.getBooks().isEmpty()){
            System.out.println("No books in list!");
            return;
        }*/
        for (Book book: CommandProcessor.books)
        {
            if(book.getIsbn().equalsIgnoreCase(input)) System.out.println(book.toString());
        }
        for (Book book: CommandProcessor.getBooks())
        {
            if(book.getIsbn().equalsIgnoreCase(input))
                System.out.println(book.toString());
        }
    }
}
