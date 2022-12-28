import java.util.*;

public class sentenceCreate {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        String x = sc.nextLine();
        String[] word = x.split(" ");

        List<String> list = new ArrayList<>();

        for(int i = 0; i < word.length; i++){
            list.add(i, word[i]);
        }

        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            String order = sc.nextLine();
            String[] option = order.split(" ");

            if (option[0].equals("A")) {
                list.add(Integer.parseInt(option[1]), option[2]);
            }
            else if (option[0].equals("D")) {
                list.remove(Integer.parseInt(option[1]));
            }
        }
        for (int i = 0; i < list.size(); i++){
            System.out.print(list.get(i) + " ");
        }
    }
}
