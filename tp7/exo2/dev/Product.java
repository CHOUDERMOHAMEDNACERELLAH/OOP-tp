package tp7.exo2.dev;

public class Product extends IntegratedElement {
    private static final long serialVersionUID = 1L;

    private double price;
    private int stock;

    public Product(String id, String name, double price, int stock) {
        super(id, name, "Product");
        this.price = price;
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public void validate() throws InvalidDataException {
        validateCommon();
        if (price <= 0) {
            throw new InvalidPriceException("Invalid price: " + price + " (must be > 0)");
        }
        if (stock < 0) {
            throw new InvalidDataException("Stock cannot be negative.");
        }
    }

    @Override
    public String toTextLine() {
        return "PRODUCT;" + getId() + ";" + getName() + ";" + price + ";" + stock;
    }

    @Override
    public String display() {
        return super.display() + ", price=" + price + ", stock=" + stock;
    }
}
