import java.util.ArrayList;
import java.util.Scanner;

enum Fruits     {apple, banana, berry, grape, kiwi, lemon, mango, melon, orange, peach}
enum Animals    {cat, chicken, cow, dog, dolphin, duck, lion, pig, tiger, whale}
enum Cities     {beijing, berlin, london, moscow, newyork, paris, rome, seoul, sydney, tokyo}

class Object {
    String name;
    public Object(String n)     { name = n; }
    public String toString()    { return name;}
}

class Fruit extends Object      { public Fruit(String s){ super(s); }}
class Animal extends Object     { public Animal(String s){ super(s); }}
class City extends Object       { public City(String s){ super(s); }}
class Other extends Object      { public Other(String s){ super(s); }}

public class ClassifyThings {
    public static void main(String[] args) {
        Box<Fruit>  fruitBox = new Box<>();
        Box<Animal> animalBox = new Box<>();
        Box<City>   subjectBox = new Box<>();
        Box<Other>  otherBox = new Box<>();

        // 스캐너로 입력받고 things 배열에 split 해서 저장
        Scanner sc = new Scanner(System.in);
        String[] things = sc.nextLine().split(" ");
        sc.close();

        // for 문을 배열 길이만큼 돌린다.
        // if 문에 조건을 contains(열거형 이름.vlaues(), things[i])로 한다.
        // 조건에 맞으면 각각 Box에 add를 이용해서 넣는다.
        // Fruits, Animals, Cities 에 포함되지 않는 내용은 otherBox 에 넣는다.
        for (int i = 0; i < things.length; i++){
            if (contains(Fruits.values(), things[i])){
                fruitBox.add(new Fruit(things[i]));
            }else if(contains(Animals.values(), things[i])){
                animalBox.add(new Animal(things[i]));
            }else if(contains(Cities.values(), things[i])){
                subjectBox.add(new City(things[i]));
            }else{
                otherBox.add(new Other(things[i]));
            }
        }

        System.out.println(fruitBox);
        System.out.println(animalBox);
        System.out.println(subjectBox);
        System.out.println(otherBox);
    }

    @SuppressWarnings("rawtypes")
    static <T extends Enum> boolean contains(T[] temp, String thing) {

        // for 문을 temp 의 길이만큼 돌린다.
        // if 의 조건을 temp 의 원소와 thing이 같으면 true 를 반환하고 아닐 때는 false 를 반환한다.
        for (int i = 0; i < temp.length; i++){
            if (temp[i].name().equals(thing)){
                return true;
            }
        }
        return false;
    }
}

class Box<T> {
    ArrayList<T> list = new ArrayList<>();
    void add(T item)            { list.add(item); }
    public String toString()    { return list.toString(); }
}