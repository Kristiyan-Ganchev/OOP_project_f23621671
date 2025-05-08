package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.BookGenres;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;
import bg.tu_varna.sit.a1.f23621671.Files.ErrorLogger;
import bg.tu_varna.sit.a1.f23621671.Files.ReadFromFile;
import bg.tu_varna.sit.a1.f23621671.Files.WriteToFile;
import bg.tu_varna.sit.a1.f23621671.Users.AccessLevel;

import java.util.Locale;
import java.util.Scanner;

public class BooksAddCommand implements Command{
    @Override
    public void runCommand(String input) {
        System.out.println("Please input book title:");
        String title = new Scanner(System.in).nextLine();
        System.out.println("Please input book author name:");
        String author = new Scanner(System.in).nextLine();
        System.out.println("Please input book genre:");
        String genre = new Scanner(System.in).nextLine().toUpperCase(Locale.ROOT);
        BookGenres bookGenre;
        try {
            bookGenre = BookGenres.valueOf(genre);
        }catch (Exception e){
            System.out.println("Invalid genre option!");
            ErrorLogger.log(e);
            return;
        }
        System.out.println("Please input book description:");
        String description = new Scanner(System.in).nextLine();
        System.out.println("Please input book year:");
        String year = new Scanner(System.in).nextLine();
        System.out.println("Please input book tags:");
        String tags = new Scanner(System.in).nextLine();
        System.out.println("Please input book rating:");
        String rating = new Scanner(System.in).nextLine();
        System.out.println("Please input book isbn:");
        String isbn = new Scanner(System.in).nextLine();
        Book book=new Book.BookBuilder(author,title,bookGenre,isbn).withBookDescription(description).withBookYear(Integer.parseInt(year)).withRating(Float.parseFloat(rating)).witTags(tags).build();
        if(!CommandProcessor.books.stream().anyMatch(book1->book1.getIsbn().equalsIgnoreCase(book.getIsbn()))){
            CommandProcessor.books.add(book);
            System.out.println("Book successfully added!");
        }
        else System.out.println("Book already in list!");
        CommandProcessor.addBook(book);
    }
}
