import java.util.Scanner;

enum Alphabet {a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z}

public class CountLetters {
    public static void main(String[] args) {
        // 입력받기 위한 Scanner 생성자 생성
        Scanner sc = new Scanner(System.in);
        // 입력을 한 줄로 받고 받은 내용을 공백을 기준으로 나누어서 배열에 저장
        String[] words = sc.nextLine().split(" ");
        sc.close();

        // 배열의 문자열을 하나로 만들기 위한 add 를 빈 문자열로 초기화
        String add = "";
        //for문을 이용해 배열의 문자열을 add 에 하나의 문자열이 될 수 있게 함
        for (int i = 0; i < words.length; i++) {
            add += words[i];
        }

        // char 형 배열 cha 에 add 를 toCharArray() 를 이용해 char 형으로 배열에 저장함
        char[] cha = add.toCharArray();
        // Alphabet 형 배열 bet 을 생성하고 Alphabet.values() 를 이용해 배열의 원소를 Alphabet 의 원소로 함
        Alphabet[] bet = Alphabet.values();

        // 비교한 값을 저장하기 위해 길이가 bet 과 같은 int 형 배열 count 를 생성함
        int[] count = new int[bet.length];
        // 이중 for 문과 if 문을 이용해 비교해서 알파벳이 포함되어 있으면 count 의 숫자 값이 오르도록 함
        // bet[i].name() 을 이용해 열거형 상수의 이름을 문자열로 반환한다.
        // equals() 를 이용해 문자열의 값을 서로 비교하게 한다.
        // String.valueOf() 를 이용해 문자형 cha[j] 의 원소가 문자열로 반환하게 한다.
        for (int i = 0; i < bet.length; i++){
            for (int j = 0; j < cha.length; j++){
                if (bet[i].name().equals(String.valueOf(cha[j]))){
                    count[i] += 1;
                }
            }
        }
        // count 의 원소가 0이 아닐 때 값을 출력하도록 함
        for (int i = 0; i < bet.length; i++){
            if (count[i] != 0){
                System.out.println(bet[i].name() + "=" + count[i]);
            }
        }
    }
}