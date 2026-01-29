import java.util.Scanner;

public class monocipher {

    static String plainAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    static String cipherAlphabet = "QWERTYUIOPASDFGHJKLZXCVBNM";

    public static String encrypt(String plaintext) {
        plaintext = plaintext.toUpperCase();
        String ciphertext = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char ch = plaintext.charAt(i);
            int index = plainAlphabet.indexOf(ch);

            if (index != -1) {
                ciphertext = ciphertext + cipherAlphabet.charAt(index);
            } else {
                ciphertext += ch;
            }
        }
        return ciphertext;
    }

    static String decrypt(String ciphertext) {
        ciphertext = ciphertext.toUpperCase();
        String plaintext = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            char ch = ciphertext.charAt(i);
            int index = cipherAlphabet.indexOf(ch);

            if (index != -1) {
                plaintext = plaintext + plainAlphabet.charAt(index);
            } else {
                plaintext += ch;
            }
        }
        return plaintext;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message: ");
        String msg = sc.nextLine();

        String encryptedMsg = encrypt(msg);
        System.out.println("Encrypted text = " + encryptedMsg);
        System.out.println("Decrypted text = " + decrypt(encryptedMsg));

        sc.close();
    }
}
