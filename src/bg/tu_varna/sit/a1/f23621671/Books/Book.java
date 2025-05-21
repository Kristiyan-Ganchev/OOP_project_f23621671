package bg.tu_varna.sit.a1.f23621671.Books;

/**
 * Represents a book with details such as author name, title, genre, description,
 * publication year, tags, rating, and ISBN.
 * Instances of this class are immutable and can be created using the {@link Book.BookBuilder}.
 */
public class Book {
    private final String authorName;
    private final String bookTitle;
    private final BookGenres bookGenre;
    private final String bookDescription;
    private final int bookYear;
    private final String tags;
    private final float rating;
    private final String isbn;

    /**
     * Private constructor used by the {@link BookBuilder} to create a new Book instance.
     *
     * @param bookBuilder the builder containing the book details
     */
    private Book(BookBuilder bookBuilder) {
        this.authorName = bookBuilder.authorName;
        this.bookTitle = bookBuilder.bookTitle;
        this.bookGenre = bookBuilder.bookGenre;
        this.bookDescription = bookBuilder.bookDescription;
        this.bookYear = bookBuilder.bookYear;
        this.tags = bookBuilder.tags;
        this.rating = bookBuilder.rating;
        this.isbn = bookBuilder.isbn;
    }

    /**
     * Compares this book to the specified object for equality based on ISBN.
     *
     * @param o the object to compare with
     * @return true if the given object is a Book with the same ISBN, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return isbn.equals(book.isbn);
    }

    /**
     * Returns the hash code for this book based on its ISBN.
     *
     * @return the hash code of the ISBN string
     */
    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    /**
     * Returns the author name of the book.
     *
     * @return the author name
     */
    public String getAuthorName() {
        return authorName;
    }

    /**
     * Returns the title of the book.
     *
     * @return the book title
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * Returns the genre of the book.
     *
     * @return the book genre
     */
    public BookGenres getBookGenre() {
        return bookGenre;
    }

    /**
     * Returns the description of the book.
     *
     * @return the book description
     */
    public String getBookDescription() {
        return bookDescription;
    }

    /**
     * Returns the publication year of the book.
     *
     * @return the book year
     */
    public int getBookYear() {
        return bookYear;
    }

    /**
     * Returns the tags associated with the book.
     *
     * @return the tags string
     */
    public String getTags() {
        return tags;
    }

    /**
     * Returns the rating of the book.
     *
     * @return the book rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * Returns the ISBN of the book.
     *
     * @return the ISBN string
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Returns a string representation of the book in a format suitable for file writing.
     * The fields are separated by semicolons and the string ends with a newline character.
     *
     * @return a semicolon-separated string representing the book
     */
    public String toWrite() {
        return authorName + ';' +
                bookTitle + ';' +
                bookGenre + ';' +
                isbn + ';' +
                bookDescription + ';' +
                bookYear + ';' +
                tags + ';' +
                rating + '\n';
    }

    /**
     * Returns a string representation of the book with detailed information.
     *
     * @return a string describing the book
     */
    @Override
    public String toString() {
        return "AUTHOR:" + authorName +
                "| TITLE:" + bookTitle +
                "| GENRE:" + bookGenre +
                "| DESCRIPTION:" + bookDescription +
                "| BOOKYEAR:" + bookYear +
                "| TAGS:" + tags +
                "| RATING:" + rating +
                "| ISBN:" + isbn;
    }

    /**
     * Builder class for creating immutable {@link Book} instances.
     */
    public static class BookBuilder {
        private String authorName;
        private String bookTitle;
        private BookGenres bookGenre;
        private String bookDescription;
        private int bookYear;
        private String tags;
        private float rating;
        private String isbn;

        /**
         * Constructs a new BookBuilder with required book details.
         *
         * @param authorName the author of the book
         * @param bookTitle  the title of the book
         * @param bookGenre  the genre of the book
         * @param isbn       the ISBN identifier of the book
         */
        public BookBuilder(String authorName, String bookTitle, BookGenres bookGenre, String isbn) {
            this.authorName = authorName;
            this.bookTitle = bookTitle;
            this.bookGenre = bookGenre;
            this.isbn = isbn;
        }

        /**
         * Sets the description of the book.
         *
         * @param description the book description
         * @return this builder instance for chaining
         */
        public BookBuilder withBookDescription(String description) {
            this.bookDescription = description;
            return this;
        }

        /**
         * Sets the publication year of the book.
         *
         * @param year the publication year
         * @return this builder instance for chaining
         */
        public BookBuilder withBookYear(int year) {
            this.bookYear = year;
            return this;
        }

        /**
         * Sets the tags associated with the book.
         *
         * @param tags the tags string
         * @return this builder instance for chaining
         */
        public BookBuilder withTags(String tags) {
            this.tags = tags;
            return this;
        }

        /**
         * Sets the rating of the book.
         *
         * @param rating the rating value
         * @return this builder instance for chaining
         */
        public BookBuilder withRating(float rating) {
            this.rating = rating;
            return this;
        }

        /**
         * Builds and returns a new {@link Book} instance based on the current builder state.
         *
         * @return a new Book object
         */
        public Book build() {
            return new Book(this);
        }
    }
}
