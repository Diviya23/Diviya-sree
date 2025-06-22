import java.util.HashMap;
import java.util.Map;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    public Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public void update(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }

    public void printProduct() {
        System.out.println("ID: " + productId + ", Name: " + productName +
                           ", Quantity: " + quantity + ", Price: $" + price);
    }
}

public class InventoryManagement {
    Map<Integer, Product> inventory;

    public InventoryManagement() {
        inventory = new HashMap<>();
    }

   
    public void addProduct(int id, String name, int quantity, double price) {
        if (inventory.containsKey(id)) {
            System.out.println("Product ID " + id + " already exists.");
        } else {
            Product product = new Product(id, name, quantity, price);
            inventory.put(id, product);
            System.out.println("Product added.");
        }
    }

   
    public void updateProduct(int id, int quantity, double price) {
        Product product = inventory.get(id);
        if (product != null) {
            product.update(quantity, price);
            System.out.println("Product updated.");
        } else {
            System.out.println("Product not found.");
        }
    }

   
    public void deleteProduct(int id) {
        if (inventory.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

   
    public void displayProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            for (Product p : inventory.values()) {
                p.printProduct();
            }
        }
    }

   
    public static void main(String[] args) {
        InventoryManagement ims = new InventoryManagement();

        ims.addProduct(101, "Laptop", 50, 1200.0);
        ims.addProduct(102, "Smartphone", 200, 700.0);
        ims.addProduct(103, "Tablet", 80, 300.0);

        System.out.println("\nInventory List:");
        ims.displayProducts();

        ims.updateProduct(102, 180, 680.0);

        System.out.println("\nAfter Update:");
        ims.displayProducts();

        ims.deleteProduct(103);

        System.out.println("\nAfter Deletion:");
        ims.displayProducts();
    }
}
