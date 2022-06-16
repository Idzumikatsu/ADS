package HomeWorkFour;

public class MainApp {
    public static void main(String[] args) {
        // 1. Итератор на двусвязном списке
        LinkedList list = new LinkedList();
        list.insert("1");
        list.insert("2");
        list.insert("3");
        list.insert("4");
        list.insert("5");
        list.display();
        Iterator iter = list.getIterator();
        iter.next();
        System.out.println(iter.deleteCurrent());
        list.display();
        iter.reset();
        iter.insertAfter("7");
        list.display();
        iter.insertBefore("8");
        list.display();
        iter.showCurrent();
        System.out.println("______________________");

        // 2. Очередь с двусвязным списком
        QueueList l = new QueueList();
        l.insert("1");
        l.insert("2");
        l.display();
        l.insert("3");
        l.insert("4");
        l.insert("6");
        l.insert("5");
        l.delete();
        l.insert("7");
        l.display();
        System.out.println(l.isInList("0"));
        System.out.println(l.peek());

    }
}
