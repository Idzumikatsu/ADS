package HomeWorkTwo;

import java.util.Arrays;

public class MyArray {
    private int[] arr;
    private int capacity;

    //new int[5];
    public MyArray(int size) {
        this.capacity = 0;
        this.arr = new int[size];
    }

    // = {1,2,3,4,5};
    public MyArray(int[] init) {
        this.capacity = init.length;
        this.arr = init;
    }

    void display() {
        for (int i = 0; i < this.capacity; ++i) {
            System.out.print(this.arr[i] + " ");
        }
        System.out.println();
    }

    public int get(int idx) {
        return arr[idx];
    }

    public void set(int value, int idx) {
        arr[idx] = value;
    }

    boolean delete(int value) {
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                --capacity;
                return true;
            }
        }
        return false;
    }

    void append(int value) {
        if (this.capacity == this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        this.arr[this.capacity++] = value;
    }

    public boolean isInArray(int value) { // O(n)
        for (int i = 0; i < this.capacity; i++)
            if (this.arr[i] == value)
                return true;
        return false;
    }

    //O(log(N))
    public boolean hasValue(int value) {
        int low = 0;
        int high = this.capacity - 1;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (value == this.arr[mid]) {
                return true;
            } else {
                if (value < this.arr[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }

    private void swap(int a, int b) {
        int tmp = this.arr[a];
        this.arr[a] = this.arr[b];
        this.arr[b] = tmp;
    }

    public void sortBubble() {
        int counter = 0;
        for (int iter = 0; iter < capacity; iter++) {
            counter++;
            for (int idx = 0; idx < capacity - 1; idx++) {
                counter++;
                if (this.arr[idx] > this.arr[idx + 1]) {
                    swap(idx, idx + 1);
                    counter += 3;
                }
            }
        }
        System.out.println(counter);
    }

    public void sortSelect() {
        for (int idx = 0; idx < capacity; idx++) {
            int curr = idx;
            for (int srch = idx + 1; srch < capacity; srch++)
                if (this.arr[srch] < this.arr[curr])
                    curr = srch;
            if (curr != idx)
                swap(idx, curr);
        }
    }

    public void sortInsert() {
        for (int curr = 1; curr < capacity; curr++) {
            int temp = this.arr[curr];
            int move = curr;
            while (move > 0 && this.arr[move - 1] >= temp) {
                this.arr[move] = this.arr[move - 1];
                move--;
            }
            this.arr[move] = temp;
        }
    }

    //____________________________________________________________________________________________

    private int counter(int value) {
        int counter = 0;
        for (int i = 0; i < this.capacity; i++) {
            if (this.arr[i] == value) {
                counter++;
            }
        }
        return counter;
    }

    // 1.
    public boolean deleteAll(int value) {
        int count = counter(value);
        while (count != 0) {
            for (int i = 0; i < this.capacity; i++) {
                if (this.arr[i] == value) {
                    System.arraycopy(this.arr, i + 1, this.arr, i, this.capacity - i - 1);
                    --capacity;
                    count--;
                    if (count == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //2.
    public void deleteAll() {
        this.capacity = 0;
    }

    //3.
    public void insert(int idx, int value) {
        this.capacity++;
        if (idx >= this.capacity) {
            idx = this.capacity - 1;
        }
        if (this.capacity + idx + 1 > this.arr.length) {
            int[] old = this.arr;
            this.arr = new int[old.length * 2];
            System.arraycopy(old, 0, arr, 0, old.length);
        }
        System.arraycopy(this.arr, idx, this.arr, idx + 1, this.capacity);
        this.arr[idx] = value;
    }

    //4.
    //проверяем сразу два элемента слева и справа
    //за один проход внешнего цикла и двигаем,
    //что позволяет нам гарантированно отсортировать
    //весь массив за вдвое меньшее количество проходов
    //по внешнему циклу, так как у нас *всплывают* сразу два пузырька
    public void sortBubbleImprove() {
        int counter = 0;
        for (int iter = 0; iter < capacity / 2; iter++) {
            counter++;
            for (int idx = 1; idx < capacity - 1; idx++) {
                counter++;
                if (this.arr[idx] > this.arr[idx + 1]) {
                    swap(idx, idx + 1);
                    counter += 3;
                }
                if (this.arr[idx] < this.arr[idx - 1]) {
                    swap(idx, idx - 1);
                    counter += 3;
                }
            }
        }
        System.out.println(counter);
    }

    // 5.
    public void sortCalculate() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int element : this.arr) {
            if (element < min) {
                min = element;
            }
            if (element > max) {
                max = element;
            }
        }
        int[] buckets = new int[max - min + 1];
        for (int element : this.arr){
            buckets[element - min]++;
        }
        int arrayIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = buckets[i]; j > 0; j--) {
                this.arr[arrayIndex++] = i + min;
            }
        }
    }
}
