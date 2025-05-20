package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.BookGenres;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.CurrentData;
import bg.tu_varna.sit.a1.f23621671.Exceptions.FileStateException;
import bg.tu_varna.sit.a1.f23621671.Exceptions.NoDataException;
import bg.tu_varna.sit.a1.f23621671.Files.CreateFile;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class OpenCommand implements Command {
    @Override
    public void runCommand(String input[]) throws NoDataException, FileStateException {
        if (!CurrentData.getInstance().getCurrentFile().isEmpty()) {
            throw new FileStateException("File already open!");
        }
        String[] books = null;
        if (Files.exists(Path.of(input[0]))) {
            books = ReadFromFile.readFile(input[0]).split("\n");
        } else {
            CreateFile.createFile(input[0]);
            return;
        }
        if (books[0].trim().length() == 0) {
            throw new NoDataException("No books in system!");
        }
        for (String book : books) {
            String[] bookData = book.split(";");
            Library.getInstance().addBook(new Book.BookBuilder(bookData[0], bookData[1], BookGenres.valueOf(bookData[2].toUpperCase(Locale.ROOT)), bookData[3])
                    .withBookDescription(bookData[4])
                    .withBookYear((Integer.parseInt(bookData[5])))
                    .withTags(bookData[6])
                    .withRating(Float.parseFloat(bookData[7]))
                    .build());
        }
        CurrentData.getInstance().setCurrentFile(input[0]);
        File file = new File(input[0]);
        System.out.println("Successfuly opened " + file.getName());
    }
}
