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

        Order order2 = new Order();
        order2.firstName = "Jimmy";

        Order order3 = new Order();
        order3.firstName = "Noah";

        Order order4 = new Order();
        order4.firstName = "Sam";

        order2.items.add(item1);
        order2.total += item1.price;

        order3.items.add(item4);
        order3.total += item4.price;

        order4.items.add(item2);
        order4.total += item2.price;

        order1.ready = true;
        order2.ready = true;

        order4.items.add(item2);
        order4.items.add(item2);
        order4.total += item2.price * 2;
    
        // Application Simulations
        // Use this example code to test various orders' updates
        System.out.printf("Name: %s\n", order1.firstName);
        System.out.printf("Total: %s\n", order1.total);
        System.out.printf("Ready: %s\n", order1.ready);

        System.out.printf("Name: %s\n", order2.firstName);
        System.out.printf("Total: %s\n", order2.total);
        System.out.printf("Ready: %s\n", order2.ready);

        System.out.printf("Name: %s\n", order3.firstName);
        System.out.printf("Total: %s\n", order3.total);
        System.out.printf("Ready: %s\n", order3.ready);
    
        System.out.printf("Name: %s\n", order4.firstName);
        System.out.printf("Total: %s\n", order4.total);
        System.out.printf("Ready: %s\n", order4.ready);
    }
}