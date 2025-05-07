package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

public class BooksRemoveCommand implements Command{
    @Override
    public void runCommand(String input) {
        if(CommandProcessor.currentUser==null){
            System.out.println("Not logged in");
            return;
        }
        else if(CommandProcessor.currentUser.getAccessLevel().equals(AccessLevel.ADMINISTRATOR)){
            System.out.println("User is not administrator!");
            return;
        }
        if(CommandProcessor.books.isEmpty()){
            System.out.println("No books in list!");
            return;
        }
        if(input.isEmpty()){
            System.out.println("Please input book isbn!");
        }
        if(CommandProcessor.books.removeIf(book -> book.getIsbn().equalsIgnoreCase(input)))
            System.out.println("Book removed!");
        else System.out.println("No such book!");
    }

    @Override
    public void description() {
        System.out.println("books remove");
    }
}
