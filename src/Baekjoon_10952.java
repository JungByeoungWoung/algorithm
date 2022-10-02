import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10952 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String numList;
        while (true){
            numList = br.readLine();
            st = new StringTokenizer(numList, " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A==0 && B==0) {
                break;
            }
            sb.append((A + B)).append('\n');
        }
        System.out.println(sb);
    }
}
