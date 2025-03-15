package bg.tu_varna.sit.a1.f23621671.Books;

public class Book {
    private final String authorName;
    private final String bookTitle;
    private final String bookGenre;
    private final String bookDescription;
    private final int bookYear;
    private final String tags;
    private final float rating;
    private final String isbn;

    private Book(BookBuilder bookBuilder){
        this.authorName=bookBuilder.authorName;
        this.bookTitle= bookBuilder.bookTitle;
        this.bookGenre=bookBuilder.bookGenre;
        this.bookDescription=bookBuilder.bookDescription;
        this.bookYear=bookBuilder.bookYear;
        this.tags=bookBuilder.tags;
        this.rating=bookBuilder.rating;
        this.isbn=bookBuilder.isbn;
    }
    public static class BookBuilder{
        private String authorName;
        private String bookTitle;
        private String bookGenre;
        private String bookDescription;
        private int bookYear;
        private String tags;
        private float rating;
        private String isbn;

        public BookBuilder(String authorName,String bookTitle,String bookGenre,String isbn){
            this.authorName=authorName;
            this.bookTitle=bookTitle;
            this.bookGenre=bookGenre;
            this.isbn=isbn;
        }
        public BookBuilder withBookDescription(String description){
            this.bookDescription=description;
            return this;
        }
        public BookBuilder withBookYear(int year){
            this.bookYear=year;
            return this;
        }
        public BookBuilder witTags(String tags){
            this.tags=tags;
            return this;
        }
        public BookBuilder withRating(float rating){
            this.rating=rating;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }
}
