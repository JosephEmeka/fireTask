package MyArrayList;

public class MyArrayList {

    private static boolean isEmpty;

        public MyArrayList(){
            this.isEmpty = true;
        }
    public static boolean isEmpty(MyArrayList strings) {
        return isEmpty;
    }

    public void add(String newString) {
        isEmpty = false;

    }
}
