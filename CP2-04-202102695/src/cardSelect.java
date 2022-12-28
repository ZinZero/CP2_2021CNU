import java.util.*;

public class cardSelect {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Queue<Integer> card = new LinkedList<>();

        for(int i = 1; i <= n; i++){
            card.offer(i);
        }

        for (int i = 0; i < n; i++){
            System.out.println(card.poll());
            for (int j = 0; j < k; j++){
                card.offer(card.poll());
            }
        }
    }
}
