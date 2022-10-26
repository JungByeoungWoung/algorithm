import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int array = Integer.parseInt(br.readLine());
        int[] number = new int[array];
        for (int i = 0; i < array; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }
        int temp;
        for (int i = 0; i < array-1; i++) {
            for (int j = i+1; j < array; j++) {
                if (number[i]>number[j]){
                    temp = number[i];
                    number[i] = number[j];
                    number[j] = temp;
                }
            }
        }
        for(int var : number){
            System.out.println(var);
        }
    }
}
