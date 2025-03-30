package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;

public class OpenCommand implements Command{
    @Override
    public void runCommand(String input) {
        String[] books=ReadFromFile.readFile(input).split("\n");
        for (String book: books) {
            String[] bookData= book.split(";");
            CommandProcessor.books.add(new Book.BookBuilder(bookData[0],bookData[1],bookData[2],bookData[3])
                    .withBookDescription(bookData[4])
                    .withBookYear((Integer.parseInt(bookData[5])))
                    .witTags(bookData[6])
                    .withRating(Float.parseFloat(bookData[7]))
                    .build());
        }
        CommandProcessor.currentFile=input;
        System.out.println("Successfuly opened "+input);
    }
    @Override
    public void description(){
        System.out.println("open <file>\t\t  opens <file>\n");
    }
}
