import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {
    
	public static void main(String[] args) {
		PuzzleJava generator = new PuzzleJava();
		ArrayList<Integer> randomRolls = generator.getTenRolls();
		System.out.println(randomRolls);
		
    	//..
		// Write your other test cases here.
		//..
        String randletter = generator.randletter();
        System.out.println(randletter);

        String randpassword = generator.generatePassword();
        System.out.println(randpassword);
        
        String getNewPasswordSet = generator.getNewPasswordSet(19);
        System.out.println(getNewPasswordSet);
	}
}