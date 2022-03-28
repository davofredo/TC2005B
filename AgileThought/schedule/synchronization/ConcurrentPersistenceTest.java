package synchronization;

import repository.ContactRepository;
import repository.SingletonRepository;
import static repository.SingletonRepository.KEY_CONTACT_REPOSITORY;

import java.io.IOException;
import java.time.LocalDate;

import domain.Contact;

public class ConcurrentPersistenceTest {

    public static void main(String[] args) {
        ContactCreator1 c1 = new ContactCreator1();
        ContactCreator2 c2 = new ContactCreator2();
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        Thread t3 = new Thread(c1);
        Thread t4 = new Thread(c2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }


    static class ContactCreator1 implements Runnable {
        private final ContactRepository contactRepository;

        public ContactCreator1() {
            contactRepository = (ContactRepository) SingletonRepository.getSingleton(KEY_CONTACT_REPOSITORY);
        }

        public void run() {
            try {
                Contact thomas = new Contact();
                thomas.setFirstName("Tomas");
                thomas.setLastName("Gomez");
                thomas.setPhoneNumber("7221008709");
                thomas.setEmailAddress("tgomez@somedomain.com");
                thomas.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact miguel = new Contact();
                miguel.setFirstName("Miguel");
                miguel.setLastName("Hernandez");
                miguel.setPhoneNumber("7221008709");
                miguel.setEmailAddress("mhernandez@somedomain.com");
                miguel.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact theresa = new Contact();
                theresa.setFirstName("Theresa");
                theresa.setLastName("Garcia");
                theresa.setPhoneNumber("7221008709");
                theresa.setEmailAddress("tgarcia@somedomain.com");
                theresa.setBirthDay(LocalDate.parse("1994-04-18"));

                contactRepository.save(thomas);
                contactRepository.save(miguel);
                contactRepository.save(theresa);

            } catch (IOException e) {
                System.err.println("There were problems  when persisting contacts");
            }   
        }
    }

    static class ContactCreator2 implements Runnable {
        private final ContactRepository contactRepository;

        public ContactCreator2() {
            contactRepository = (ContactRepository) SingletonRepository.getSingleton(KEY_CONTACT_REPOSITORY);
        }

        public void run() {
            try {
                Contact vicente = new Contact();
                vicente.setFirstName("Vicente");
                vicente.setLastName("Trejo");
                vicente.setPhoneNumber("7221008709");
                vicente.setEmailAddress("vtrejoz@somedomain.com");
                vicente.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact carmen = new Contact();
                carmen.setFirstName("Carmen");
                carmen.setLastName("Quintal");
                carmen.setPhoneNumber("7221008709");
                carmen.setEmailAddress("cquintal@somedomain.com");
                carmen.setBirthDay(LocalDate.parse("1994-04-18"));

                Contact jose = new Contact();
                jose.setFirstName("Jose");
                jose.setLastName("Mendez");
                jose.setPhoneNumber("7221008709");
                jose.setEmailAddress("jmendez@somedomain.com");
                jose.setBirthDay(LocalDate.parse("1994-04-18"));

                contactRepository.save(vicente);
                contactRepository.save(carmen);
                contactRepository.save(jose);
                
            } catch (IOException e) {
                System.err.println("There were problems  when persisting contacts");
            }   
        }
    }
}
