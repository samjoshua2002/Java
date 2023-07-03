import java.util.Scanner;/**
 * problem2
 */
public class problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-->0) {
            int a=sc.nextInt();
            if (a>=80){
                System.out.println("yes");
            }
            else{
                System.out.println("no");
            }
            
        }
        sc.close();
    }

    
}