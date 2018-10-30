package testsort;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class SortDemo {

    private static int length;

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter array length: ");
        length = scanner.nextInt();

        int array[] = new int[length];
        getRandomElements(array);
        System.out.println("The initial array: ");
        printArray(array);

        int array2[] = Arrays.copyOf(array, length);
        int array3[] = Arrays.copyOf(array, length);

        long tBubble = System.nanoTime();
        bubbleSort(array);
        long t2Bubble = System.nanoTime();

        System.out.println();
        System.out.println("The bubble sorted array: ");
        printArray(array);

        long tSelection = System.nanoTime();
        selectionSort(array2);
        long t2Selection = System.nanoTime();

        System.out.println();
        System.out.println("The selection sorted array: ");
        printArray(array2);

        long tInsertion = System.nanoTime();
        insertionSort(array3);
        long t2Insertion = System.nanoTime();

        System.out.println();
        System.out.println("The insertion sorted array: ");
        printArray(array3);

        // вывод результатов

        System.out.println();
        System.out.println("Bubble sort sorted array in: " + String.format("%,12d", t2Bubble - tBubble) + " ns");
        System.out.println("Selection sort sorted array in: " + String.format("%,12d", t2Selection - tSelection) + " ns");
        System.out.println("Insertion sort sorted array in: " + String.format("%,12d", t2Insertion - tInsertion) + " ns");
    }


    private static void getRandomElements(int[] array){
        Random random = new Random();

        for (int i = 0; i < array.length; i++){
            array[i] = random.nextInt(1000);
        }
    }

    private static void printArray(int[] array){
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }

    private static void insertionSort(int[] array){
        int in, out, temp;

        /* out - разделительный маркер */
        for (out = 1; out < array.length; out++){
            temp = array[out];
            in = out;

            while (in > 0 && array[in-1] >= temp){
                array[in] = array[in-1];
                in = in - 1;
            }

            array[in] = temp;
        }
    }

    private static void selectionSort(int[] array){
        int min, temp;

        for (int i = 0; i < array.length - 1; i++){
            min = i;

            for (int j = i + 1; j < array.length; j++){

                if (array[j] < array[min]){
                    min = j;
                }
            }

            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }

    private static void bubbleSort(int array[]){
        int out, in, temp;

        for (out = array.length-1; out > 1; out--){

            for (in = 0; in < out; in++){

                if (array[in] > array[in+1]){
                    temp = array[in];
                    array[in] = array[in+1];
                    array[in+1] = temp;
                }
            }
        }
    }

}
