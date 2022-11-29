import java.util.ArrayList;
public class Item {

    // MEMBER VARIABLES
    private String name;
    private double price;
    private int index;


    // CONSTRUCTOR
    //   Takes a name and price as arguments 
    //   and sets them accordingly
    public Item(){}
    
    // GETTERS & SETTERS  - for name and price
    public Item(String nameParam, double priceParam){
        this.name = nameParam;
        this.price = priceParam;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public double getIndex(){
        return this.index;
    }

    public void setName(String nameParam){
        this.name = nameParam;
    }

    public void setPrice(double priceParam){
        this.price = priceParam;
    }

    public void setIndex(int indexParam){
        this.index = indexParam;
    }
}