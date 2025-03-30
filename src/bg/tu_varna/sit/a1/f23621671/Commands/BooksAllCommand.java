package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;

public class BooksAllCommand implements Command{
    @Override
    public void runCommand(String input) {
        for (Book book: CommandProcessor.books) {
            System.out.println("TITLE: "+book.getBookTitle()+" AUTHOR: "+book.getAuthorName()+" GENRE: "+book.getBookGenre()+" ISBN: "+book.getIsbn());
        }
    }

    @Override
    public void description() {
        System.out.println("books all");
    }
}
