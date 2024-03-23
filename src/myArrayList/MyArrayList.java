package myArrayList;


public class MyArrayList {

    private static boolean isEmpty;
    private String [] myStringArrayList;

    private int numberOfElements;

    private int capacity;

        public MyArrayList(int capacity){
            myStringArrayList = new String[capacity];
        }
    public  boolean isEmpty() {
            return numberOfElements == 0;
    }

    public boolean add(String newString) {
        if (numberOfElements > myStringArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
            myStringArrayList[numberOfElements] = newString;
            ++numberOfElements;
        return true;
    }

    public String get(int index) {
        if (index < 0 || index >= myStringArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
            return myStringArrayList[index];
    }

    public void add(int index, String newString) {
        if (index >= myStringArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        myStringArrayList[index] = newString;

    }

    public void clear() {
        myStringArrayList = new String[0];
        numberOfElements = 0;
    }

    public int size() {
            return myStringArrayList.length;
    }

    public String remove(int index) {
        if (index < 0 || index >= myStringArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        String removedElement = myStringArrayList[index];
        String[] new_array = new String[myStringArrayList.length - 1];
        int count = 0;
        for (int item = 0; item < myStringArrayList.length; item++) {
            if (item == index) {
                continue;
            }
            new_array[count] = myStringArrayList[item];
            count++;
        }

        myStringArrayList = new_array;

        return removedElement;
    }

    public String set(int index, String replaced_String) {
        if (index < 0 || index >= myStringArrayList.length) {
            throw new IndexOutOfBoundsException();
        }
        return myStringArrayList[index];

    }
}
