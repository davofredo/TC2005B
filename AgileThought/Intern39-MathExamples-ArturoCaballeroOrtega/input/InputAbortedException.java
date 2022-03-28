package input;

public class InputAbortedException extends Exception {
    public InputAbortedException() {
        super("Input aborted by user.");
    }
}
