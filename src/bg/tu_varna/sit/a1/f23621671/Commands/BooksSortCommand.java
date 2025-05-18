package bg.tu_varna.sit.a1.f23621671.Commands;

import bg.tu_varna.sit.a1.f23621671.Books.Book;
import bg.tu_varna.sit.a1.f23621671.Books.Library;
import bg.tu_varna.sit.a1.f23621671.Exceptions.InvalidCommandArgumentsException;

import java.util.*;

public class BooksSortCommand implements Command {
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
    public void runCommand(String input[]) throws InvalidCommandArgumentsException {
        String[] argArr = input[0].split(" ", 2);
        String criteria = argArr[0];
        boolean asc = true;

        if (argArr.length > 1) {
            if (argArr[1].equalsIgnoreCase("desc")) {
                asc = false;
            } else if (!argArr[1].equalsIgnoreCase("asc")) {
                throw new InvalidCommandArgumentsException("Invalid order! Use 'asc' or 'desc'.");
            }
        }
        System.out.println(criteria);
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
