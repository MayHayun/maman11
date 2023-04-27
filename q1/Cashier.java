import java.util.Random;
import java.util.Scanner;
/*main class to execute cashier application*/
public class Cashier extends CashRegister{
    public static void main(String [] args)
    {
        System.out.println("This cashRegister has the following functionalities: ");
        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        printMenu();
        CashRegister cr = new CashRegister(0); // creating a new instance for cash register
        int choice = scan.nextInt(); // the choice from the menu
        while (choice > 0) {
            switch (choice) {
                case 1: //creating a cash register with input total
                    System.out.println("please enter the starting total of register:");
                    int total = scan.nextInt();
                    cr = new CashRegister(total);
                    break;
                case 2: //adding product to current purchase
                    System.out.println("please enter the name of the product:");
                    String name = scan.next();
                    Item i = new Item(name, r.nextInt(0, 11));
                    System.out.println("please enter the quantity:");
                    cr.addToPurchase(i, scan.nextInt());
                    break;
                case 3:
                    System.out.println("total in register is:\t" + cr.getTotal()); // printing total in register
                    break;
                case 4:
                    cr.getCurCheck(); // printing check for current costumer
                    break;
                case 5: // getting payed
                    cr.getPayed(scan.nextFloat());
                    System.out.println("total in register is:\t" + cr.getTotal());
                    break;
            }
            if (choice == 5){ //if current purchase ended
                System.out.println("press 2 to start a new purchase or 0 to gracefully exit:");
            }else {
                printMenu();
            }
            choice = scan.nextInt();
        }
    }
/*a method to print the menu for user*/
    private static void printMenu()
    {
        System.out.println("for creating a new cashRegister press 1");
        System.out.println("for adding to current purchase press 2");
        System.out.println("for getting the total amount in register press 3");
        System.out.println("for ending current purchase and getting the check press 4");
        System.out.println("for accepting payment for current purchase press 5");
        System.out.println("to gracefully exit the cashier application press 0");
    }
}
