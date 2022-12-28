import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Stream_ex {
    public static void main(String[] args){
        List<Integer> list = Arrays.asList(4, 7, 8, 9, 3, 2, 1, 5, 6, 10);

        list.stream().filter(n -> n % 2 == 0).forEach(x -> System.out.print(x + " "));
        System.out.println("");

        long count = list.stream().map(n -> n + 4).filter(n -> n-5 > 0).count();
        System.out.println(count);

        filter_print(list, x -> x%3 == 0);
        System.out.println("");

        list.stream().sorted().forEach(x -> System.out.print(x + " "));
        System.out.println("");

        list.stream().sorted((x, y) -> y-x).forEach(x -> System.out.print(x + " "));
    }
    public static void filter_print(List<Integer> list, Predicate<Integer> f){
        list.stream().filter(f).forEach(x -> System.out.print(x + " "));
    }
}