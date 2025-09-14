public class RecommandId {

    /**
     * 문제 설명
     * "네오"에게 주어진 첫 업무는 새로 가입하는 유저들이 카카오 아이디 규칙에 맞지 않는 아이디를 입력했을 때,
     * 입력된 아이디와 유사하면서 규칙에 맞는 아이디를 추천해주는 프로그램을 개발하는 것입니다.
     * 다음은 카카오 아이디의 규칙입니다.
     *
     * 아이디의 길이는 3자 이상 15자 이하여야 합니다.
     * 아이디는 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.) 문자만 사용할 수 있습니다.
     * 단, 마침표(.)는 처음과 끝에 사용할 수 없으며 또한 연속으로 사용할 수 없습니다.
     * 신규 유저가 입력한 아이디가 new_id 라고 한다면,
     *
     * 1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
     * 2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
     * 3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
     * 4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
     * 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
     * 6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
     *      만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
     * 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
     * 따라서 신규 유저가 입력한 new_id가 "...!@BaT#*..y.abcdefghijklm"일 때,
     * 네오의 프로그램이 추천하는 새로운 아이디는 "bat.y.abcdefghi" 입니다.
     *
     * [제한사항]
     * new_id는 길이 1 이상 1,000 이하인 문자열입니다.
     * new_id는 알파벳 대문자, 알파벳 소문자, 숫자, 특수문자로 구성되어 있습니다.
     * new_id에 나타날 수 있는 특수문자는 -_.~!@#$%^&*()=+[{]}:?,<>/ 로 한정됩니다.
     */

    public static void main(String[] args) {
        String originId = "z-+.^.";
        ConvertUtil convertUtil = new ConvertUtil();
        System.out.println("Id = " + convertUtil.createId(originId));

    }

    static class ConvertUtil {
        public String createId(String originId) {
            String step1 = convertSmall(originId);
            String step2 = removeSpecificChar(step1);
            String step3 = replaceDoubleDotToOneDot(step2);
            String step4 = removeStartDotOrEndDot(step3);
            String step5 = checkParam(step4);
            String step6 = checkLength(step5);
            return repeatAppendStr(step6);
        }

        // 1단계 대문자는 모두 소문자로 치
        public String convertSmall(String originId) {
            return originId.toLowerCase();
        }
        // 2단계 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
        public String removeSpecificChar(String originId) {
            return originId.replaceAll("[^a-z0-9._-]", "");
        }
        // 3단계 연속 마침표(.)는 하나의 마침표로 치환(.)
        public String replaceDoubleDotToOneDot(String originId) {
            return originId.replaceAll("\\.{2,}", ".");
        }
        // 4단계 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        public String removeStartDotOrEndDot(String originId) {
            String result = originId;
            // 마침표로 시작할 경우 앞쪽 마침표 제거
            if (originId.startsWith(".")) {
                result = originId.substring(1);
            }
            // 마지막에 마침표로 끝날 경우 마지막 마침표 제거
            if (result.endsWith(".")) {
                result = result.substring(0, result.length()-1);
            }
            return result;
        }

        // 5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
        public String checkParam(String originId) {
            if (originId == null || originId.isEmpty()) return "a";
            return originId;
        }

        // 6단계 new_id의 길이가 16자 이상이면, new_id의 15자만 남김.
        // 만약, 끝자리가 . 으로 끝난다면 . 은 제거
        public String checkLength(String originId) {
            String replaceId = null;
            if (originId == null || originId.isEmpty()) return "a";
            if (originId.length() >= 16) {
                // 15자리만 남김
                replaceId = originId.substring(0, 15);
                // 15자리에서 마지막이 마침표로 끝나면 마침표 제거
                if (replaceId.endsWith(".")) {
                    return replaceId.substring(0, replaceId.length() - 1);
                }
                return replaceId;
            }
            return originId;
        }

        // 7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        public String repeatAppendStr(String originId) {
            if (originId.length() >= 3) return originId;
            StringBuilder sb = new StringBuilder(originId);
            char last = originId.charAt(originId.length()-1);
            while (sb.length() < 3) {
                sb.append(last);
            }
            return sb.toString();
        }
    }
}

