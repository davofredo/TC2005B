package repository;

import domain.Appointment;
import domain.Contact;
import interfaces.IRepository;
import serialization.AppointmentSerializer;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AppointmentRepository implements IRepository<Appointment> {
    private static int ID_SEQUENCE = 0;

    private List<Appointment> appointmentList = new ArrayList<>();
    private ContactRepository contactRepository;
    private final AppointmentSerializer appointmentSerializer;

    AppointmentRepository() {
        appointmentSerializer = new AppointmentSerializer();
        appointmentList = appointmentSerializer.deserialize();
        ID_SEQUENCE = appointmentList.stream().map(Appointment::getId).max(Integer::compare).orElse(0);
    }

    private ContactRepository getContactRepository() {
        if (contactRepository == null)
            contactRepository = (ContactRepository) SingletonRepository
                    .getSingleton(SingletonRepository.KEY_CONTACT_REPOSITORY);
        return contactRepository;
    }

    @Override
    public List<Appointment> findAll() {
        return appointmentList.stream().map(Appointment::new).collect(Collectors.toList());
    }

    public List<Appointment> findAll(Predicate<? super Appointment> predicate) {
        if (predicate == null)
            return findAll();
        return appointmentList.stream().filter(predicate).map(InnerAppointment::new).collect(Collectors.toList());
    }

    @Override
    public Optional<? extends Appointment> findOne(Integer id) {
        return appointmentList
                .stream().filter(a -> Objects.equals(a.getId(), id)).map(InnerAppointment::new)
                .findFirst();
    }

    public List<Appointment> findAllByDate(LocalDate date) {
        return appointmentList
                .stream()
                .filter(c -> date.isEqual(c.getTime().toLocalDate()))
                .map(InnerAppointment::new)
                .collect(Collectors.toList());
    }

    public List<Appointment> findAllByContactId(int id) {
        return appointmentList
                .stream()
                .filter(a -> Objects.equals(a.getContactId(), id))
                .map(InnerAppointment::new)
                .collect(Collectors.toList());
    }

    @Override
    public synchronized Appointment save(Appointment c) throws IOException {
        Appointment clone = new InnerAppointment(c);
        if (clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = appointmentList.indexOf(clone);
        if (index > -1)
            appointmentList.set(index, clone);
        else
            appointmentList.add(clone);

        appointmentSerializer.serialize(appointmentList);

        return new InnerAppointment(clone);
    }

    @Override
    public synchronized void delete(Integer id) throws IOException {
        appointmentList = appointmentList.stream().filter(c -> !c.getId().equals(id)).collect(Collectors.toList());
        appointmentSerializer.serialize(appointmentList);
    }

    private class InnerAppointment extends Appointment {
        private boolean contactLoaded = false;

        private InnerAppointment(Appointment source) {
            super(source);
        }

        @Override
        public Contact getContact() {
            if (!contactLoaded) {
                if (super.getContact() == null && getContactId() != null)
                    setContact(getContactRepository().findOne(getContactId()).orElse(null));
                contactLoaded = true;
            }

            return super.getContact();
        }
    }

}
