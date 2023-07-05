import java.util.Scanner;

public class Tables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        for(int i=1;i<=10;i++){
            int r = i*n;
            System.out.printf("%d * %d = %d\n",n,i,r );
            sc.close();
        }
        sc.close();
    }
    
}
