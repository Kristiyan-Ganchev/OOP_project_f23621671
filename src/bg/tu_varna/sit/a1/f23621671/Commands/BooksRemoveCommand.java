package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

public class BooksRemoveCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        CommandProcessor.removeBook(input[0]);
    }
}
