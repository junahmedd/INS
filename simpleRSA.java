import java.util.Scanner;
import java.math.BigInteger;

public class simpleRSA{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter p value: ");
        BigInteger p = sc.nextBigInteger();
        
        System.out.println("Enter q value: ");
        BigInteger q = sc.nextBigInteger();

        System.out.println("Enter e value: ");
        BigInteger e = sc.nextBigInteger();

        BigInteger n = p.multiply(q);
        BigInteger phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
        
        BigInteger d= e.modInverse(phi);

        System.out.println("PublicKey(e,n):("+e+","+n+")");
        System.out.println("PrivateKey(d,n):("+d+","+n+")");

        System.out.println("Enter message(no): ");
        BigInteger msg = sc.nextBigInteger();
        BigInteger cipher = msg.modPow(e,n);
        BigInteger decrypted = cipher.modPow(d, n);
        System.out.println("Encrypt message: "+cipher);
        System.out.println("Decrypt message: "+decrypted);
    }
}
