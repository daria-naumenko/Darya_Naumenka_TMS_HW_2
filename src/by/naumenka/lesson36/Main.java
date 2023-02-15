package by.naumenka.lesson36;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<String, Document> contractMap = new HashMap<>();
        Set<String> contractSet = new HashSet<>();

        try (Scanner path = new Scanner(new File("src/file.txt"))) {

            while (path.hasNextLine()) {
                String line = path.nextLine();
                String[] infDocument = line.split(",");
                String number = infDocument[0].trim();

                if (!contractSet.contains(number)) {
                    contractSet.add(number);

                    Document document = new Document();

                    document.setDocumentNumber(infDocument[1].trim());
                    document.setCreationDate(infDocument[2].trim());
                    document.setNameAuthor(infDocument[3].trim());

                    contractMap.put(number, document);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден!");
            return;
        }

        for (Map.Entry<String, Document> entry : contractMap.entrySet()) {
            System.out.println("Номер контракта: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}