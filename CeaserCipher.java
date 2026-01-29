import java.util.Scanner;
public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text to encrypt: ");
        String text = scanner.nextLine();

        System.out.print("Enter the key value: ");
        int key = scanner.nextInt();

        String encrypted = encrypt(text, key);
        System.out.println("Encrypted text: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted text: " + decrypted);

        scanner.close();
    }
    public static String encrypt(String text, int key) {
        String encryptedText = "";
        key = key % 26; 
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' + key + 26) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' + key + 26) % 26 + 'A');
            }
            encryptedText += ch;
        }
        return encryptedText;
    }
    public static String decrypt(String text, int key) {
        String decryptedText = "";
        key = key % 26;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) ((ch - 'a' - key + 26) % 26 + 'a');
            } else if (ch >= 'A' && ch <= 'Z') {
                ch = (char) ((ch - 'A' - key + 26) % 26 + 'A');
            }
            decryptedText += ch;
        }
        return decryptedText;
    }
}
