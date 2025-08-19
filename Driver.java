import java.util.*;

public class Driver {
    public static void main(String[] args) {
        DataBaseReader reader;

        reader = new CSVReader();

        List<Book> books = reader.readBooks("bestsellers with categories.csv");

        System.out.println("Total books read: " + books.size());

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Total number of books by an author");
            System.out.println("2. List all authors");
            System.out.println("3. List all books by an author");
            System.out.println("4. List all books with a given rating");
            System.out.println("5. List all books and prices by an author");
            System.out.println("6. List all books by year");
            System.out.println("7. List all books by genre");
            System.out.println("8. Highest rated books");
            System.out.println("9. Most reviewed books");
            System.out.println("10. Average price of books by an author");
            System.out.println("11. Count of books per year");
            System.out.println("12. Count of books per genre");
            System.out.println("13. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.println("Total books: " +
                            BookUtils.getTotalBooksByAuthor(books, author));
                }
                case 2 -> BookUtils.getAllAuthors(books).forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    BookUtils.getBooksByAuthor(books, author).forEach(System.out::println);
                }
                case 4 -> {
                    System.out.print("Enter rating: ");
                    double rating = sc.nextDouble();
                    BookUtils.getBooksByRating(books, rating).forEach(System.out::println);
                }
                case 5 -> {
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    BookUtils.getBooksAndPricesByAuthor(books, author)
                            .forEach((title, price) -> System.out.println(title + " - $" + price));
                }
                case 6 -> {
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    BookUtils.getBooksByYear(books, year).forEach(System.out::println);
                }
                case 7 -> {
                    System.out.print("Enter genre (Fiction/Non Fiction): ");
                    String genre = sc.nextLine();
                    BookUtils.getBooksByGenre(books, genre).forEach(System.out::println);
                }
                case 8 -> BookUtils.getHighestRatedBooks(books).forEach(Book::printDetails);
                case 9 -> BookUtils.getMostReviewedBooks(books).forEach(Book::printDetails);
                case 10 -> {
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.println("Average price: $" +
                            BookUtils.getAveragePriceByAuthor(books, author));
                }
                case 11 -> BookUtils.getBookCountPerYear(books)
                        .forEach((year, count) -> System.out.println(year + " : " + count));
                case 12 -> BookUtils.getBookCountPerGenre(books)
                        .forEach((genre, count) -> System.out.println(genre + " : " + count));
                case 13 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
