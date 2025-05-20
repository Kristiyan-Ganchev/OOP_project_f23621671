package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.InvalidCommandArgumentsException;

import java.util.*;

/**
 * Command implementation to sort and display books in the library based on a specified criterion.
 * Supports sorting by title, author, year, or rating, in ascending or descending order.
 * Uses a custom merge sort implementation.
 */
public class BooksSortCommand implements Command {
    /**
     * Returns a comparator for books based on the given criteria and order.
     *
     * @param criteria the field to sort by ("title", "author", "year", or "rating")
     * @param asc      true for ascending order, false for descending
     * @return a Comparator<Book> or null if criteria is invalid
     */
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

    /**
     * Executes the sort command using input arguments.
     * The first argument specifies the sorting criteria.
     * The second argument (optional) specifies the order: "asc" or "desc" (default is ascending).
     *
     * @param input input arguments; input[0] is the criteria, input[1] (optional) is the order
     * @throws InvalidCommandArgumentsException if the criteria or order is invalid
     */
    @Override
    public void runCommand(String input[]) throws InvalidCommandArgumentsException {
        String criteria = input[0];
        boolean asc = true;

        if (input.length > 1) {
            if (input[1].equalsIgnoreCase("desc")) {
                asc = false;
            } else if (!input[1].equalsIgnoreCase("asc")) {
                throw new InvalidCommandArgumentsException("Invalid order! Use 'asc' or 'desc'.");
            }
        }
        Comparator<Book> comparator = getComparator(criteria, asc);
        if (comparator == null) {
            throw new InvalidCommandArgumentsException("Invalid sorting criteria!");
        }

        List<Book> sorted = mergeSort(new ArrayList<>(Library.getInstance().getBooks()), comparator);
        for (Book book : sorted
        ) {
            System.out.println(book);
        }

        System.out.println("Books sorted by " + criteria + " in " + (asc ? "ascending" : "descending") + " order.");
    }

    /**
     * Performs a merge sort on the given list using the specified comparator.
     *
     * @param list       the list to sort
     * @param comparator the comparator to determine order
     * @return a new sorted list
     */
    private List<Book> mergeSort(List<Book> list, Comparator<Book> comparator) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Book> left = mergeSort(list.subList(0, mid), comparator);
        List<Book> right = mergeSort(list.subList(mid, list.size()), comparator);

        return merge(left, right, comparator);
    }

    /**
     * Merges two sorted lists into one sorted list using the comparator.
     *
     * @param left       the first sorted list
     * @param right      the second sorted list
     * @param comparator the comparator to determine order
     * @return a merged sorted list
     */
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