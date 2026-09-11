import java.util.*;

public class Canteen {
    public static void main(String[] args) {
        // INITIALIZE MENU
        Map<String, Double> Menu = initMenu();

        // VARIABLES
        String orderAns = "";
        int totalItems = 0;
        double totalSubTotal = 0.0;
        double totalDiscount = 0.0;
        double totalTotal = 0.0;

        // MAIN LOOP
        while(!orderAns.equals("N")) {
            System.out.println("\n=====   MENU   =====");
            int i = 1;
            for(var menu: Menu.entrySet()) {
                System.out.printf(i +".%-15s - $%.2f%n", menu.getKey(), menu.getValue());
                i++;
            }

            Scanner input = new Scanner(System.in);
            
            // ORDER INPUT
            System.out.print("\nEnter item number: ");
            int itemNum = input.nextInt(); 

            System.out.print("Enter quantity: ");
            int quantity = input.nextInt();
            input.nextLine();

            // CHECK IF AT LEAST 1 OR AT MOST 10
            if(quantity < 1) {
                System.out.println("\nPlease order at least one quantity.");
                continue;
            }
            else if(quantity > 10) {
                System.out.println("\nYou cannot order more than 10 quantity.");
                continue;
            }

            double itemCost = getItemCost(itemNum, Menu); 

            // VERIFY ORDER VALIDITY
            if(itemCost == 0.0) {
                System.out.println("Invalid order! Please enter a valid item and quantity.");
                continue;
            }

            System.out.print("Are you a student? (Y/N): ");
            String studentAns = input.nextLine().toUpperCase();
            Boolean isStudent = false;
            if(studentAns.equals("Y")) isStudent = true; 

            // ORDER OUTPUT
            double subTotal = computeSubTotal(itemCost, quantity);
            System.out.printf("\nSubtotal: " + "$%.2f%n", subTotal);

            double discount = computeDiscount(isStudent, subTotal);
            System.out.printf("Discount: " + "$%.2f%n", discount);

            double total = subTotal - discount;
            System.out.printf("Order Total: " + "$%.2f%n", total);

            // TOTAL TRACKER
            totalItems+=quantity;
            totalSubTotal+=subTotal;
            totalDiscount+=discount;
            totalTotal+=total;

            // RELOOP
            orderAns = "";
            while(!orderAns.equals("Y") && !orderAns.equals("N")) {
                System.out.print("\nDo you want to order again? (Y/N): ");
                orderAns = input.nextLine().toUpperCase();
            }
        }

        // ORDER SUMMARY
        displaySummary(totalItems, totalSubTotal, totalDiscount, totalTotal);
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
                return 0;
        }
    }

    // SUBTOTAL COMPUTER
    public static double computeSubTotal(double itemCost, int quantity) {
        double subTotal = itemCost*quantity;
        return subTotal;
    }

    // DISCOUNT COMPUTER
    public static double computeDiscount(Boolean isStudent, double totalPurchase) {
        if(isStudent && totalPurchase >= 500.0) {
            return totalPurchase*0.15;
        }
        else if(isStudent)  {
            return totalPurchase*0.10;
        }
        else if(totalPurchase >= 500.0) {
            return totalPurchase*0.05;
        }
        else return 0.0;
    }

    public static void displaySummary(int totalItems, double totalSubTotal,
                                      double totalDiscount, double totalTotal) {
        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total items: " + totalItems);
        System.out.printf("Total before discount: " + "$%.2f%n", totalSubTotal);
        System.out.printf("Total discount: " + "$%.2f%n", totalDiscount);
        System.out.printf("Final amount: " + "$%.2f%n", totalTotal);
        System.out.println("Thank you for ordering!");
    }
}