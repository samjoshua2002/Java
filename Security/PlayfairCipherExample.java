package Security;
import javax.swing.JOptionPane;

public class PlayfairCipherExample {
    public static char[][] keymat = new char[][]{
        { 'M', 'O', 'N', 'A', 'R' },
        { 'C', 'H', 'Y', 'B', 'D' },
        { 'E', 'F', 'G', 'I', 'K'},
        { 'L', 'P', 'Q', 'S', 'T'},
        { 'U', 'V', 'W', 'X', 'Z'}
    };

    public static String trans = "J"; //for translating J to I
    public static char filler = 'X'; //filler letter is X

    public static void main(String args[]){
        String text, outtext = "";
        int choice;

        // Get user input for encryption or decryption
        choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter 1 to Encrypt and 2 to Decrypt!"));

        // Get the text to be encrypted or decrypted
        text = JOptionPane.showInputDialog(null, "Enter plain/cipher text to encrypt/decrypt?");
        text = text.toUpperCase();
        text = text.replaceAll("\\s", ""); // Remove spaces
        text = text.replace(trans, "I"); // Replace J with I
        text = text.replaceAll("([A-Z])\\1+", "$1" + filler + "$1"); // Handle repeated letters

        // If the length of the text is odd, add the filler character to make it even
        if(text.length() % 2 != 0)
            text += filler;

        char[] ptextchars = text.toCharArray();

        System.out.println("Padded Text: " + text);

        // Perform encryption or decryption based on user choice
        switch(choice){
            case 1:
                for(int i = 0; i < text.length(); i += 2){
                    outtext += encrypt(ptextchars[i], ptextchars[i + 1]);
                }
                break;
            case 2:
                for(int i = 0; i < text.length(); i += 2){
                    outtext += decrypt(ptextchars[i], ptextchars[i + 1]);
                }
                break;
            default:
                System.out.println("Invalid Choice!");
        }

        System.out.println("Output: " + outtext);
    }

    private static String encrypt(char c1, char c2) {
        int[] posa = new int[2];
        int[] posb = new int[2];
        String frag = "";

        // Find positions of characters in the key matrix
        posa = search(c1);
        posb = search(c2);

        if(posa[0] == posb[0]){ // Same row
            c1 = keymat[posa[0]][(posa[1] + 1) % 5];
            c2 = keymat[posb[0]][(posb[1] + 1) % 5];
            frag = "" + c1 + c2;
        }
        else if(posa[1] == posb[1]){ // Same column
            c1 = keymat[(posa[0] + 1) % 5][posa[1]];
            c2 = keymat[(posb[0] + 1) % 5][posb[1]];
            frag = "" + c1 + c2;
        }
        else{
            c1 = keymat[posb[0]][posa[1]];
            c2 = keymat[posa[0]][posb[1]];
            frag = "" + c1 + c2;
        }

        return frag;
    }

    private static String decrypt(char c1, char c2) {
        int[] posa = new int[2];
        int[] posb = new int[2];
        String frag = "";

        // Find positions of characters in the key matrix
        posa = search(c1);
        posb = search(c2);

        if(posa[0] == posb[0]){ // Same row
            c1 = keymat[posa[0]][(posa[1] - 1) % 5];
            c2 = keymat[posb[0]][(posb[1] - 1) % 5];
            frag = "" + c1 + c2;
        }
        else if(posa[1] == posb[1]){ // Same column
            c1 = keymat[(posa[0] - 1) % 5][posa[1]];
            c2 = keymat[(posb[0] - 1) % 5][posb[1]];
            frag = "" + c1 + c2;
        }
        else{
            c1 = keymat[posb[0]][posa[1]];
            c2 = keymat[posa[0]][posb[1]];
            frag = "" + c1 + c2;
        }

        return frag;
    }

    private static int[] search(char c) {
        int[] pos = new int[2];

        // Search for the character in the key matrix and store its position
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (keymat[i][j] == c){
                    pos[0] = i;
                    pos[1] = j;
                    break;
                }
            }
        }

        return pos;
    }
}
