import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Star {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i =1;i<=T;i++){
            for(int j= 1;i<=T-j;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println("");
        }
        br.close();
    }
}
