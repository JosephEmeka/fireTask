package stack;

import java.util.EmptyStackException;

public class MyStack {

    private  String [] stackOfStrings;
    private int numberOfElements;

    private int arrayCapacity;


    public MyStack(int arrayCapacity){
        stackOfStrings = new String[arrayCapacity];
    }
    public boolean stackIsEmpty() {
        return numberOfElements == 0;
    }


    public String pop() {
        if (numberOfElements == 0) {
            throw new EmptyStackException();
        }
        return stackOfStrings[--numberOfElements];
    }

    public void push(String ArrayItems) {
        stackOfStrings[numberOfElements] = ArrayItems;
        ++numberOfElements;
    }

    public int size() {
        return numberOfElements;
    }

    public String peek(){
        if (numberOfElements == 0){
            throw new EmptyStackException();
        }
        return stackOfStrings[numberOfElements-1];
    }
}
