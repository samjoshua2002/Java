
import java.util.*;
import java.lang.Math;
 
public class JavaLoop {
 
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt(),i,a,b,n;
        for(i=0;i<q;i++)
        {
            a=sc.nextInt();
            b=sc.nextInt();
            n=sc.nextInt();
            int s=a;
            for(int j=0;j<n;j++)
            {
                s=s+(((int)Math.pow(2, j))*b);
                System.out.print(s+" ");
            }
            System.out.println();
        }
    }
}