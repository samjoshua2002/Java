package Security;
import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) (97 + i);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the text: ");
        String textInput = scanner.nextLine();

        System.out.print("Enter the key: ");
        int key = scanner.nextInt();

        String encryption = "";

        for (int i = 0; i < textInput.length(); i++) {
            char ch = textInput.charAt(i);
            if (Character.isLetter(ch) && Character.isLowerCase(ch)) {
                int a = ch - 97;
                int b = (a + key) % 26;
                char c = alphabet[b];
                encryption += c;
            } else {
                encryption += ch;
            }
        }

        System.out.println("Encryption: " + encryption);

        String decryption = "";

        for (int i = 0; i < encryption.length(); i++) {
            char ch = encryption.charAt(i);
            if (Character.isLetter(ch) && Character.isLowerCase(ch)) {
                int a = ch - 97;
                int b = (a - key + 26) % 26;
                char c = alphabet[b];
                decryption += c;
            } else {
                decryption += ch;
            }
        }

        System.out.println("Decryption: " + decryption);

        scanner.close();
    }
}