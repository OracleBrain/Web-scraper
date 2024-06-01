import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * The PRODIGY_SD_05 class is a web scraper for e-commerce product data.
 * It uses the Jsoup library to connect to a specified URL and scrape product information.
 * The scraped data is then saved to a CSV file.
 */
public class PRODIGY_SD_05 
{

    public static void main(String[] args) {
        // Replace this URL with the actual URL of the e-commerce website you want to
        // scrape
        String url = "https://example-ecommerce-website.com/products";

        try {
            Document document = Jsoup.connect(url).get();
            Elements products = document.select(".product"); // Adjust the selector based on the HTML structure

            // Specify the CSV file path
            String csvFilePath = "product_data.csv";

            // Write the CSV header
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
                writer.write("Product Name,Price,Rating\n");

                // Extract and write product information to CSV
                for (Element product : products) {
                    String productName = product.select(".product-name").text();
                    String price = product.select(".product-price").text();
                    String rating = product.select(".product-rating").text();

                    // Write the data to CSV
                    writer.write(productName + "," + price + "," + rating + "\n");
                }

                System.out.println("Data has been successfully scraped and saved to " + csvFilePath);
            } catch (IOException e) {
                System.err.println("Error writing to CSV file: " + e.getMessage());
            }

        } catch (IOException e) {
            System.err.println("Error connecting to the website: " + e.getMessage());
        }
    }
}