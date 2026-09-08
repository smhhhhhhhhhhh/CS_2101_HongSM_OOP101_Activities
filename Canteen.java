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
            System.out.print("Are you a student? (Y/N): ");
            String discount = input.nextLine().toUpperCase(); 



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

    public static double getItemValue(int itemNum, Map<String, Double> Menu) {
        switch(itemNum) {
            case 1:
                return Menu.get;
        }
    }

    public static double computeSubTotal() {

    }
}