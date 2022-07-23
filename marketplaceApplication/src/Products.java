public class Products {
    private static int count;
    final private int id;
    final private String name;
    final private double price;

    public Products(String name, double price){
        this.id = count;
        this.name = name;
        this.price = price;
        count++;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString(){
        return this.id + ". Product: " + this.name + ", Price: " + this.price;
    }
}
