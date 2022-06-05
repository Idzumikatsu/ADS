package HomeWorkThree;

public class PriorityQueue {
    private int maxSize;
    private int[] queue;
    private int head;
    private int tail;
    private int items;

    public PriorityQueue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public int peek() throws ArrayIndexOutOfBoundsException{
        if (!isEmpty()) {
            return queue[this.head];
        } else {
            throw new RuntimeException("Очередь пуста");
        }
    }

    public void display() {
        for (int i = 0; i < this.items; i++) {
            System.out.print(this.queue[i] + " ");
        }
        System.out.print("\n");
    }

    private void expansion() {
        int[] old = this.queue;
        this.queue = new int[this.maxSize * 2];
        System.arraycopy(old, 0, this.queue, 0, this.size());
    }

    public void insert(int num) {
        if (isFull()) {
            expansion();
        }
        int i;
        if (isEmpty()) {
            this.queue[items++] = num;
        } else {
            for (i = items-1; i >= 0; i--) {
                if (num > this.queue[i]){
                    this.queue[i+1] = this.queue[i];
                } else {
                    break;
                }
            }
            this.queue[i+1] = num;
            items++;
        }
    }

    public int remove() throws ArrayIndexOutOfBoundsException {
        if(!isEmpty()){
            return this.queue[--items];
        } else {
            throw new RuntimeException("Очередь пуста");
        }
    }
}
