import java.io.*;
import java.util.*;

public class CSVReader extends DataBaseReader {

    @Override
    public List<Book> readBooks(String fileName) {
        List<Book> books = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (fields.length == 7) {
                    try {
                        String title = fields[0].replace("\"", "");
                        String author = fields[1];
                        float rating = Float.parseFloat(fields[2]);
                        int reviews = Integer.parseInt(fields[3]);
                        double price = Double.parseDouble(fields[4]);
                        int year = Integer.parseInt(fields[5]);
                        String genre = fields[6];

                        books.add(new Book(title, author, rating, reviews, price, year, genre));
                    } catch (NumberFormatException e) {
                        System.err.println("Skipping malformed line: " + line);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return books;
    }
}
