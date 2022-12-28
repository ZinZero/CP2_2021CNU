import java.util.*;

public class menu {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();

        String temp = null;
        String[] menupan = new String[A];
        String[] cost = new String[A];
        String[] order = new String[B];

        for (int i = 0; i < A; i++){
            temp = sc.nextLine();
        }
        for (int i = 0; i < A; i++){
            menupan[i] = temp.split(" ")[0];
            cost[i] = temp.split(" ")[1];
        }

        for (int i = 0; i < B; i++){
            order[i] = sc.nextLine();
        }

    }
}


//컴프2 식당에서는 음식을 많이 주문하는 손님에게 약간의 음식 할인을 제공하기로 했다. 손님이 음식을 3개 이상 주문한다면,
// 주문한 음식 중 가장 저렴한 음식 하나가 50% 할인되어 계산서에 적용된다. 예를들어, 음식 A, B, C를 주문했고,
// 각각 가격이 10000원, 10000원, 5000원으로 책정되어 있을 때, 계산서에는 22500원이 적용된다. 컴프2 식당의 메뉴판과 주문된 음식 리스트가 주어졌을 때,
// 계산되는 가격의 총합을 구해보자.

//입력조건
//첫 번째 줄에 메뉴 수 A(1 <= A <= 20), 주문된 메뉴의 수 B(1 <= B <= 30)가 공백으로 구분되어 주어진다.
// 두 번째줄부터 A개의 메인메뉴가 이름과 가격(100,000 이하의 2로 나눌 수 있는 자연수)이 공백으로 구분되어 주어진다.
// 2 + A번째 줄부터 주문된 메뉴가 B개 주어진다.

//입력
//3 3
//A 10000
//B 10000
//C 5000
//A
//B
//C

//출력
//22500
