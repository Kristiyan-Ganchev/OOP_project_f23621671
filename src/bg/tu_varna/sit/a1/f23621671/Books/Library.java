package bg.tu_varna.sit.a1.f23621671.Books;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Library {
    private static Set<Book> bookSet;
    private static Library instance = null;
    private Library(){
         bookSet = new HashSet<>();
    }
    public static Library getInstance(){
        if(instance==null){
            instance=new Library();
        }
        return instance;
    }
    public  Set<Book> getBooks() {
        return Collections.unmodifiableSet(bookSet);
    }
    public  void addBook(Book book){
        if (!bookSet.add(book)) {
            System.out.println("Book with ISBN " + book.getIsbn() + " already exists!");
        }
    }
    public  void removeBook(String isbn){
        if (bookSet.removeIf(book -> book.getIsbn().equalsIgnoreCase(isbn))) {
            System.out.println("Book removed!");
        }
        else System.out.println("Book not found");
    }
    public  void clearBooks() {
        bookSet.clear();
    }
}
