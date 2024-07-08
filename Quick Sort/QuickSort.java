import java.util.Arrays;

public class QuickSort {
   public static void main(String[] args) {
       int[] popularityOfSongs = {17, 14, 15, 28, 6, 8, 6, 1, 3, 18};
       System.out.println("Unsorted Array: " + Arrays.toString(popularityOfSongs));
       quickSort(popularityOfSongs, 0, popularityOfSongs.length - 1);
       System.out.println("  Sorted Array: " + Arrays.toString(popularityOfSongs));
   }

   public static void quickSort(int[] arr, int low, int high) {
       if (low < high) {
           int pi = partition(arr, low, high);

           quickSort(arr, low, pi - 1);
           quickSort(arr, pi + 1, high);
       }
   }

   private static int partition(int[] arr, int low, int high) {
       int pivot = arr[high];
       int i = (low - 1);
       for (int j = low; j < high; j++) {
           if (arr[j] < pivot) {
               i++;

               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
           }
       }

       int temp = arr[i + 1];
       arr[i + 1] = arr[high];
       arr[high] = temp;

       return i + 1;
   }
}
