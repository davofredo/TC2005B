package serialization;

import domain.Appointment;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static serialization.CsvSerializer.Row;

public class AppointmentSerializer {
    private static final String FILE_NAME = "Appointment.csv";
    public static final String SERIALIZATION_PATH = "." + File.separator;

    private String getFileName() {
        return SERIALIZATION_PATH + FILE_NAME;
    }

    public void serialize(List<Appointment> list) throws IOException {
        String fileName = getFileName();
        CsvSerializer serializer = new CsvSerializer();
        serializer.setHeaders(new Row("ID", "ContactId", "Contact", "Subject", "Time"));
        for (Appointment c : list) {
            serializer.addRow(new Row(
                    c.getId(),
                    c.getContactId(),
                    c.getSubject(),
                    c.getTime()));
        }

        try (PrintWriter writer = new PrintWriter(fileName, StandardCharsets.UTF_8)) {
            for (String line : serializer) {
                writer.println(line);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public List<Appointment> deserialize() {
        String fileName = getFileName();
        List<Appointment> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            if (scanner.hasNextLine())
                scanner.nextLine();
            while (scanner.hasNextLine()) {
                Row row = Row.deserialize(scanner.nextLine());
                Appointment appointment = new Appointment();
                appointment.setId(Integer.parseInt(row.getValueAt(0)));
                appointment.setContactId(Integer.parseInt(row.getValueAt(1)));
                appointment.setSubject(row.getValueAt(2));
                appointment.setTime(LocalDateTime.parse(row.getValueAt(3)));
                list.add(appointment);
            }
        } catch (Exception e) {
            System.err.printf("Table reading failed due to error %s: %s%n", e.getClass().getName(), e.getMessage());
            System.err.printf("Changes may not be saved if the error persist");
        }

        return list;
    }
}
