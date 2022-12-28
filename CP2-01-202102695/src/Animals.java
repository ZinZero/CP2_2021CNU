import java.util.Scanner;

public class Animals {

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        String input = sc.next();
        sc.close();

        Animal a = null;
        switch(input) {
            case "Butterfly":
                a = new Butterfly();
                break;
            case "Duck":
                a = new Duck();
                break;
            case "Whale":
                a = new Whale();
                break;
        }

        a.explain();
        if(a instanceof Flyable) {
            ((Flyable) a).AddAnExplanationOfFlight();
        }
        if(a instanceof Swimable) {
            ((Swimable) a).AddAnExplanationOfSwim();
        }

        System.out.println(a.comment);
    }

}

class Animal {
    String comment = "";
    int legs;

    void explain() {
        comment += "Here is a(an) " + this.getClass().getSimpleName() + ".\n";
        comment += "It has " + legs + " legs.\n";
    }
}



interface Flyable {
    static String flight = "And it can fly.\n";

    abstract void AddAnExplanationOfFlight();
}

interface Swimable {
    static String swim = "And it can swim.\n";

    abstract void AddAnExplanationOfSwim();
}

class Butterfly extends Animal implements Flyable{
    Butterfly(){
        this.legs = 6;}

    @Override
    public void AddAnExplanationOfFlight() {
        this.comment += flight;
    }
}

class Duck extends Animal implements Swimable, Flyable {
    Duck(){
        this.legs = 2;
    }

    @Override
    public void AddAnExplanationOfFlight() {
        this.comment += flight;
    }

    @Override
    public void AddAnExplanationOfSwim() {
        this.comment += swim;
    }
}

class Whale extends Animal implements Swimable {
    Whale(){
        this.legs = 0;
    }

    @Override
    public void AddAnExplanationOfSwim() {
        this.comment += swim;
    }
}
