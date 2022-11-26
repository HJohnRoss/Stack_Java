import java.util.ArrayList;
class CafeUtil {
    int getStreakGoal() {
        int temp = 0;
        int num = 0;
        for(int i = 0; i < 11; i++) {
            temp = i;
            num += temp;
        }
    return num;
    }

    double getOrderTotal(double[] prices) {
        double total = 0;
        for (double one_price : prices) {
            total += one_price;
        }
        return total;
    }

    void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.print(i);
            System.out.print(" ");
            System.out.println(menuItems.get(i));
        }
    }

    void addCustomer(ArrayList<String> customers) {
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.println("Hello " + userName + " there are currently "
            + customers.size() + " in front of you.");
        customers.add(userName);
    }

    // boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices) {
    //     if (menuItems.size() != prices.size()) {
    //         return false;
    //     }
    //     else {
    //         for (int i = 0; i < menuItems.size(); i++) {
    //         System.out.print(i);
    //         System.out.print(" ");
    //         System.out.print(menuItems.get(i));
    //         System.out.print("---");
    //         System.out.println(prices.get(i));
    //         }
    //         return true;
    //     }
    // }
}