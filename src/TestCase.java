import java.io.*;
import java.util.StringTokenizer;

public class TestCase {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //bufferedReader로 입력 받으면 모든 데이터 타입은 String 형식으로 반환 된다.
        int T = Integer.parseInt(br.readLine());
        //버퍼를 이용해서 값을 입력할 때 한줄로 받을 수 있게 해줌 ex) 1 3 4 이런식
        StringTokenizer st;

        for(int i=0; i<T;i++){
            //입력 받는 두 정수는 문자열 분리를 위해 매 반복 마다 StringTokenizer 을 생성과 동시에 문자를 입려 받음
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            bw.write(A+B+"\n");
           }

        //화면에 출력 하는 함수
        //buffer에 들어오는 값을 모아두고 한번에 쏟아내는 역할
        bw.flush();
        //비운 버퍼를 닫아줘야한다.
        br.close();
        bw.close();
    }
}
