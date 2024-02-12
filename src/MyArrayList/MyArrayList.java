package MyArrayList;


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
            return myStringArrayList[index];
    }

    public void add(int index, String newString) {
        if (index > myStringArrayList.length) {
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
}
