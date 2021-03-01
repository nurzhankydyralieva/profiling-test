package kg.megacom;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Integer> linkedTest = new LinkedList<>();
        List<Integer> arrayTest = new ArrayList<>();
        long startTestLinked = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            linkedTest.add(new Integer(i));
        }
        System.out.println("______________Checking time");
        System.out.println("Running time value of numbers 5000000  for a LinkedList: " + (System.currentTimeMillis() - startTestLinked) + " ms.");
        long startTestArray = System.currentTimeMillis();
        for (int i = 0; i < 5000000; i++) {
            arrayTest.add(new Integer(i));
        }
        System.out.println("Running time value of numbers 5000000  for a ArrayList: " + (System.currentTimeMillis() - startTestArray) + " ms.");
        System.out.println("______________Checking time for insert");
        long msDelayArray = getTimeMsOfInsertArray(new ArrayList());
        long msDelayLinked = getTimeMsOfInsertLinked(new LinkedList());
        System.out.println("Result inserted 100000 for ArrayList: " + msDelayArray + " ms.");
        System.out.println("Result inserted 100000 for LinkedList: " + msDelayLinked + " ms.");
        System.out.println("______________Checking time for max value");
        long linkedListMax = linkedListMax();
        long arrayListMax = arrayListMax();
        System.out.println("Inserting maximum value of 500 000 for a LinkedList: " + linkedListMax + " ms.");
        System.out.println("Inserting maximum value of 500 000 for a ArrayList: " + arrayListMax + " ms.");
        System.out.println("______________Checking time for min value");
        long linkedListMin = minLinkedList();
        long arrayListMin = minArrayList();
        System.out.println("Inserting minimum value of 500 000 for a LinkedList: " + linkedListMin + " ms.");
        System.out.println("Inserting minimum value of 500 000 for a ArrayList: " + arrayListMin + " ms.");
        System.out.println("______________Checking time for shuffle and fill");
        long linkedShuffle = linkedListShuffle();
        long arrayShuffle = arrayListShuffle();
        System.out.println("Shuffled integers 2000000 and filled with integers 1000000000 LinkedList: " + linkedShuffle + " ms.");
        System.out.println("Shuffled integers 2000000 and filled with integers 1000000000 ArrayList: " + arrayShuffle + " ms.");
        System.out.println("______________Checking time for inserted byte value");
        long linkedListBytes = linkedListBytes();
        long arrayListBytes = arrayListBytes();
        System.out.println("Inserting in the middle byte value of 500,000 for a LinkedList: " + linkedListBytes + " ms.");
        System.out.println("Inserting in the middle byte value of 500,000 for a ArrayList: " + arrayListBytes + " ms.");

    }

    public static long getTimeMsOfInsertArray(ArrayList arrayList) {
        Date currentTime = new Date();
        insert100000(arrayList);
        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime();
        return msDelay;
    }

    public static void insert100000(ArrayList arrayList) {
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, new Object());
        }
    }

    public static long getTimeMsOfInsertLinked(LinkedList list) {
        Date currentTime = new Date();
        insert100000(list);
        Date newTime = new Date();
        long msDelay = newTime.getTime() - currentTime.getTime();
        return msDelay;
    }

    public static void insert100000(LinkedList list) {
        for (int i = 0; i < 100000; i++) {
            list.add(0, new Object());
        }
    }

    public static long linkedListMax() {
        List<Integer> linkedTest = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            linkedTest.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            linkedTest.add(500000, Integer.MAX_VALUE);
        }
        return System.currentTimeMillis() - start;
    }

    public static long arrayListMax() {
        List<Integer> arrayTest = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            arrayTest.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            arrayTest.add(500000, Integer.MAX_VALUE);
        }
        return System.currentTimeMillis() - start;
    }

    public static long minLinkedList() {
        List<Integer> linkedTest = new LinkedList<>();
        for (int i = 0; i < 10000000; i++) {
            linkedTest.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            linkedTest.add(500000, Integer.MIN_VALUE);
        }
        return System.currentTimeMillis() - start;
    }

    public static long minArrayList() {
        List<Integer> arrayTest = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            arrayTest.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            arrayTest.add(500000, Integer.MIN_VALUE);
        }
        return System.currentTimeMillis() - start;
    }

    public static long arrayListShuffle() {
        List<Integer> arrayTest = new ArrayList<>();
        for (int i = 0; i < 2000000; i++) {
            arrayTest.add(i);
        }
        Collections.fill(arrayTest, Integer.MAX_VALUE);
        long start = System.currentTimeMillis();
        Collections.shuffle(arrayTest);
        Collections.fill(arrayTest, 1000000000);
        return System.currentTimeMillis() - start;
    }

    public static long linkedListShuffle() {
        List<Integer> linkedTest = new LinkedList<>();
        for (int i = 0; i < 2000000; i++) {
            linkedTest.add(i);
        }
        Collections.fill(linkedTest, Integer.MAX_VALUE);
        long start = System.currentTimeMillis();
        Collections.shuffle(linkedTest);
        Collections.fill(linkedTest, 1000000000);
        return System.currentTimeMillis() - start;
    }

    public static long linkedListBytes() {
        List<Integer> linkedTest = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            linkedTest.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            linkedTest.add(500000, Integer.BYTES);
        }
        return System.currentTimeMillis() - start;
    }

    public static long arrayListBytes() {
        List<Integer> arrayTest = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            arrayTest.add(i);
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            arrayTest.add(500000, Integer.BYTES);
        }
        return System.currentTimeMillis() - start;
    }
}
