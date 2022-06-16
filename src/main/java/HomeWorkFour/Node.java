package HomeWorkFour;

public class Node {
    private String item;
    Node next;
    Node prev;

    public Node(String item) {
        this.item = item;
    }

    public String display() {
        return String.format("N[%s] ",this.item);
    }

    String getItem() {
        return item;
    }

    void setItem(String item) {
        this.item = item;
    }
}
