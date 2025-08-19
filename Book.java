public class Book {
    private String title;
    private String author;
    private float userRating;
    private int reviews;
    private double price;
    private int year;
    private String genre;

    public Book(String title, String author, float userRating, int reviews, double price, int year, String genre) {
        this.title = title;
        this.author = author;
        this.userRating = userRating;
        this.reviews = reviews;
        this.price = price;
        this.year = year;
        this.genre = genre;
    }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public double getUserRating() { return userRating; }
    public void setUserRating(float userRating) { this.userRating = userRating; }

    public int getReviews() { return reviews; }
    public void setReviews(int reviews) { this.reviews = reviews; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public void printDetails() {
        System.out.println("----- Book Details -----");
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Rating     : " + userRating);
        System.out.println("Reviews    : " + reviews);
        System.out.println("Price      : $" + price);
        System.out.println("Year       : " + year);
        System.out.println("Genre      : " + genre);
        System.out.println("*".repeat(25));
    }
}
