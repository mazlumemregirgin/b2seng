package linearSearch;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Arrays.binarySearch;


public class Main {
    public static void main(String[] args) {

        /*
        Linear search -> iterate through a collection one element at a time
        herşeye baştan başlar sona doğru tek tek bakar. o yüzden en best case senaryoda aranan eleman
        en sonda ise big o su aranılan dizinin eleman sayısına (n) eşittir
        complexity -> O(n)



        Disadvantages:
        Slow for large datasets

        Advantages:
        fast for searches of small to medium data sets
        does not need to sorted
        useful for data structures that do not have random access (linkedList)

        javada built-in linear search classı yoktur çünkü zaten linear search basit bir for döngüsü içerir.
        fakat bir ArrayList veya LinkedList kullanıyorsan, Javanın
        içindeki liste fonksiyonları lienare search ile çalışır. .contains("emre") veya .indexOf("emre")
        imort java.util.Arrays.binarySearch
         */
        int[] myArray = {1, 2, 3, 4, 5,6,5,5};

        List<Integer> myIndex= myLinearSearch(myArray, 5);

        System.out.println(myIndex);


    }
// kendi basit binary search kullanan bir fonksiyonumu yazdım.
    public static List<Integer> myLinearSearch(int[] array, int value){
        List<Integer> myArrayList = new ArrayList<>();


        for(int i=0; i<array.length; i++) {
            if (array[i] == value) {
                myArrayList.add(i);
            }
        }
        return myArrayList;
    }
}
