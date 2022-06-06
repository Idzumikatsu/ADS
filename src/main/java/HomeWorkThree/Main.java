package HomeWorkThree;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //1. Тест-кейсы класса дек.
//        Dequeue d = new Dequeue(12);
//        d.insertLeft(3);
//        d.insertLeft(2);
//        d.insertLeft(5);
//        d.display();
//        d.insertRight(3);
//        d.insertRight(7);
//        d.display();
//        d.insertLeft(4);
//        d.display();
//        d.insertRight(8);
//        d.display();
//        d.popLeft();
//        d.display();
//        d.popRight();
//        d.display();
//        System.out.println(d.peekHead());
//        System.out.println(d.peekTail());

        //2. Тест-кейсы класса приорити-кью
//        PriorityQueue pq = new PriorityQueue(15);
//        pq.insert(4);
//        pq.display();
//        pq.insert(5);
//        pq.display();
//        pq.insert(2);
//        pq.insert(9);
//        pq.display();
//        System.out.println(pq.peek());
//        pq.remove();
//        pq.display();

        // 3. Тест-кейс для брэкет-чекера
        Scanner sc = new Scanner(System.in);
        BracketChecker bch = new BracketChecker(sc.nextLine()); // {{{{}})}
        bch.check();
    }
}
