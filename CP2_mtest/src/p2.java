import java.util.*;


public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String num = sc.nextLine();
        String[] numm = num.split(" ");

        int N = Integer.parseInt(numm[0]);
        int K = Integer.parseInt(numm[1]);

        Queue human = new LinkedList();

        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            human.offer(str);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < K - 1; j++) {
                human.offer(human.poll());
            }
            System.out.print(human.poll() + " ");
        }
    }
}
