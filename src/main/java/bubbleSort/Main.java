package bubbleSort;

public class Main {
    public static void main(String[] args) {

        /*
        Çalışma prensibi komşu elemanların karşılaştırılmasına dayanır:

            1.Dizinin başından başla.
            2.Birinci ve ikinci elemanı karşılaştır. Eğer birinci büyükse, yerlerini değiştir (Swap).
            3.İkinci ve üçüncüye bak... Bu şekilde dizinin sonuna kadar git.
            4.Bu tur bittiğinde, dizinin en büyük elemanı garantili olarak en sağa (sona) yerleşmiş olur.
            5.Dizi tamamen sıralanana kadar bu işlemleri tekrarla.



            BubbleSort inanılmaz kötü bir sıralama algoritması. neredeyse hiç kullanılmıyor.
            O kadaar kötü ki java ciddiye alıp built-in classını falan da oluşturmamış.

            Complexity -> O(n^2) -> quadratic time berbat yani.

            pair of adjacent elements are compared, and the elements swapped if they are not in order.

            small data -> anca kafana silah falan dayamaları gerekiyor kullanmak istemen için
            large dataset -> kullanma başka birsürü algoritma var


        */
        int[] array = {9,1,3,6,2,8,5,4,7};
        bubbleSort(array);

        for(int i=0;i<array.length;i++){
            System.out.print(i);
        }


        }

    public static void bubbleSort(int array[]){
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length-1;j++){
                if(array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;

                }
            }
        }
    }
    }

