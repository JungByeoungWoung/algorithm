import java.util.Scanner;

public class gugudan {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n>0 && n<10) {
            for (int i = 1; i < 10; i++) {
                int result = n * i;
                System.out.println(n + " " + "*"+ " " + i + " " +"="+ " " + result);
            }
        }else {
            System.out.println("n 의 값이 범위에 안맞습니다.");
        }
    }
}
