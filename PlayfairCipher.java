import java.util.Scanner;

public class playfairCipher {
    static char[][] m = {
            { 'M', 'O', 'N', 'A', 'R' },
            { 'C', 'H', 'Y', 'B', 'D' },
            { 'E', 'F', 'G', 'I', 'K' },
            { 'L', 'P', 'Q', 'S', 'T' },
            { 'U', 'V', 'W', 'X', 'Z' }
    };
    static int r1, c1, r2, c2;

    static void pos(char ch, int n) {
        if (ch == 'J')
            ch = 'I';
        // Changed: j < 5 (your original code had j < 3, which missed half the grid)
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (m[i][j] == ch) {
                    if (n == 1) {
                        r1 = i;
                        c1 = j;
                    } else {
                        r2 = i;
                        c2 = j;
                    }
                }
            }
        }
    }

    static void playfair(String text, int dir) {
        // Ensure the text has an even length
        if (text.length() % 2 != 0)
            text += "X";

        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i);
            char b = text.charAt(i + 1);

            pos(a, 1);
            pos(b, 2);

            if (r1 == r2) { // Same Row: Shift Columns
                System.out.print(m[r1][(c1 + dir + 5) % 5]);
                System.out.print(m[r2][(c2 + dir + 5) % 5]);
            } else if (c1 == c2) { // Same Column: Shift Rows
                System.out.print(m[(r1 + dir + 5) % 5][c1]);
                System.out.print(m[(r2 + dir + 5) % 5][c2]);
            } else { // Rectangle: Swap Columns
                System.out.print(m[r1][c2]);
                System.out.print(m[r2][c1]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Plain text: ");
        String plain = sc.nextLine().toUpperCase().replace(" ", "");
        System.out.print("Encrypted text: ");
        playfair(plain, 1);

        System.out.print("Enter Cipher text: ");
        String cipher = sc.nextLine().toUpperCase().replace(" ", "");
        System.out.print("Decrypted text: ");
        playfair(cipher, -1);

        sc.close();
    }
}
