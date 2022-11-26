// You will need to import the Random library from java.util
import java.util.Random;
import java.util.ArrayList;
    
// To use methods from the Random library you will need to create an instance of Random
// Random randMachine = new Random();
// From there you can use any of the methods listed in the documentation. For example:
// randMachine.setSeed(35679); // <--- you won't need to use this method.

class PuzzleJava {
    ArrayList<Integer> getTenRolls() {
        Random randNum = new Random();
        ArrayList<Integer> tenNums = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            tenNums.add(randNum.nextInt(20) + 1);
        }
        return tenNums;
    }

    String randletter() {
        String alphabetString = "abcdefghijklmnopqrstuvwxyz";
        String[] alphabet = new String[26];
        Random randNum = new Random();
        for (int i = 0; i < 26; i++) {
            alphabet[i] = String.valueOf(alphabetString.charAt(i));
        }
        return alphabet[randNum.nextInt(26)];
    }
}