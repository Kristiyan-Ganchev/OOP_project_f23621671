package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.BookGenres;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Files.ErrorLogger;

import java.util.Locale;
import java.util.Scanner;

public class BooksAddCommand implements Command{
    @Override
    public void runCommand(String input[]) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Please input book title:");
        String title = scanner.nextLine();
        System.out.println("Please input book author name:");
        String author = scanner.nextLine();
        System.out.println("Please input book genre:");
        String genre = scanner.nextLine().toUpperCase(Locale.ROOT);
        BookGenres bookGenre;
        try {
            bookGenre = BookGenres.valueOf(genre);
        }catch (Exception e){
            System.out.println("Invalid genre option!");
            ErrorLogger.log(e);
            return;
        }
        System.out.println("Please input book description:");
        String description = scanner.nextLine();
        System.out.println("Please input book year:");
        String year = scanner.nextLine();
        System.out.println("Please input book tags:");
        String tags = scanner.nextLine();
        System.out.println("Please input book rating:");
        String rating = scanner.nextLine();
        System.out.println("Please input book isbn:");
        String isbn = scanner.nextLine();
        Book book=new Book.BookBuilder(author,title,bookGenre,isbn).withBookDescription(description).withBookYear(Integer.parseInt(year)).withRating(Float.parseFloat(rating)).witTags(tags).build();
        if(!Library.getInstance().getBooks().contains(book)){
            Library.getInstance().addBook(book);
            System.out.println("Book successfully added!");
        }
        else System.out.println("Book already in list!");
    }
}
