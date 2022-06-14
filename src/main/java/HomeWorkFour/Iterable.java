package HomeWorkFour;

public interface Iterable {
    void reset();

    void next();

    Node getCurrent();

    boolean atEnd();

    void insertAfter(String obj);

    void insertBefore(String obj);

    String deleteCurrent();

    void showCurrent();
}
