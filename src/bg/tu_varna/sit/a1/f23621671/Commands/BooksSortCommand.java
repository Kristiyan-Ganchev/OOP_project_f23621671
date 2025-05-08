package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.CommandProcessor;

import java.util.*;

public class BooksSortCommand implements Command{
    private Comparator<Book> getComparator(String criteria, boolean asc) {
        Comparator<Book> comp;

        switch (criteria.toLowerCase()) {
            case "title":
                comp = Comparator.comparing(Book::getBookTitle, String.CASE_INSENSITIVE_ORDER);
                break;
            case "author":
                comp = Comparator.comparing(Book::getAuthorName, String.CASE_INSENSITIVE_ORDER);
                break;
            case "year":
                comp = Comparator.comparingInt(Book::getBookYear);
                break;
            case "rating":
                comp = Comparator.comparingDouble(Book::getRating);
                break;
            default:
                return null;
        }

        return asc ? comp : comp.reversed();
    }
    @Override
    public void runCommand(String input) {
        /*if(CommandProcessor.getBooks().isEmpty()){
            System.out.println("No books in list!");
            return;
        }*/
        String[] tokens = input.trim().split("\\s+");
        if (tokens.length == 0) {
            System.out.println("Missing sort criteria!");
            return;
        }

        String criteria = tokens[0];
        boolean asc = true;

        if (tokens.length > 1) {
            if (tokens[1].equalsIgnoreCase("desc")) {
                asc = false;
            } else if (!tokens[1].equalsIgnoreCase("asc")) {
                System.out.println("Invalid order! Use 'asc' or 'desc'.");
                return;
            }
        }

        Comparator<Book> comparator = getComparator(criteria, asc);
        if (comparator == null) {
            System.out.println("Invalid sorting criteria.");
            return;
        }

        List<Book> sorted = mergeSort(new ArrayList<>(CommandProcessor.books), comparator);
        CommandProcessor.books = new ArrayList<>(sorted);

        System.out.println("Books sorted by " + criteria + " in " + (asc ? "ascending" : "descending") + " order.");
    }
    private List<Book> mergeSort(List<Book> list, Comparator<Book> comparator) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Book> left = mergeSort(list.subList(0, mid), comparator);
        List<Book> right = mergeSort(list.subList(mid, list.size()), comparator);

        return merge(left, right, comparator);
    }

    private List<Book> merge(List<Book> left, List<Book> right, Comparator<Book> comparator) {
        List<Book> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            if (comparator.compare(left.get(i), right.get(j)) <= 0) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }
}
