package repository;

import java.util.HashMap;
import java.util.Map;

public class SingletonRepository {
    public static final String KEY_CONTACT_REPOSITORY = "contactRepository";
    public static final String KEY_APPOINTMENT_REPOSITORY = "appointmentRepository";

    private static Map<String, Object> singletonMap;

    static {
        singletonMap = new HashMap<>();
        singletonMap.put(KEY_CONTACT_REPOSITORY, new ContactRepository());
        singletonMap.put(KEY_APPOINTMENT_REPOSITORY, new AppointmentRepository());
    }

    private SingletonRepository() {}

    public static Object getSingleton(String key) {
        return singletonMap.get(key);
    }

}
