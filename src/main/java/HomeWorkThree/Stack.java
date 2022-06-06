package HomeWorkThree;

public class Stack {
        private int maxSize;
        private char[] stack;
        private int head;

        public Stack(int size) {
            this.maxSize = size;
            this.stack = new char[this.maxSize];
            this.head = -1;
        }

        public boolean isEmpty() { return this.head == -1; }
        public boolean isFull() { return this.head == this.maxSize - 1; }

        public void push(char i) {
            if (isFull()) {
                this.maxSize *= 2;
                char[] newStack = new char[this.maxSize];
                System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
                this.stack = newStack;
            }
            this.stack[++this.head] = i;
        }

        public char pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty"); //ret -1
            return this.stack[this.head--];
        }

        public char peek() {
            return this.stack[this.head];
        }
}
