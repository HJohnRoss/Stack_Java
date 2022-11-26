import java.util.Date;
public class AlfredQuotes {
    
    public String basicGreeting() {
        // You do not need to code here, this is an example method
        return "Hello, lovely to see you. How are you?";
    }
    
    public String guestGreeting(String name) {
        // YOUR CODE HERE
        return name + ", welcome to our home.";
    }
    
    public String dateAnnouncement() {
        Date date = new Date();
        return "The current date is: " + date;
    }
    
    public String respondBeforeAlexis(String conversation) {
        return conversation;
    }
    
	// NINJA BONUS
	// See the specs to overload the guessGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}