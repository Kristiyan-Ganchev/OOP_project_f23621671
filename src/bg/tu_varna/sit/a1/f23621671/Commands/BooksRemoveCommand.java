package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Library;

public class BooksRemoveCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        Library.getInstance().removeBook(input[0]);
    }
}
