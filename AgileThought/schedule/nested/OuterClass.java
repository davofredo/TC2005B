package nested;

public class OuterClass {
    private static final String STATIC_FIELD = "STATIC VALUE";
    private String nonStaticField = "non-static value";

    public static void main(String[] args) {
        // For nested classes, we can access the constructor from the name of the outer class
        OuterClass.NestedClass nested = new OuterClass.NestedClass();
        // For inner classes, we cannot access the constructor from the name of the outer class
        // OuterClass.InnerClass inner = new OuterClass.InnerClass();
        // In order to reach the constructor of an inner class, we need to create an instance of the outer class.
        OuterClass outer = new OuterClass();
        OuterClass.InnerClass inner = outer.getInnerClass();
    }

    public OuterClass() {
        /**
         * This is a local class
         * Local classes are defined into a method and are not available out of the method that defines them.
         */
        class LocalClass {
            public LocalClass() {
                System.out.println(STATIC_FIELD);
                // Can access instance fields
                System.out.println(nonStaticField);
            }
        }
        LocalClass lc = new LocalClass();
        LocalClass lc1 = new LocalClass();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(STATIC_FIELD);
                // Can access instance fields
                System.out.println(nonStaticField);
            }
        };
    }

    public OuterClass(String param) {
        NestedClass nestedClass = new NestedClass();
        InnerClass innerClass = new InnerClass();
    }

    /**
     * This is a nested class.
     * Nested classes are always static and can only access static fields of the outer class.
     */
    public static class NestedClass {
        public NestedClass() {
            System.out.println(STATIC_FIELD);
            // Cannot access instance fields
            // System.out.println(nonStaticField);
        }
    }

    /**
     * This is an inner class.
     * This class can only be created from an instance of OuterClass and can access all the fields
     * defined into OuterClass, even instance fields.
     */
    public class InnerClass {
        public InnerClass() {
            System.out.println(STATIC_FIELD);
            // Can access instance fields
            System.out.println(nonStaticField);
        }
    }

    public InnerClass getInnerClass() {
        return new InnerClass();
    }
}

/**
 * This is not an Inner/Nested/Local class because it was not declared
 * into the body of another class.
 */
class PackageClass {

}