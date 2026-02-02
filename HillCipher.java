import java.util.Scanner;

class HillCipher {
    static int[][] key = { { 3, 3 }, { 2, 5 } };
    static int[][] inversekey = { { 15, 17 }, { 20, 9 } };

    static String encrypt(String p) {
        String c = "";
        p = p.toUpperCase().replace(" ", "");

        if (p.length() % 2 != 0) {
            p += "X";
        }

        for (int i = 0; i < p.length(); i += 2) {

            int x = p.charAt(i) - 'A';
            int y = p.charAt(i + 1) - 'A';

            c += (char) ((key[0][0] * x + key[0][1] * y) % 26 + 'A');
            c += (char) ((key[1][0] * x + key[1][1] * y) % 26 + 'A');
        }
        return c;
    }

    static String decrypt(String c) {
        String p = "";
        for (int i = 0; i < c.length(); i += 2) {
            int x = c.charAt(i) - 'A';
            int y = c.charAt(i + 1) - 'A';

            p += (char) ((inversekey[0][0] * x + inversekey[0][1] * y) % 26 + 'A');
            p += (char) ((inversekey[1][0] * x + inversekey[1][1] * y) % 26 + 'A');
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter plain text: ");
        String plain = sc.nextLine();

        String cipher = encrypt(plain);
        System.out.println("Encrypted text: " + cipher);
        System.out.println("Decrypted text: " + decrypt(cipher));

        sc.close();
    }
}
