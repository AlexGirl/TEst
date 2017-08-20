import java.util.*;

public class TestClass {
    ArrayList<Animals> list = new ArrayList<>();

    ArrayList<Dog> dogs = new ArrayList<Dog>();
    List<Dog> anim = dogs;

    public static void main(String[] args) {
        new TestClass().go();
    }

    public void go(){
        HashSet<Animals> hashSet = new HashSet<>();
        TreeSet<Animals> treeSet = new TreeSet<>();

        Animals a = new Animals("Time");
        Animals a1 = new Dog("For");
        Animals a2 = new Cat("Killing");
        for (int i = 0; i < 5; i++) {
            list.add(a);
            list.add(a1);
            list.add(a2);
        }

        hashSet.addAll(list);
        treeSet.addAll(hashSet);
        for (Animals m : treeSet) {
            System.out.println(m.getType());
        }

        HashMap<String, Animals> hm = new HashMap<>();
        hm.put("Time", list.get(0));
        hm.put("For", list.get(1));
        hm.put("Killing", list.get(2));

        System.out.println(hm);
        takeAnimals(list);
    }

    public void takeAnimals(ArrayList<? extends Animals> animalses){
        System.out.println(animalses.get(1));
    }
}

class Animals implements Comparable<Animals>{

    private String type;

    public Animals(String a){
        type = a;
    }

    public boolean equals(Object aType){
        Animals a = (Animals) aType;
        return getType().equals(a.getType());
    }

    public int hashCode(){
        return type.hashCode();
    }

    @Override
    public int compareTo(Animals animal) {
        return type.compareTo(animal.getType());
    }
    public String getType(){
        return type;
    }

    public void setType(String str){
        type = str;
    }
}

class Dog extends Animals {

    String title;
    public Dog(String a) {
        super(a);
    }

    public String getTitle(){
        return title;
    }
}

class Cat extends Animals {

    String title;
    public Cat(String a) {
        super(a);
    }

    public String getTitle(){
        return title;
    }
}
