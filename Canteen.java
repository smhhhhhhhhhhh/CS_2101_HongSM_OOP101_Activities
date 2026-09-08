import java.util.*;

public class Canteen {
    public static void main(String[] args) {
        // INITIALIZE MENU
        Map<String, Double> Menu = initMenu();

        // VARIABLES
        String studentAns = "", orderAns = "";

        // MAIN LOOP
        // while(orderAns != "N") {
            System.out.println("=====   MENU   =====");
            for(var menu: Menu.entrySet()) {
                System.out.printf("%-15s -$%.2f%n", menu.getKey(), menu.getValue());
            }
        // }
        
        
    }

    public static Map<String, Double> initMenu() {
        Map<String, Double> Menu = new LinkedHashMap<>();
        String[] items = {"Fried Chicken", "Spaghetti", "Steak", "Mashed Potato", "Omelette"};
        double[] prices = {15.00, 13.00, 29.00, 6.00, 13.00};
        for(int i = 0; i < 5; i++) {
            Menu.put(items[i], prices[i]);   
        }
        return Menu;
    }
}