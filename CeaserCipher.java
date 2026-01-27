import java.util.Scanner;
public class CeaserCipher {
  public static  void mian(String [] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Enter text: ");
    String text = sc.nextLine();
    
    System.out.println("Enter key value: ");
    int key = sc.nextInt();

    System.out.println("Encrypted Text: "+ encrypt(text,key));
    System.out.println("Decrypted Text: "+decrypt(text,key));
  }   
static String encrypt(String text,int key){
  String encryptedText = " ";
  key = key % 26;
  for(int i = 0 ; i < text.length() ; i++){
    char ch = text.CharAt(i);
    if( ch >= 'A' && ch <= 'Z'){
      ch = (char)((ch - 'A' + key + 26) % 26 + 'A');
    }
    else if ( ch >= 'a' && ch <= 'z'){
      ch = (char)((ch - 'a' + key + 26) % 26 + 'a');
    }
    encryptedText += ch;
  }
  return encryptedText;
}
  public static String decrypt(String ciphertext, int key){
    String decryptedText = " ";
    key = key % 26;
    for(int i = 0; i < ciphertext.length(); i++){
      char ch = ciphertext.charAt(i);
    if( ch >= 'A' && ch <= 'Z'){
      ch = (char)((ch - 'A' - key + 26) % 26 + 'A');
    }
    else if ( ch >= 'a' && ch <= 'z'){
      ch = (char)((ch - 'a' - key + 26) % 26 + 'a');
    }
    decryptedText += ch;
    }
    return decryptedText;
  }
}
