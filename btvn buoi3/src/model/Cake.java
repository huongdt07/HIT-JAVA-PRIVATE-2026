package src.model;

public class Cake extends Product {
    private String brand;

    public Cake(String id, String name, double price, int stock, String brand) {
        super(id, name, price, stock);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public boolean isExpensive() {
        return getPrice() > 100000;
    }

    @Override
    public String toString() {
        return super.toString() + " | Thương hiệu: " + brand;
    }
}



