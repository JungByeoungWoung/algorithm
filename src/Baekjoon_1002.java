import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            sb.append(teret_point(x1, y1, r1, x2, y2, r2)).append('\n');
        }
        System.out.println(sb);
    }

    public static int teret_point(int x1, int y1, int r1, int x2, int y2, int r2) {
        int distance2 = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        //1. 접점이 무한대일 경우
        if (x2 == x1 && y2 == y1 && r2 == r1) {
            return -1;
        }
        //2. 접점이 하나일 경우
        else if (distance2 == Math.pow(r2 - r1, 2) || distance2 == Math.pow(r2 + r1, 2)) {
            return 1;
        }
        //3. 접점이 없을 경우
        else if (distance2 > Math.pow(r2 + r1, 2) || distance2 < Math.pow(r2 - r1, 2)) {
            return 0;
        } else {
            //3. 접접이 두개일 경우
            return 2;
        }
     }
}
