import java.util.Scanner;

public class alarm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();

        if(hour>0 && minute >=45){
            int m = minute - 45;
            System.out.print(hour + " ");
            System.out.print(m);
        }else if(hour >0 && minute <45){
            int h = hour-1;
            int m = minute +15;
            System.out.print(h+ " ");
            System.out.print(m);
        }else if(hour ==0 && minute>=45){
            int m = minute -45;
            System.out.print(hour+ " ");
            System.out.print(m);
        }else if(hour ==0 && minute<45){
            int h = hour+ 23;
            int m = minute + 15;
            System.out.print(h+ " ");
            System.out.print(m);
        }
    }
}
