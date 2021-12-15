package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {
    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        List<String> productsString;
        try {
            productsString = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        createProductsList(productsString);
    }

    public void writePriceOverToFile(Path path, int minPrice) {
        List<String> aboveMinPriceProduct = createAboveMinPriceProducts(minPrice);
        try {
            Files.write(path, aboveMinPriceProduct);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private List<Product> createProductsList(List<String> productsString) {
        for (String s : productsString) {
            String[] strings = s.split(";");
            products.add(new Product(Integer.parseInt(strings[0]), strings[1], Integer.parseInt(strings[2])));
        }
        return products;
    }

    private List<String> createAboveMinPriceProducts(int minPrice) {
        List<String> aboveMinPriceProduct = new ArrayList<>();
        for (Product p : products) {
            if (p.getPrice() > minPrice) {
                aboveMinPriceProduct.add((new Product(p.getProductNumber(), p.getName(), p.getPrice())).toString());
            }
        }
        return aboveMinPriceProduct;
    }
}
