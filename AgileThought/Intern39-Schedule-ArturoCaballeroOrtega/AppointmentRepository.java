import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppointmentRepository {
    private static int ID_SEQUENCE = 0;

    private List<Appointment> appointmentList = new ArrayList<>();

    public List<Appointment> findAll() {
        return appointmentList
                .stream()
                .map(Appointment::new)
                .collect(Collectors.toList());
    }

    public List<Appointment> findAll(Predicate<Appointment> predicate) {
        if (predicate == null)
            return findAll();
        return appointmentList
                .stream()
                .filter(predicate)
                .map(Appointment::new)
                .collect(Collectors.toList());
    }

    public Appointment save(Appointment a) {
        Appointment clone = new Appointment(a);
        if (clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = appointmentList.indexOf(a);
        if (index > -1)
            appointmentList.set(index, clone);
        else
            appointmentList.add(clone);

        return new Appointment(clone);
    }

    public void delete(Integer id) {
        appointmentList = appointmentList
                .stream()
                .filter(a -> !a.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Appointment> findAllByDay(String day) {
        return appointmentList
                .stream()
                .filter(a -> SpecificationUtils.like(String.format("%s", a.getTime()), day))
                .map(Appointment::new)
                .collect(Collectors.toList());
    }

}
