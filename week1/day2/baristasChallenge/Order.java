import java.util.ArrayList;
public class Order {
    // MEMBER VARIABLES
    private String firstName; // default value of null
    private boolean ready; // default value false
    private ArrayList<Item> items = new ArrayList<Item>(); // defaults to null
    
    // CONSTRUCTOR
    // No arguments, sets name to "Guest", initializes items as an empty list.
    
    // OVERLOADED CONSTRUCTOR
    // Takes a name as an argument, sets name to this custom name.
    // Initializes items as an empty list.
    
    // ORDER METHODS
    public void addItem(Item item){
        items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready == true){
            return "Your order is ready.";
        }
        return "Thank you for waiting, Your order will be ready soon.";
    }
    
    public double getOrderTotal(){
        double total = 0;
        for(Item oneItem : items){
            total += oneItem.getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println("Customer Name: " + this.firstName);
        for(Item oneItem : this.items){
            System.out.println(oneItem.getName() + " - $" + oneItem.getPrice());
        }
        System.out.println("Total: " + getOrderTotal());
    }


    	// Most of your code will go here, 
    	// so implement the getters and setters first!
    
    // GETTERS & SETTERS
    public Order(){
        this.firstName = "guest";
        this.ready = false;
    }

    public Order(String nameParam){
        this.firstName = nameParam;
        this.ready = false;
    }

    public Order(String firstNameParam, boolean readyParam, ArrayList<Item> itemsParam){
        this.firstName = firstNameParam;
        this.ready = readyParam;
        this.items = itemsParam;
    }

    public String getName(){
        return this.firstName;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return items;
    }

    public void setReady(boolean readyParam){
        this.ready = readyParam;
    }
}