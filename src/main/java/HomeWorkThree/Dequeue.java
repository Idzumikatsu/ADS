package HomeWorkThree;

public class Dequeue {
    private int maxSize;
    private int[] dequeue;
    private int head;
    private int tail;
    private int items;

    public Dequeue(int maxSize) {
        this.maxSize = maxSize;
        this.dequeue = new int[maxSize];
        this.head = -1;
        this.items = 0;
    }

    public boolean isEmpty(){
        return (items==0);
    }
    public boolean isFull(){
        return (items==maxSize);
    }
    public int size(){
        return items;
    }

    public void display(){
        for (int i = 0; i < this.items; i++) {
            System.out.print(this.dequeue[i] + " ");
        }
        System.out.print("\n");
    }

    private void expansion(){
        int[] old = this.dequeue;
        this.dequeue = new int[this.maxSize * 2];
        System.arraycopy(old, 0, this.dequeue, 0, this.size());
    }

    private void moveTail(){
        System.arraycopy(this.dequeue,0,this.dequeue,1,this.items+1);
    }

    private void moveHead(){
        System.arraycopy(this.dequeue,1,this.dequeue,0,this.items);
    }

    public void insertLeft(int num){
        if (isFull()){
            expansion();
        }
        if (isEmpty()){
            dequeue[++this.head] = num;
        } else {
            moveTail();
            dequeue[this.head] = num;
        }
        ++this.items;

    }

    public void insertRight(int num){
        if (isFull()){
            expansion();
        }
        dequeue[this.items++] = num;
    }

    public int popLeft() throws ArrayIndexOutOfBoundsException{
        if (!isEmpty()){
            int temp = dequeue[this.head];
            moveHead();
            --this.items;
            return temp;
        } else {
            throw new RuntimeException("Дека пустая");
        }
    }

    public int popRight() throws ArrayIndexOutOfBoundsException{
        if(!isEmpty()){
            int temp = dequeue[this.items-1];
            --this.items;
            return temp;
        } else {
            throw new RuntimeException("Дека пустая");
        }

    }

    public int peekHead() throws ArrayIndexOutOfBoundsException{
        if(!isEmpty()){
            return dequeue[this.head];
        } else {
            throw new RuntimeException("Дека пустая");
        }
    }

    public int peekTail() throws ArrayIndexOutOfBoundsException{
        if(!isEmpty()){
            return dequeue[this.items-1];
        } else {
            throw new RuntimeException("Дека пустая");
        }
    }
}
