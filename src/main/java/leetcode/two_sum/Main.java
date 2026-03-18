package leetcode.two_sum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15, 18, 20, 25, 30, 40}; // Biraz daha uzun bir dizi
        int target = 65;

        // --- Brute Force Ölçümü ---
        long startBrute = System.nanoTime();
        long memStartBrute = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int[] resultBrute = solution.twoSum(nums, target);

        long endBrute = System.nanoTime();
        long memEndBrute = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("--- Brute Force Sonuçları ---");
        System.out.println("Sonuç: " + Arrays.toString(resultBrute));
        System.out.println("Süre (ns): " + (endBrute - startBrute));
        System.out.println("Tahmini RAM Artışı (bytes): " + (memEndBrute - memStartBrute));
        System.out.println("Zaman Karmaşıklığı: O(n^2)");
        System.out.println("Alan Karmaşıklığı: O(1)");

        System.out.println("\n----------------------------\n");

        // --- HashMap (Optimized) Ölçümü ---
        long startOpt = System.nanoTime();
        long memStartOpt = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int[] resultOpt = solution.twoSumWithHashMap(nums, target);

        long endOpt = System.nanoTime();
        long memEndOpt = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        System.out.println("--- HashMap Optimized Sonuçları ---");
        System.out.println("Sonuç: " + Arrays.toString(resultOpt));
        System.out.println("Süre (ns): " + (endOpt - startOpt));
        System.out.println("Tahmini RAM Artışı (bytes): " + (memEndOpt - memStartOpt));
        System.out.println("Zaman Karmaşıklığı: O(n)");
        System.out.println("Alan Karmaşıklığı: O(n)");
    }
}
