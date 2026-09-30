package lab1;

public class TestListArrayBased {
    public static void main(String[] args) {
        System.out.println("--TEST CLASS");

        ListInterface aList = new ListArrayBased();

        System.out.println("--Test Method: isEmpty() --" + aList.isEmpty());//true
        System.out.println("--Test Method: size() --" + aList.size());//0

        //add items to list
        System.out.println("--Test Method: add()");
        aList.add(1, 1);
        aList.add(2, 2);
        aList.add(3, 3);
        aList.add(4, 4);
        aList.add(5, 5);
        aList.add(6, 6);
        System.out.println("--Test Method: displayList()");
        displayList(aList);

        //is list empty
        System.out.println("--Test Method: isEmpty() after add() --" + aList.isEmpty());//false
        System.out.println("--Test Method: size() after add() --" + aList.size());//4

        //get method
        System.out.println("-Test Method: get() --");
        System.out.println("item at index 1: " + aList.get(1));
        System.out.println("item at index 2: " + aList.get(2));
        System.out.println("item at index 3: " + aList.get(3));

        //remove method
        System.out.println("--Test Method: remove() --");
        aList.remove(1);
        System.out.println("item now at index 1: " + aList.get(1));
        aList.remove(2);
        System.out.println("item now at index 2: " + aList.get(2));
        aList.remove(3);
        System.out.println("item now at index 3: " + aList.get(3));

        System.out.println("--Test Method: removeAll() --");
        aList.removeAll();
        System.out.println("Is List empty after removeAll() --" + aList.isEmpty());
        System.out.println("size of list after removeAll() --" + aList.size());

        //error handling
        System.out.println("\n--Error Handling--");
        try{
            System.out.println("invalid index 5");
            aList.get(5);
        }catch(ListIndexOutOfBoundsException e){
            System.out.println("List Index exception caught\n" + "^"+e.getMessage());

        }
        try{
            System.out.println("negative index");
            aList.get(-1);
        }catch(IndexOutOfBoundsException e){
            System.out.println("List Index exception caught\n" + "^"+e.getMessage());
        }

    }
    public static void displayList(ListInterface list) {
        if(list.isEmpty()){
            System.out.println("List is empty");
            return;
        }
        System.out.println("--Test Method: displayList() --\n Size " + list.size());

        for (int i=1; i<list.size();i++){
            System.out.print(list.get(i));
            if(i < list.size()-1){
                System.out.print(", ");
            }
        }
    }
}
