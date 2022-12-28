import java.util.*;

public class starShot2 {
    public static void main(String[] args){
        int num = 0;

        System.out.print("*을 출력할 라인의 수를 입력하세요.>");

        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        num = Integer.parseInt(tmp);

        int i = 0;
        int j = 0;

        while (i < num){
            while (j <= i){
                System.out.print("*");
                j++;
            }
            System.out.println();
            j = 0;
            i++;

        }
    }
}
