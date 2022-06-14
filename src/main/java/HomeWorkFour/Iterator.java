package HomeWorkFour;

public class Iterator implements Iterable{

    private Node current;
    private Node previous;
    private LinkedList list;

    public Iterator(LinkedList list) {
        this.list = list;
        this.reset();
    }

    @Override
    public void reset() {
        current = list.getHead();
        previous = null;
    }

    @Override
    public void next() {
        previous = current;
        current= current.next;
    }

    @Override
    public Node getCurrent() {
        return current;
    }

    @Override
    public boolean atEnd() {
        return current.next == null;
    }

    @Override
    public void insertAfter(String obj) {
        Node newNode = new Node(obj);
        if (list.isEmpty()) {
            list.setHead(newNode);
        } else {
            newNode.next = current.next;
            current.next = newNode;
            next();
        }
    }

    @Override
    public void insertBefore(String obj) {
        Node newNode = new Node(obj);
        if (list.isEmpty()) {
            newNode.next = list.getHead();
            list.setHead(newNode);
            reset();
        } else {
            newNode.next = previous.next;
            previous.next = newNode;
            current = newNode;
        }
    }

    @Override
    public String deleteCurrent() {
        Node tmp = current;
        if (previous == null){
            list.setHead(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }
        return tmp.getItem();
    }

    @Override
    public void showCurrent() {
        System.out.println(this.getCurrent().display());
    }
}
