import java.util.*;

public class Runner {

    public static void main(String[] args) {

        MyDeque listA = new MyDeque();
        MyDeque listB = new MyDeque();

        for (int i = 1; i < 25; i+=3) {
            listA.addEven(i);
            listA.addOdd(i);
        }
        for (int i = 24; i > 0; i-=3) {
            listB.addEven(i);
            listB.addOdd(i);
        }

        System.out.println("Expected: [22, 16, 10, 4, 1, 7, 13, 19]");
        System.out.println("Actual:   " + listA + "head: " + listA.head +" tail: " + listA.tail + "head.prev: " + listA.head.prev + "head.next: " + listA.head.next + "tail.prev: " + listA.tail.prev + "tail.next: " + listA.tail.next); 
        System.out.println();
        System.out.println("Expected: [6, 12, 18, 24, 21, 15, 9, 3]");
        System.out.println("Actual:   " + listB + "head: " + listB.head + " tail: " +listB.tail); 

        System.out.println(listA.remove(4));
        System.out.println(listA);
        System.out.println("Actual:   " + listA + "head: " + listA.head +" tail: " + listA.tail + "head.prev: " + listA.head.prev + "head.next: " + listA.head.next + "tail.prev: " + listA.tail.prev + "tail.next: " + listA.tail.next); 
        System.out.println();

        MyDeque listC = new MyDeque();

        listC.addEven(4);
        listC.addEven(6);
        listC.addOdd(1);
        System.out.println(listC + "head: " + listC.head + " tail: " + listC.tail);
        System.out.println(listC.remove(1));
        System.out.println(listC + "head: " + listC.head + " tail: " + listC.tail);

		System.out.println("==============================");
		System.out.println(listA);
		System.out.println(listB);
		listA.merge(listB);

		System.out.println(listA + " head: " + listA.head + " tail: " + listA.tail);
        System.out.println(listA.remove(22));
		System.out.println(listA.remove(3));
		System.out.println(listA.remove(9));
		System.out.println(listA.remove(21));
		System.out.println(listA + " head: " + listA.head + " tail: " + listA.tail);


		MyDeque listD = new MyDeque();

		listD.addEven(8);
		System.out.println(listD + "head: " + listD.head + " tail: " + listD.tail);

		listD.addEven(6);
		System.out.println(listD + "head: " + listD.head + " tail: " + listD.tail);

		listD.addOdd(7);
		System.out.println(listD + "head: " + listD.head + " tail: " + listD.tail);

		listD.removeLast();
		System.out.println(listD + "head: " + listD.head + " tail: " + listD.tail);

		listD.removeLast();
		System.out.println(listD + "head: " + listD.head + " tail: " + listD.tail);

		listD.removeLast();
		System.out.println(listD + "head: " + listD.head + " tail: " + listD.tail);

    }
}
