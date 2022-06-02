package HomeWorkTwo;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(new int[]{1,5,3,4,5,5,7,8,9});
        arr.display();
        arr.deleteAll(5);                                   // 1.
        arr.display();
        arr.deleteAll();                                          // 2.
        arr.display();
        arr.insert(5,6);                                // 3. тест вставки
        arr.insert(1,2);
        arr.insert(1,7);
        arr.display();
        for (int i = 0; i < 15; i++) {                             // 3. тест расширения массива
            arr.insert(1,8);
        }
        arr.display();

        MyArray arr1 = new MyArray(new int[]{5,4,3,2,1,2,3,4,5,4,23,4,5,6,8,2,4,5,2,3,4,5,6,8});
        MyArray arr2 = new MyArray(new int[]{5,4,3,2,1,2,3,4,5,4,23,4,5,6,8,2,4,5,2,3,4,5,6,8});
        arr1.sortBubble();
        arr1.display();
        arr2.sortBubbleImprove();                                  //4. улучшение пузырька
        arr2.display();                                            //экономия ~300 действий из 800,
                                                                   // что почти половина

                                                                    //5. сортировка подсчетом
        MyArray arr3 = new MyArray(new int[]{5,4,4,5,2,3,4,1});
        arr3.display();
        arr3.sortCalculate();
        arr3.display();

    }


}
