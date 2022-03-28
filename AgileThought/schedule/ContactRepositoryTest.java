import domain.Appointment;
import domain.Contact;
import repository.ContactRepository;
import repository.SingletonRepository;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static repository.SingletonRepository.getSingleton;
import static repository.SingletonRepository.KEY_CONTACT_REPOSITORY;

public class ContactRepositoryTest {

    public static void main(String[] args) throws IOException {
        ContactRepository contactRepository = (ContactRepository) getSingleton(KEY_CONTACT_REPOSITORY);

        Contact contact;

        contact = new Contact();
        contact.setFirstName("Pablo");
        contact.setLastName("Castaneda");
        contact.setEmailAddress("pablo.1.gmail.com");
        contact.setPhoneNumber("1111111111");
        contact.setBirthDay(LocalDate.of(1997, 12, 31));
        contactRepository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastName("Cerritos");
        contact.setEmailAddress("david.1.gmail.com");
        contact.setPhoneNumber("2222222222");
        contact.setBirthDay(LocalDate.of(1995, 12, 30));
        contactRepository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastName("Barredo");
        contact.setEmailAddress("david.2.gmail.com");
        contact.setPhoneNumber("3333333333");
        contact.setBirthDay(LocalDate.of(1985, 5, 25));
        contactRepository.save(contact);

        System.out.println("\nAll the contacts...");
        contactRepository.findAll().forEach(System.out::println);

        System.out.println("\nAll the Davids");
        contactRepository.findAllByName("DAVID").forEach(System.out::println);

        System.out.println("\nEveryone who has a birthday on December");
        contactRepository
        .findAll(c -> c.getBirthDay().getMonth() == Month.DECEMBER)
        .forEach(System.out::println);

        //Optional<? extends Contact> optSelect = contactRepository.findOne(2);
        //Contact select = optSelect.get();
        List<Contact> contacts = contactRepository.findAll();
        //System.out.println(contacts.get(1));

        for (Contact select : contacts) {
            for (Appointment appointment : select.getAppointments()) {
                System.out.println("Contact # " + select.getId());
                System.out.println("Appoinment: " + appointment);
                System.out.println("Contact name: " + select.getFirstName() + " " + select.getLastName());
            }
        }
    }

    public static void saveContacts() throws IOException {
        ContactRepository contactRepository = (ContactRepository) SingletonRepository
                .getSingleton(KEY_CONTACT_REPOSITORY);

        Contact contact;

        contact = new Contact();
        contact.setFirstName("Pablo");
        contact.setLastName("Castaneda");
        contact.setEmailAddress("pablo.1.gmail.com");
        contact.setPhoneNumber("1111111111");
        contact.setBirthDay(LocalDate.of(1997, 12, 31));
        contactRepository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastName("Cerritos");
        contact.setEmailAddress("david.1.gmail.com");
        contact.setPhoneNumber("2222222222");
        contact.setBirthDay(LocalDate.of(1995, 12, 30));
        contactRepository.save(contact);

        contact = new Contact();
        contact.setFirstName("David");
        contact.setLastName("Barredo");
        contact.setEmailAddress("david.2.gmail.com");
        contact.setPhoneNumber("3333333333");
        contact.setBirthDay(LocalDate.of(1985, 5, 25));
        contactRepository.save(contact);
    }

}
