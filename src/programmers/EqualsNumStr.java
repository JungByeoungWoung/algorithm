package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
 * 1478 → "one4seveneight"
 * 234567 → "23four5six7"
 * 10203 → "1zerotwozero3"
 * 이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나,
 * 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
 * s가 의미하는 원래 숫자를 return 하도록 함수를 완성해주세요.
 */
public class EqualsNumStr {
    // 1. map 생성 <String, String> -> for문으로 생성 1-9
    // 2. 숫자로 결과를 return 하면 됨.


    public static void main(String[] args) {
        String originNum = "one4seveneight";
        ConvertNumber convertNumber = new ConvertNumber();
        Integer result = convertNumber.covertStr(originNum);
        System.out.println("result = " + result);
    }

    public static class ConvertNumber {
        public int covertStr(String text) {
            HashMap<String, String> hashMap = createHashMap();
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                text = text.replace(entry.getKey(), entry.getValue());
            }
            return Integer.parseInt(text);
        }
        public HashMap<String, String> createHashMap() {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("zero", "0");
            hashMap.put("one", "1");
            hashMap.put("two", "2");
            hashMap.put("three", "3");
            hashMap.put("four", "4");
            hashMap.put("five", "5");
            hashMap.put("six", "6");
            hashMap.put("seven", "7");
            hashMap.put("eight", "8");
            hashMap.put("nine", "9");
            return hashMap;
        }
    }
}
