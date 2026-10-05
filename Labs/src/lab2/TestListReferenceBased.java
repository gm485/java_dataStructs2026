package lab2;
import lab1.ListIndexOutOfBoundsException;
import lab1.ListInterface;
import lab1.ListException;

public class TestListReferenceBased {
    //testing methods
    public static void main(String[] args) {
        ListInterface refList = new ListReferenceBased();
        System.out.println("-- Test List Method: isEmpty() -- output: " + refList.isEmpty());//true
        System.out.println("-- Test List Method: size() -- output: " + refList.size()); //0

    }
}
