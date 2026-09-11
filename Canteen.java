import java.util.*;

public class Canteen {
    public static void main(String[] args) {
        // INITIALIZE MENU
        Map<String, Double> Menu = initMenu();

        // VARIABLES
        String orderAns = "";

        // MAIN LOOP
        // while(orderAns != "N") {
            System.out.println("=====   MENU   =====");
            int i = 1;
            for(var menu: Menu.entrySet()) {
                System.out.printf(i +".%-15s - $%.2f%n", menu.getKey(), menu.getValue());
                i++;
            }

            Scanner input = new Scanner(System.in);
            
            System.out.print("\nEnter item number: ");
            int itemNum = input.nextInt(); 

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
            input.nextLine();
            double itemCost = getItemCost(itemNum, Menu); 

            System.out.print("Are you a student? (Y/N): ");
            String discount = input.nextLine().toUpperCase(); 

            double subTotal = computeSubTotal(itemCost, quantity);
            System.out.printf("\nSubtotal: " + "$%.2f%n", subTotal);
        // }
    }

    // MENU INITIALIZER
    public static Map<String, Double> initMenu() {
        Map<String, Double> Menu = new LinkedHashMap<>();
        String[] items = {"Fried Chicken", "Spaghetti", "Steak", "Mashed Potato", "Omelette"};
        double[] prices = {15.00, 13.00, 29.00, 6.00, 13.00};
        for(int i = 0; i < 5; i++) {
            Menu.put(items[i], prices[i]);   
        }
        return Menu;
    }

    // ITEM COST OBTAINER
    public static double getItemCost(int itemNum, Map<String, Double> Menu) {
        switch(itemNum) {
            case 1:
                return Menu.get("Fried Chicken");
            case 2:
                return Menu.get("Spaghetti");
            case 3:
                return Menu.get("Steak");
            case 4:
                return Menu.get("Mashed Potato");
            case 5:
                return Menu.get("Omelette");
            default:
                return 0.0;
        }
    }

    // SUBTOTAL COMPUTER
    public static double computeSubTotal(double itemCost, int quantity) {
        double subTotal = itemCost*quantity;
        return subTotal;
    }
}