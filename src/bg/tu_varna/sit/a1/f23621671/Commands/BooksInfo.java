package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class BooksInfo implements Command{
    @Override
    public void runCommand(String input) {
        if(CommandProcessor.currentUser==null){
            System.out.println("Not logged in");
            return;
        }
        for (Book book: CommandProcessor.books)
        {
            if(book.getIsbn().equals(input)) System.out.println(book.toString());
        }
    }

    @Override
    public void description() {
        System.out.println("books info");
    }
}
