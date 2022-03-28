package serialization;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Contact;
import static serialization.CsvSerializer.Row;

public class ContactSerializer {
    private static final String FILE_NAME = "Contact.csv";
    public static final String SERIALIZATION_PATH = "." + File.separator;

    private String getFileName() {
        return SERIALIZATION_PATH + FILE_NAME;
    }

    public void serialize(List<Contact> list) throws IOException {
        String fileName = getFileName();
        CsvSerializer serializer = new CsvSerializer();
        serializer.setHeaders(new Row("ID", "First Name", "Last Name", "Email Address", "Phone Number", "Birthday"));
        for (Contact c : list) {
            serializer.addRow(new Row(
                    c.getId(),
                    c.getFirstName(),
                    c.getLastName(),
                    c.getEmailAddress(),
                    c.getPhoneNumber(),
                    c.getBirthDay()));
        }

        try (PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8)) {
            for (String line : serializer) {
                writer.println(line);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public List<Contact> deserialize() {
        String fileName = getFileName();
        List<Contact> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            if (scanner.hasNextLine())
                scanner.nextLine();
            while (scanner.hasNextLine()) {
                Row row = Row.deserialize(scanner.nextLine());
                Contact contact = new Contact();
                contact.setId(Integer.parseInt(row.getValueAt(0)));
                contact.setFirstName(row.getValueAt(1));
                contact.setLastName(row.getValueAt(2));
                contact.setEmailAddress(row.getValueAt(3));
                contact.setPhoneNumber(row.getValueAt(4));
                contact.setBirthDay(LocalDate.parse(row.getValueAt(5)));
                list.add(contact);
            }
        } catch (Exception e) {
            System.err.printf("Table reading failed due to error %s: %s%n", e.getClass().getName(), e.getMessage());
            System.err.printf("Changes may not be saved if the error persist");
        }

        return list;
    }
}
