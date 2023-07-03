import java.util.Scanner;

public class Problem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while (t > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            
            if (a + b > 6) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
            
            t--;
        }
        sc.close();
    }
}
