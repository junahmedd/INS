import java.util.Scanner;

public class VignereCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the plaintext: ");
        String text = sc.nextLine().toUpperCase(); // optional uppercase
        System.out.println("Enter the key: ");
        String key = sc.nextLine().toUpperCase();

        String cipher = "";
        for (int i = 0; i < text.length(); i++) {
            char p = text.charAt(i);
            char k = key.charAt(i % key.length());
            char c = (char) ((p + k - 2 * 'A') % 26 + 'A');
            cipher += c; // append each cipher char
        }

        String decrypted = ""; // declare before loop
        for (int i = 0; i < cipher.length(); i++) {
            char c = cipher.charAt(i);
            char k = key.charAt(i % key.length());
            char d = (char) ((c - k + 26) % 26 + 'A');
            decrypted += d; // accumulate plaintext
        }

        System.out.println("Encryption text: " + cipher);
        System.out.println("Decrypted message: " + decrypted);
        sc.close();
    }
}
