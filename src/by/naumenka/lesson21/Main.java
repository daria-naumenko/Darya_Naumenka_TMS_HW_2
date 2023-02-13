package by.naumenka.lesson21;

//Max,Winston,male,14
//Jaime,Blossom,female,34
//Darya,Naumenka,female,19

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Person> people = new ArrayList<>();
        int ageCount;
        int maleCount;
        int femaleCount;
        String separator = ",";

        System.out.println("Введите ваш путь к файлу");
        String path = new Scanner(System.in).nextLine(); //  src\\document.txt

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String document;
            String[] infPerson;
            while ((document = br.readLine()) != null) {
                infPerson = document.split(separator);
                people.add(new Person(infPerson[0].trim(), infPerson[1].trim(), infPerson[2].trim(), Integer.parseInt(infPerson[3].trim())));
                System.out.println(document);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Не верный путь!");
        }

        people.sort(Comparator.comparing(p -> (p.getFirstName() + p.getLastName())));

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            for (Person person : people) {
                bw.write(person.getFirstName() + separator + person.getLastName() + separator +
                        person.getSex() + separator + person.getAge() + "\n");
            }
        } catch (IOException ex) {
            throw new RuntimeException();
        }

        ageCount = (int) people.stream().filter(age -> age.getAge() > 30).count();
        System.out.println();
        System.out.println("Люди старше 30 лет : " + ageCount);
        maleCount = (int) people.stream().filter(male -> male.getSex().trim().equals("male")).count();
        System.out.println("Мужчин : " + maleCount);
        femaleCount = (int) people.stream().filter(female -> female.getSex().trim().equals("female")).count();
        System.out.println("Женщин : " + femaleCount);
    }
}