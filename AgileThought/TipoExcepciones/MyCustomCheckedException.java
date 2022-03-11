import java.io.IOException;

public class MyCustomCheckedException extends IOException {

    public MyCustomCheckedException(String extra) {
        super(extra);
    }
    
}
