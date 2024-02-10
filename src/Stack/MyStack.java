package Stack;

import java.util.EmptyStackException;

public class MyStack {

    private boolean isEmpty;
    private  String [] stackOfStrings;
    private int numberOfElements;

    private int capacity;


    public MyStack(int capacity){
        isEmpty = true;
        numberOfElements = 0;
        stackOfStrings = new String[capacity];

    }
    public boolean stackIsEmpty() {
        if (numberOfElements == 0) {
            return isEmpty = true;
        }
        else {
            return isEmpty = false;
        }
    }


    public String pop() {
        if (numberOfElements == 0) {
            throw new EmptyStackException();
        }
        else {
            return stackOfStrings[--numberOfElements];

        }
    }

    public void push(String adidas) {
        numberOfElements++;
    }

    public int size() {
        return numberOfElements;
    }
}
