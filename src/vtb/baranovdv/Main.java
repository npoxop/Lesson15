package vtb.baranovdv;

import java.util.Arrays;
import java.util.Comparator;

// Написать класс PersonSuperComparator,
// который реализует Comparator, но умеет сравнивать по двум параметрам , возраст и имя.
// Класс Person теперь содержит два поля int age и String name

public class Main {
    public static void main(String[] args) {
        Person[] person = new Person[6];
        person[0] = new Person("Вася", 28);
        person[1] = new Person("Даня", 35);
        person[2] = new Person("Миша", 24);
        person[3] = new Person("Олег", 31);
        person[4] = new Person("Саша", 45);
        person[5] = new Person("Антон", 19);

        Arrays.sort(person, PersonSuperComparator.AgeComparator);
        System.out.println("С сортировкой по возрасту:");
        for (Person p:person)
            System.out.println(p);

        Arrays.sort(person, PersonSuperComparator.NameComparator);
        System.out.println("С сортировкой по имени:");
        for (Person p:person)
            System.out.println(p);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return name + " " + String.valueOf(age) + "\n";
    }
}

class PersonSuperComparator implements Comparator<Person> {
    public static Comparator<Person> AgeComparator = new Comparator<Person>() {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getAge() - e2.getAge();
        }
    };
    public static Comparator<Person> NameComparator = new Comparator<Person>() {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getName().compareTo(e2.getName());
        }
    };

    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }
}