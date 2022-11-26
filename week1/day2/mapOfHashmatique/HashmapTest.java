import java.util.HashMap;

public class HashmapTest {
    public static void main(String[] args) {
        Hash generator = new Hash();
        HashMap<String, String> firstmat = generator.createHash();
        for (String key : firstmat.keySet()) {
            System.out.println(String.format("Track: %s: Lyrics: %s", key, firstmat.get(key)));
        }
    }
}