package by.naumenka.lesson21;

//Darya,Naumenka,female,19
//Jaime,Blossom,female,34
//Max,Winston,male,14

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<Person> people = new ArrayList<>();
        int ageCount, maleCount, femaleCount;
        String separator = ",";

        System.out.println("Введите ваш путь к файлу");
        String path = new Scanner(System.in).nextLine(); //  src\\document.txt
        BufferedReader br = new BufferedReader(new FileReader(path));

        String document;
        String[] infPerson;
        while ((document = br.readLine()) != null) {
            infPerson = document.split(separator);
            people.add(new Person(infPerson[0], infPerson[1], infPerson[2], Integer.parseInt(infPerson[3].trim())));
            System.out.println(document);
        }

        people.sort(Comparator.comparing(p -> (p.getFirstName() + p.getLastName())));

        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for (Person person : people) {
            bw.write(person.getFirstName() + separator + person.getLastName() + separator +
                    person.getSex() + separator + person.getAge() + "\n");
        }

        ageCount = (int) people.stream().filter(o -> o.getAge() > 30).count();
        maleCount = (int) people.stream().filter(o -> o.getSex().trim().equals("male")).count();
        femaleCount = (int) people.stream().filter(o -> o.getSex().trim().equals("female")).count();

        System.out.println();
        System.out.println("count : " + ageCount);
        System.out.println("male : " + maleCount);
        System.out.println("female : " + femaleCount);
    }
}