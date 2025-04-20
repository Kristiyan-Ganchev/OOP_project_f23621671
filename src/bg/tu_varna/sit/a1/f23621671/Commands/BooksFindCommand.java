package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

public class BooksFindCommand implements Command{
    @Override
    public void runCommand(String input) {
        if(CommandProcessor.currentUser==null){
            System.out.println("Not logged in");
            return;
        }
        String[] option=input.split(" ",2);
        if(option[0].equals("title")){
            for (Book book: CommandProcessor.books) {
                if(book.getBookTitle().equalsIgnoreCase(option[1])){
                    System.out.println("Book found! \n"+book.toString());
                }
            }
        }
        else if(option[0].equals("author")){
            for (Book book: CommandProcessor.books) {
                if(book.getAuthorName().equalsIgnoreCase(option[1])){
                    System.out.println("Book found! \n"+book.toString());
                }
            }
        }
        else if(option[0].equals("tag")){
            for (Book book: CommandProcessor.books) {
                if(book.getTags().equalsIgnoreCase(option[1])){
                    System.out.println("Book found! \n"+book.toString());
                }
            }
        }
        else System.out.println("No such option!");
    }

    @Override
    public void description() {
        System.out.println("books find");
    }
}
