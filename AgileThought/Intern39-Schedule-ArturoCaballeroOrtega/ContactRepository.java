import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ContactRepository {
    private static int ID_SEQUENCE = 0;

    private List<Contact> contactList = new ArrayList<>();

    ContactRepository() {}

    public List<Contact> findAll() {
        return contactList
                // contactList genera stream de salida a través de la funcion stream()
                .stream() // Exportando a stream
                // stream de entrada va a la operacion map
                .map(Contact::new)
                // Map genera stream de salida
                // Stream de entrada va a la operacion collect
                .collect(Collectors.toList());
    }

    public List<Contact> findAll(Predicate<Contact> predicate) {
        if (predicate == null)
            return findAll();
        // La referencia al metodo puede remplazar la expresion lambda
        return contactList
                .stream()
                .filter(predicate)
                // filter() -> stream -> map()
                .map(Contact::new)
                .collect(Collectors.toList());
    }

    public Contact save(Contact c) {
        Contact clone = new Contact(c);
        if (clone.getId() == null)
            clone.setId(++ID_SEQUENCE);

        int index = contactList.indexOf(c);
        if (index > -1)
            contactList.set(index, clone);
        else
            contactList.add(clone);

        return new Contact(clone);
    }

    public void delete(Integer id) {
        contactList = contactList
                .stream()
                .filter(c -> !c.getId().equals(id))
                .collect(Collectors.toList());
    }

    public List<Contact> findAllByName(String name) {
        return contactList
                .stream()
                .filter(c -> SpecificationUtils.like(String.format("%s %s", c.getFirstName(), c.getLastName()), name))
                .map(Contact::new)
                .collect(Collectors.toList());
    }
}
