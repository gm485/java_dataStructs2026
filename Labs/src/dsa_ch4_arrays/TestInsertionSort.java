package dsa_ch4_arrays;

public class TestInsertionSort {

    //insertion sort code
    public void insertionSort(char[] data) {

        int n = data.length;
        for (int i = 1; i < n; i++) {
            //value and index
            char curr = data[i];
            int j = i;
            while (j > 0 && data[j-1] > curr){
                data[j] = data[j-1];
                j--;
            }
            data[j] = curr;
        }
    }

    static void main() {

    }
}


