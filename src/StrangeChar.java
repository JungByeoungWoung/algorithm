import java.util.Arrays;

/**
 * 문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
 * 각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
 * 각 단어의 짝수번째 알파벳은 대문자로,
 * 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 *
 * "try hello world" ->	"TrY HeLlO WoRlD"
 */
public class StrangeChar {

    // 짝수번째 알파벳은 대문자 변환 메서드

    /**
     * 짝수번째 문자는 대문자로 변환
     * @param text
     * @return String[]
     */
    public String[] toEvenChar(String text) {
        String[] textArr = text.split(" ", -1);
        char[] charArray = null;
        for (int i=0; i < textArr.length; i++) {
            // textArr[0] : try, textArr[1] : hello /textArr[2] : world
             charArray = textArr[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                // if i%2 == 0 이면 대문자 변환
                if (j%2 == 0) {
                    char upperCase = Character.toUpperCase(charArray[j]);
                    charArray[j] = upperCase;
                }
            }
            String str = new String(charArray);
            textArr[i] = str;
        }
        return textArr;
    }
    /**
     * 홀수번째 문자는 소문자로 변환
     * @param text
     * @return String[]
     */
    public String[] toOddChar(String[] text) {
        char[] charArr = null;
        // 문자열 배열을 for문으로 돌림
        for (int i = 0; i < text.length; i++) {
            // strText[0] : try, strText[1] : hello /strText[2] : world
            charArr = text[i].toCharArray();
            for (int j = 0; j < charArr.length; j++) {
                if (j%2 == 1) {
                    char lowerChar = Character.toLowerCase(charArr[j]);
                    charArr[j] = lowerChar;
                }
            }
            String str = new String(charArr);
            text[i] = str;
        }
        return text;
    }

    /**
     * 문자 배열을 String으로 반환
     * @param text
     * @return String
     */
    public String arrToStr(String[] text) {
        if (text == null || text.length ==0) return "";
        return String.join(" ", text);
    }

    public static void main(String[] args) {
        StrangeChar strangeChar = new StrangeChar();
        String text = "try hello world";
        String[] evenChar = strangeChar.toEvenChar(text);
        String[] oddChar = strangeChar.toOddChar(evenChar);
        String result = strangeChar.arrToStr(oddChar);

        System.out.println("evenChar = " + Arrays.toString(evenChar));
        System.out.println("oddChar = " + Arrays.toString(oddChar));
        System.out.println("result = " + result);
    }
}
