package repository;

import domain.Appointment;
import domain.Contact;
import interfaces.IRepository;
import serialization.ContactSerializer;
import specification.SpecificationUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactRepository implements IRepository<Contact> {
    private static int ID_SEQUENCE = 0;

    private List<Contact> contactList = new ArrayList<>();
    private AppointmentRepository appointmentRepository;
    private final ContactSerializer contactSerializer;

    ContactRepository() {
        contactSerializer = new ContactSerializer();
        contactList = contactSerializer.deserialize();
        ID_SEQUENCE =
        contactList.stream().map(Contact::getId).max(Integer::compare).orElse(0);
    }

    private AppointmentRepository getAppointmentRepository() {
        if (appointmentRepository == null)
            appointmentRepository = (AppointmentRepository) SingletonRepository
                    .getSingleton(SingletonRepository.KEY_APPOINTMENT_REPOSITORY);
        return appointmentRepository;
    }

    @Override
    public synchronized List<Contact> findAll() {
        return contactList
                .stream() // contactList genera stream de salida a través de la función stream()
                // Stream de entrada va a la operación map
                .map(InnerContact::new)
                // Map genera stream de salida
                // Stream de entrada va a la operación collect
                .collect(Collectors.toList());
    }

    public synchronized List<Contact> findAll(Predicate<? super Contact> predicate) {
        if (predicate == null)
            return findAll();
        // La referencia al método puede reemplazar la expresión lambda
        return contactList
                .stream()
                .filter(predicate)
                // filter() -> stream -> map()
                .map(InnerContact::new)
                .collect(Collectors.toList());
    }

    @Override
    public synchronized Optional<? extends Contact> findOne(Integer id) {
        return contactList
                .stream().filter(a -> Objects.equals(a.getId(), id)) .map(InnerContact::new)
                .findFirst();
    }

    public List<Contact> findAllByName(String name) {
        return contactList
                .stream()
                .filter(c -> SpecificationUtils.like(String.format("%s %s", c.getFirstName(), c.getLastName()), name))
                .map(InnerContact::new)
                .collect(Collectors.toList());
    }

    @Override
    public synchronized Contact save(Contact c) throws IOException {
        Contact clone = new Contact(c);
        if (clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = contactList.indexOf(c);
        if (index > -1)
            contactList.set(index, clone);
        else
            contactList.add(clone);

        contactSerializer.serialize(contactList);

        return new Contact(clone);
    }

    @Override
    public synchronized void delete(Integer id) throws IOException {
        contactList = contactList
                .stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());
        contactSerializer.serialize(contactList);
    }

    private class InnerContact extends Contact {
        private boolean appointmentLoaded = false;

        private InnerContact(Contact source) {
            super(source);
        }

        @Override
        public List<Appointment> getAppointments() {
            if (!appointmentLoaded) {
                if (super.getAppointments() == null)
                    setAppointments(getAppointmentRepository().findAllByContactId(getId()));
                appointmentLoaded = true;
            }

            return super.getAppointments();
        }
    }
}
