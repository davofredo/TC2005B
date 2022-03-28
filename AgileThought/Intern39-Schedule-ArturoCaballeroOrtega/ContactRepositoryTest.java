import java.time.LocalDate;
import java.time.Month;

public class ContactRepositoryTest {
    public static void main(String[] args) {
        ContactRepository contactRepository = (ContactRepositoryTest) SingletonRepository.getSingleton("");

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
        contact.setLastName("Santander");
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
        contactRepository.findAllByName("David").forEach(System.out::println);

        System.out.println("\nEveryone who has a birthday on December");
        contactRepository.findAll(c -> c.getBirthDay().getMonth() == Month.DECEMBER).forEach(System.out::println);
    }
}
