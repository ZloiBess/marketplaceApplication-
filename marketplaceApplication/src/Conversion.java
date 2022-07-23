public class Conversion {

    public static void buy(Persons person, Products product){

        double money = person.getAmountOfMoney() - product.getPrice();

        if(money >= 0){
            System.out.println("\n  >>>Purchase Completed!<<<");

            person.setAmountOfMoney(money);
            person.addProduct(product);

        }else{

            System.out.println("!!!Not enough money!!!");
        }
    }





}
