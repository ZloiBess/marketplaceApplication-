import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainSystem {
    private Persons person;
    private Products product;
    private final List<Persons> personsList;
    private final List<Products> productsList;


    public MainSystem() {
        personsList = new ArrayList<>();
        productsList = new ArrayList<>();
    }


    public void startSystem() {
        Scanner scan = new Scanner(System.in);

        boolean exit = true;
        while (exit) {

            printMenu();

            String choice = scan.nextLine();
            switch (choice) {
                case "1":
                    createPerson();
                    break;

                case "2":
                    createProduct();
                    break;

                case "3":
                    printAllPersons();
                    backMenu();
                    break;

                case "4":
                    printAllProducts();
                    backMenu();
                    break;

                case "5":
                    buyProducts();
                    break;

                case "6":
                    printWhoBoughtWhat();
                    break;

                case "7":
                    System.out.println("Bye!");
                    exit = false;
                    scan.close();
                    break;

                default:
                    System.out.println("default!");
                    break;
            }
        }
    }


    private void printMenu() {
        System.out.print("""
                \n_________/MAIN__MENU\\_________
                1.Create Person                ->
                2.Create Product               ->
                3.Print a list of all Person   ->
                4.Print a list of all Products ->
                5.***Buy a Product***          ->
                6.Print Who Bought What        ->
                7.Exit                         ->
                """);
        System.out.print("Your choice:");
    }


    private void backMenu() {
        while (true) {
            System.out.println("\n<- back menu  -1.");
            System.out.print("Your choice:");
            Scanner scan = new Scanner(System.in);
            String back = scan.nextLine();

            if (back.equals("-1")) {
                break;
            }
        }
    }


    private void createPerson() {
        System.out.println("\n_______/CREATE__PERSON\\_______");
        Scanner scan = new Scanner(System.in);

        System.out.print("1.Write a First Name:");
        String firstName = scan.nextLine();

        System.out.print("2.Write a Last Name:");
        String lastName = scan.nextLine();

        System.out.print("3.Write the amount of money:");
        double amountOfMoney = 0;

        while (scan.hasNextLine()) {
            if (scan.hasNextDouble()) {
                amountOfMoney = scan.nextDouble();
                break;
            } else {
                System.out.print("3.Write the amount of money:");
                scan.next();
            }
        }
        this.person = new Persons(firstName, lastName, amountOfMoney);
        personsList.add(person);

        System.out.println("""
                       >>>Complied!<<<
                """ + person);
        backMenu();
    }


    private void createProduct() {
        System.out.println("\n______/CREATE__PRODUCT\\______");
        Scanner scan = new Scanner(System.in);

        System.out.print("1.Write Name Product:");
        String name = scan.nextLine();

        System.out.print("2.Write Price:");
        double price = 0;

        while (scan.hasNextLine()) {
            if (scan.hasNextDouble()) {
                price = scan.nextDouble();
                break;
            } else {
                System.out.print("2.Write Price:");
                scan.next();
            }
        }
        this.product = new Products(name, price);
        productsList.add(product);

        System.out.println("""
                       >>>Complied!<<<
                """ + product);
        backMenu();
    }


    private boolean printAllPersons() {
        System.out.println("\n_____/PRINT_PERSON_LIST\\_____");
        if (personsList.size() > 0) {
            for (Persons p : personsList) {
                System.out.println(p);
            }
            return true;
        } else {
            System.out.println("Empty! Create Person...");
            return false;
        }
    }


    private boolean printAllProducts() {
        System.out.println("\n____/PRINT_PRODUCTS_LIST\\____");
        if (productsList.size() > 0) {
            for (Products p : productsList) {
                System.out.println(p);
            }
            return true;
        } else {
            System.out.println("Empty! Create a Products...");
            return false;
        }
    }


    private void buyProducts() {
        System.out.println("\n>>>****/Buy_a_Product\\****<<<");
        Scanner scanner = new Scanner(System.in);

        if (printAllPersons()) {
            boolean cyclePerson = true;
            while (cyclePerson) {

                System.out.println("\n<- back menu  -1.");
                System.out.print("Who buys:");
                String choicePerson = scanner.nextLine();

                for (Persons persons : personsList) {
                    if (String.valueOf(persons.getId()).equals(choicePerson)) {
                        this.person = persons;
                        cyclePerson = false;
                    }
                    if (choicePerson.equals("-1")) {
                        return;
                    }
                }
            }
            if (printAllProducts()) {
                boolean cycleProduct = true;
                while (cycleProduct) {

                    System.out.println("\n<- back menu  -1.");
                    System.out.print("What buys:");
                    String choiceProduct = scanner.nextLine();

                    for (Products products : productsList) {
                        if (String.valueOf(products.getId()).equals(choiceProduct)) {
                            this.product = products;
                            cycleProduct = false;
                        }
                        if (choiceProduct.equals("-1")) {
                            return;
                        }
                    }
                }

                Conversion.buy(this.person, this.product);

                System.out.println("*Info: " + this.person.getFirstName() + " " + this.person.getLastName() +
                        " | " + "Account Balance:" + this.person.getAmountOfMoney());

                backMenu();
            } else {
                backMenu();
            }
        } else {
            backMenu();
        }
    }


    public void printWhoBoughtWhat() {
        Scanner scanner = new Scanner(System.in);

        if (printAllPersons()) {
                while (true) {
                    System.out.println("\n<- back menu  -1.");
                    System.out.print("Who bought what:");

                    String choice = scanner.nextLine();

                    for (Persons p : personsList) {
                        if (choice.equals("-1")) {
                            return;
                        }
                        if (String.valueOf(p.getId()).equals(choice)) {
                            p.getProducts();
                        }
                    }
                }
        } else {
            backMenu();
        }
    }



}