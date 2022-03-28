import java.time.LocalDateTime;

public class AppointmentRepositoryTest {
    public static void main(String[] args) {
        AppointmentRepository appointmentRepository = new AppointmentRepository();

        Appointment appointment;

        appointment = new Appointment();
        appointment.setContactId(123456);
        appointment.setSubject("Ir a la tienda");
        appointment.setTime(LocalDateTime.of(2022, 03, 15, 15, 23, 33));
        //appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(78910);
        appointment.setSubject("Terminar trabajo");
        appointment.setTime(LocalDateTime.of(2022, 04, 15, 15, 23, 33));
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(78999);
        appointment.setSubject("Enviar el trabajo");
        appointment.setTime(LocalDateTime.of(2022, 04, 15, 15, 24, 59));
        appointmentRepository.save(appointment);

        appointment = new Appointment();
        appointment.setContactId(1640429);
        appointment.setSubject("Viajar por el mundo");
        appointment.setTime(LocalDateTime.of(2023, 8, 12, 10, 30));
        appointmentRepository.save(appointment);
        //System.out.println("All the appointment");
        //appointmentRepository.findAll().forEach(System.out::println);

        //appointmentRepository.findAll(a -> a.getTime() == LocalDateTime.of(2022, 04, 15, 15, 23, 33)).forEach(System.out::println);
        appointmentRepository.findAllByDay("2023-08").forEach(System.out::println);

    }
}
