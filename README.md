# Prodigy_SD_05
PRODIGY_SD_05

```markdown
# Web Scraping

This project is a web scraping program that extracts product information, such as names, prices, and ratings, from an online e-commerce website and stores the data in a structured format like a CSV file.

## Features

- **Product Information Extraction:** The program extracts product names, prices, and ratings from an e-commerce website.
- **Structured Data Storage:** The extracted data is stored in a CSV file for easy analysis and processing.
- **Dynamic URL Support:** The program can be configured to scrape data from any e-commerce website by providing the URL.

## How to Use

1. Clone this repository to your local machine:

    ```sh
    git clone https://github.com/oraclebrain/web-scraping.git
    ```

2. Navigate to the project directory:

    ```sh
    cd web-scraping
    ```

3. Open the `PRODIGY_SD_05.java` file and replace the `url` variable with the actual URL of the e-commerce website you want to scrape.

4. Compile the Java program:

    ```sh
    javac PRODIGY_SD_05.java
    ```

5. Run the program:

    ```sh
    java PRODIGY_SD_05
    ```

6. Check the generated `product_data.csv` file in the project directory for the extracted product information.

## Example

Suppose the program is configured to scrape data from an e-commerce website. After running the program, it extracts the product names, prices, and ratings and saves them to a CSV file (`product_data.csv`).

```
Product Name,Price,Rating
Product 1, $19.99, 4.5
Product 2, $29.99, 4.2
Product 3, $24.99, 4.7
```

## Code Overview

```java
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class PRODIGY_SD_05 {
    public static void main(String[] args) {
        String url = "https://example-ecommerce-website.com/products";

        try {
            Document document = Jsoup.connect(url).get();
            Elements products = document.select(".product");

            String csvFilePath = "product_data.csv";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(csvFilePath))) {
                writer.write("Product Name,Price,Rating\n");

                for (Element product : products) {
                    String productName = product.select(".product-name").text();
                    String price = product.select(".product-price").text();
                    String rating = product.select(".product-rating").text();

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
```

- The `main` method of the `PRODIGY_SD_05` class initiates the web scraping process.
- The program uses the Jsoup library to connect to the specified URL and extract product information.
- Extracted product data is then written to a CSV file (`product_data.csv`) in a structured format.

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any enhancements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
```

Feel free to customize this `README.md` file further to suit your specific project needs or preferences.
```