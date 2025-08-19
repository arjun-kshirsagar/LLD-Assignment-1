import java.util.*;
import java.util.stream.Collectors;

public class BookUtils {

    public static long getTotalBooksByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .count();
    }

    public static Set<String> getAllAuthors(List<Book> books) {
        return books.stream()
                .map(Book::getAuthor)
                .collect(Collectors.toCollection(TreeSet::new)); // sorted set
    }

    public static List<String> getBooksByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public static List<String> getBooksByRating(List<Book> books, double rating) {
        return books.stream()
                .filter(b -> b.getUserRating() == rating)
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public static Map<String, Double> getBooksAndPricesByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toMap(Book::getTitle, Book::getPrice));
    }

    public static List<String> getBooksByYear(List<Book> books, int year) {
        return books.stream()
                .filter(b -> b.getYear() == year)
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public static List<String> getBooksByGenre(List<Book> books, String genre) {
        return books.stream()
                .filter(b -> b.getGenre().equalsIgnoreCase(genre))
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    public static List<Book> getHighestRatedBooks(List<Book> books) {
        double maxRating = books.stream()
                .mapToDouble(Book::getUserRating)
                .max()
                .orElse(0);
        return books.stream()
                .filter(b -> b.getUserRating() == maxRating)
                .collect(Collectors.toList());
    }

    public static List<Book> getMostReviewedBooks(List<Book> books) {
        int maxReviews = books.stream()
                .mapToInt(Book::getReviews)
                .max()
                .orElse(0);
        return books.stream()
                .filter(b -> b.getReviews() == maxReviews)
                .collect(Collectors.toList());
    }

    public static double getAveragePriceByAuthor(List<Book> books, String author) {
        return books.stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .mapToDouble(Book::getPrice)
                .average()
                .orElse(0);
    }

    public static Map<Integer, Long> getBookCountPerYear(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getYear, TreeMap::new, Collectors.counting()));
    }

    public static Map<String, Long> getBookCountPerGenre(List<Book> books) {
        return books.stream()
                .collect(Collectors.groupingBy(Book::getGenre, Collectors.counting()));
    }
}
