package lab2;
import lab1.ListIndexOutOfBoundsException;
import lab1.ListInterface;
import lab1.ListException;

public class TestListReferenceBased {
    //testing methods
    public static void main(String[] args) {
        ListInterface refList = new ListReferenceBased();
        System.out.println("--Test List Method: isEmpty() --" + refList.isEmpty());
        System.out.println("--Test List Method: size() --" + refList.size());

        //add, get and remove
        refList.add(1, 2);
        System.out.println("--Test List Method: get() -- " + refList.get(1));
        refList.remove(1);
        try{
           System.out.println("--Test List Method: get() -- " + refList.get(1));
        }catch(ListIndexOutOfBoundsException e){
            System.out.println("--Test List Method: get() -- Index out of bounds exception caught");
        }

        //removeAll
        refList.add(1, 2);
        refList.add(2, 3);
        refList.add(3, 4);

        //display list method
        System.out.println("--Test List Method: displayList() -- ");
        refList.displayList();

        refList.removeAll();
        try {
            System.out.println("--Test List Method: removeAll() --" + refList.get(1));
        }catch(ListIndexOutOfBoundsException e){
            System.out.println("-- Test List Method: removeAll() -- Index out of bounds exception caught");
        }



    }
}
