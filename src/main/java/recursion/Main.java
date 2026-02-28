package recursion;

public class Main {
    public static void main(String[] args) {


        /*
        Recursion: en basitiyle fonksiyonun kendi kendini çağırması denebilir.
        when a thing is defined in terms of itself.
        appyle the results of a procedure, to a procedure.
        a recursive method calls istself. can be a substitute for iteration.
        divide a problem into sub-problems of the same type as the original.


        Avantajları
        1. easier to read/write -> ama bu yüzden aslında çok memory kaplıyor
        2. easier to debug.

        dezavantajları
        1. sometimes slower
        2. uses more memory.
         */


        System.out.println(factorial(7));
        System.out.println(powerexponent(2,8));
        System.out.println(fibonacci(7));
        fibonacci(7);



    }

    private static int fibonacci(int n) {
        if (n<=1 ) return n;
        return fibonacci(n-1)+ fibonacci(n-2);


    }

    private static int powerexponent(int base, int exponent) {

        if (exponent <1) return 1;
        return base * powerexponent(base, exponent-1);

    }

    private static int factorial(int num) {

        if(num<1) return 1;
        return num* factorial(num-1);
    }


}

        /*
        MÜLAKAT NOTLARI
        1. iterative mi yoksa recursion mı daha hızlıdır?
        cevap: genellikle iterative daha hızlıdır. çünkü her recursive çağrı bellekte yeni bir
        stack frame açar; bu da hem zaman hem de hafıze harcar. hatta çok derin recursionlar
        StackOverFlowError verir.

        2. hangi durumlarda recurison tercih edilmelidir?
        cevap: veri yapısı kendiliğinden recursive ise recursion kullanmak kod karmaşıklığını azaltır.

        3 tail recursion nedir?
        cevap: recursive çağrının foksiyonun içindeki en son işlem olmasıdır.
         */
