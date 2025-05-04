package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class BooksRemoveCommand implements Command{
    @Override
    public void runCommand(String input) {
        boolean bookExists=false;
//        for (Book book: CommandProcessor.books) {
//            if (book.getIsbn().equals(input)) {
//                bookExists=true;
//                CommandProcessor.books.remove(book);
//                break;
//            }
//        }
        if(CommandProcessor.books.removeIf(book -> book.getIsbn().equalsIgnoreCase(input)))
            System.out.println("Book removed!");
        else System.out.println("No such book!");
    }

    @Override
    public void description() {
        System.out.println("books remove");
    }
}
