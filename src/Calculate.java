public class Calculate {
    public static void ClassifyNum(String formula){
        formula = formula.replaceAll(" ", "");
        int oprNum = 0;
        // 식은 정수형과 * 연산만 넣을수 있게 만들었다.
        String confirm = "0123456789*";
        for(int i = 0; i < formula.length(); i++){
            if(confirm.indexOf(formula.charAt(i)) == -1){
                System.out.println("정수형 곱하기만 가능합니다.");
                System.out.println("프로그램을 종료합니다.");
                return;
            }
            if((formula.charAt(i) + "").equals("*")){
                oprNum++;
            }
            if(oprNum > 1 || !formula.contains("*")){
                System.out.println("두개의 정수만 곱할 수 있습니다.");
                System.out.println("프로그램을 종료합니다.");
                return;
            }
        }
    }

    public static String mulNum(String num1, String num2) {
        // 십의자리와 일의자리
        int ten = 0, one = 0;
        // num1에 자릿수가 더 큰 값이 들어오도록
        if (num1.length() < num2.length()) {
            String temp = num2;
            num2 = num1;
            num1 = temp;
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String[] result = new String[len2];
        String str;
        // 자리수 나눠서 곱셈
        int j = len2 - 1;
        for (int i = 0; i < len2; i++) {
            result[i] = "";
            str = "";
            int n2 = num2.charAt(j) - '0';
            ten = 0; //one = 0;
            for (int k = len1 - 1; k >= 0; k--) {
                int n1 = num1.charAt(k) - '0';
                // 일의자리부터 순서대로 곱하고
                // 만약 전 식에서 십의자리가 올라왔다면 같이 더해준다.
                int mul = (n1 * n2) + ten;
                if ((mul / 10) != 0) {
                    ten = (int) (mul / 10);
                } else ten = 0;
                one = mul % 10;
                str += one;
            }
            if (ten != 0) str += ten;
            result[i] = reverseString(str);
            j--;
        }
        // 곱셈 완료된 숫자끼리 덧셈할 때 자릿수를 맞춰주기 위해
        // 0이 숨겨져 있는 곳에 0을 넣어준다.
        for (int i = 0; i < len2; i++) {
            String zero = "";
            for (int k = 0; k < i; k++) {
                zero += "0";
            }
            result[i] = result[i] + zero;
        }
        String realResult = "";
        ten = 0;
        int num = 0;
        int biggestLen = result[len2 - 1].length();
        int b = 0;
        // 일의자리부터 순서대로 덧셈 진행
        for (int i = biggestLen - 1; i >= 0; i--) {
            num = ten;
            for (int k = 0; k < len2; k++) {
                b = biggestLen - result[k].length();
                if ((i - b) >= 0) {
                    num += result[k].charAt(i - b) - '0';
                }
            }
            ten = 0;
            if ((num / 10) != 0) ten = (int) (num / 10);
            one = num % 10;
            realResult += one;
        }
        if (ten != 0) realResult += ten;
        String real = reverseString(realResult);
        return real;
    }
    public static String comma(String real){
        // 문자열에 콤마찍는건 DecimalFormat 으로 안돼서 직접 구현
        int length = real.length();
        if(length <= 3) return real;
        String addComma = "";
        if(length % 3 == 0){
            int n = (int)(length/3) - 1;
            for(int i = 0; i < n; i++){
                int k = i * 3;
                if(i == 0){
                    addComma += real.substring(0, 3) + ",";
                }else{
                    addComma += real.substring(k, k + 3) + ",";
                }
            }
            addComma += real.substring(length-3);
        }else if(length % 3 == 2){
            int n = (int)(length/3);
            int k = 2;
            for(int i = 0; i < n; i++){
                if(i == 0){
                    addComma += real.substring(0, 2) + ",";
                }else{
                    addComma += real.substring(k, k + 3) + ",";
                    k += 3;
                }
            }
            addComma += real.substring(length-3);
        }else if(length % 3 == 1){
            int n = (int)(length/3);
            int k = 1;
            for(int i = 0; i < n; i++){
                if(i == 0){
                    addComma += real.substring(0, 1) + ",";
                }else{
                    addComma += real.substring(k, k + 3) + ",";
                    k += 3;
                }
            }
            addComma += real.substring(length-3);
        }
        return addComma;
    }

    public static String reverseString(String s){ // 문자열 뒤집어주는 함수
        return (new StringBuffer(s)).reverse().toString();
    }
}
