package HomeWorkFour;

public class QueueList {
    private LinkedList list;

    public QueueList() {
        this.list = new LinkedList();
    }

    public boolean isEmpty(){
       return list.isEmpty();
    }

    public void display(){
        list.display();
    }

    public boolean isInList(String obj){
        return list.isInList(obj);
    }

    public void insert(String obj){
        list.insert(obj);
    }

    public String delete(){
        return list.delete();
    }

    public String peek(){
        return list.getFirst();
    }
}
