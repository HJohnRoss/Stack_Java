import java.util.ArrayList;
public class TestOrders {
    public static void main(String[] args) {
    
        // Menu items
        Item item1 = new Item();
        item1.name = "mocha";
        item1.price = 2;

        Item item2 = new Item();
        item2.name = "latte";
        item2.price = 4;

        Item item3 = new Item();
        item3.name = "drip coffee";
        item3.price = 1.5;

        Item item4 = new Item();
        item4.name = "capuccino";
        item4.price = 6;
        // Order variables -- order1, order2 etc.
        Order order1 = new Order();
        order1.firstName = "Cindhury";
        order1.ready = "yes";
        order1.total = item1.price;
        order1.item = item1.name;

        Order order2 = new Order();
        order2.firstName = "Jimmy";
        order2.ready = "no";
        order1.total = item2.price;
        order2.item = item2.name;

        Order order3 = new Order();
        order3.firstName = "Noah";
        order3.ready = "yes";
        order3.total = item3.price;
        order3.item = item3.name;

        Order order4 = new Order();
        order4.firstName = "Sam";
        order4.ready = "yes";
        order4.total = item4.price;
        order4.item = item4.name;

    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.firstName);
        System.out.printf("Name: %s\n", order1.item);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);
    }
}