package specification;

public class SpecificationUtils {
    private SpecificationUtils() {}

    public static boolean like(String source, String substr) {
        if(source == null)
            return false;
        if(substr == null)
            return true;
        return source.toLowerCase().contains(substr.toLowerCase());
    }

}
