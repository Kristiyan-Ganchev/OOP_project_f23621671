package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;

public class BooksInfoCommand implements Command {
    @Override
    public void runCommand(String input[]) throws NoDataException {
        boolean bookFound=false;
        for (Book book : Library.getInstance().getBooks()) {
            if (book.getIsbn().equalsIgnoreCase(input[0])){
                bookFound=true;
                System.out.println(book);
            }
        }
        if(!bookFound) throw new NoDataException("No such book");
    }
}
