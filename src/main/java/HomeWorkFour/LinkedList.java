package HomeWorkFour;

public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void insert(String obj) {
        Node newNode = new Node(obj);
        if (this.isEmpty()) {
            this.head = newNode;
        } else {
            Node temp = this.tail;
            temp.next = newNode;
            newNode.prev = temp;
        }
        this.tail = newNode;
    }

    public void display() {
        Node current = this.head;
        if (!this.isEmpty()) {
            while (current != null) {
                System.out.print(current.display());
                current = current.next;
            }
            System.out.print("\n");
        }

    }

    public String delete(){
        if (isEmpty()) {
            return null;
        } else {
            Node tmp = this.head;
            this.head = head.next;
            return tmp.getItem();
        }
    }

    public String getFirst() {
        return head.getItem();
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    public boolean isInList(String obj){
        Node current = this.head;
        if (!this.isEmpty()) {
            while (current != null) {
                if (current.getItem().equals(obj)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public Iterator getIterator(){
        return new Iterator(this);
    }
}
