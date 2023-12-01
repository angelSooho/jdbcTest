package hello.jdbc.repository.ex;

public class MyDuplicateKetException extends MyDbException {
    public MyDuplicateKetException() {
    }

    public MyDuplicateKetException(String message) {
        super(message);
    }

    public MyDuplicateKetException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyDuplicateKetException(Throwable cause) {
        super(cause);
    }
}
