package filemanipulation;

public class Product {
    private String name;
    private int price;
    private int productNumber;

    public Product(int productNumber, String name, int price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getProductNumber() {
        return productNumber;
    }

    @Override
    public String toString() {
        return getProductNumber() + ";" + getName() + ";" + getPrice();
    }
}
