import java.util.ArrayList;
import java.util.List;

public class Persons {
   private static int count;
   final private int id;
   final private String firstName;
   final private String lastName;
   private double amountOfMoney;
   final private List<Products> productsList;


    public Persons(String firstName, String lastName, double amountOfMoney){
        this.productsList = new ArrayList<>();
        this.id = count;
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
        count ++;
    }

    public int getId(){
        return this.id;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAmountOfMoney(){
        return this.amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void addProduct(Products product){
        this.productsList.add(product);
    }

    public void getProducts() {
        if (productsList.isEmpty()) {
            System.out.print("""
                             
                                 Empty...
                    >>>You have to buy something...<<<
                    """);
        } else {
            System.out.printf("\n__/All_%s_id(%d)_Products\\__\n", getFirstName(), getId());
            for (Products p : productsList) {
                System.out.println(p);
            }
        }
    }

    @Override
    public String toString(){
         return this.id + ". First_name:" + this.firstName + ", Last_name:"+ this.lastName +
                ", Amount_of_money:" + this.amountOfMoney;
    }
}
