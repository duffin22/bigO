import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matthewtduffin on 30/08/2016.
 */
public class Main {

  public static void main (String[] args) {

    int size = 1000;
    int[] randomInts = new int[size];
    for (int i=0; i<size; i++) {
      randomInts[i] = (int) (Math.random()*1000000);
    }

    long millis = System.currentTimeMillis();
    OnSquared(randomInts);
    String s = "Time taken for O(n^2): "+(System.currentTimeMillis()-millis);
    System.out.println(s);

    long millis2 = System.currentTimeMillis();
    getArraySum(randomInts);
    String s2 = "Time taken for O(n): "+(System.currentTimeMillis()-millis2);
    System.out.println(s2);

    millis = System.currentTimeMillis();
    getFirstElement(randomInts);
    s = "Time taken to get first element O(1): "+(System.currentTimeMillis()-millis);
    System.out.println(s);

    millis = System.currentTimeMillis();
    int[] sortedList = mergeSort(randomInts);
    s = "Time taken to merge sort O(n log n): "+(System.currentTimeMillis()-millis);
    System.out.println(s);

    millis = System.currentTimeMillis();
    binarySearch(500000,randomInts);
    s = "Time taken to binary search O(log n): "+(System.currentTimeMillis()-millis);
    System.out.println(s);


  }

  //MergeSort is O(n log n)
  public static int[] mergeSort(int[] array) {
    if (array.length < 2) {
      return array;
    }

    int size2 = array.length / 2;
    int size1 = array.length - size2;

    int[] firstArray = new int[size1];
    int[] secondArray = new int[size2];

    for (int i = 0; i < array.length; i++) {
      if (i < size1) {
        firstArray[i] = array[i];
      } else {
        secondArray[i - size1] = array[i];
      }
    }

    int[] firstList = mergeSort(firstArray);
    int[] secondList = mergeSort(secondArray);

    int[] returnStuff = merge(firstList,secondList);
    return returnStuff;

  }

    public static int[] merge(int[] a, int[] b) {
    int[] c = new int[a.length + b.length];
    int count = 0;

    while (a.length > 0 || b.length > 0) {
      if (a.length == 0) {
        c[count] = b[0];
        int[] newB = new int[b.length - 1];
        for (int i = 0; i < b.length - 1; i++) {
          newB[i] = b[i + 1];
        }
        b = newB;
      } else if (b.length == 0) {
        c[count] = a[0];
        int[] newA = new int[a.length - 1];
        for (int i = 0; i < a.length - 1; i++) {
          newA[i] = a[i + 1];
        }
        a = newA;
      } else {
        if (a[0] < b[0]) {
          c[count] = a[0];
          int[] newA = new int[a.length - 1];
          for (int i = 0; i < a.length - 1; i++) {
            newA[i] = a[i + 1];
          }
          a = newA;
        } else {
          c[count] = b[0];
          int[] newB = new int[b.length - 1];
          for (int i = 0; i < b.length - 1; i++) {
            newB[i] = b[i + 1];
          }
          b = newB;
        }
      }
      count++;
    }

    return c;

  }

  //Binary Search is O(log n)
  public static int binarySearch(int index, int[] array){
    int topIndex = array.length - 1;
    int bottomIndex = 0;
    while (topIndex >= bottomIndex) {
      int guess = bottomIndex + ((topIndex - bottomIndex) / 2);
      if (array[guess] > index) {
        topIndex = guess - 1;
      } else if (array[guess] < index) {
        bottomIndex = guess + 1;
      } else {
        return guess;
      }
    }
    return -1;
  }

  //Finding one element is O(1)
  public static int getFirstElement(int[] array) {
    return 3;
  }

  //O(n)
  public static int getArraySum(int[] array) {
    int count=0;
    for (int i =0; i < array.length; i++) {
      count+=1;
    }
    return count;
  }

  //O(n^2)
  public static int OnSquared(int[] array) {
    int count = 0;

    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        count += 1;
      }
    }
    return count;
  }

  public static void printIntArray(int[] array) {
    System.out.print("{");
    for (int i = 0; i < array.length; i++) {
      if (i == array.length - 1) {
        String s = ""+array[i];
        System.out.print(s);
      } else {
        String s = ""+array[i];
        System.out.print(s + ",");
      }
    }
    System.out.println("}");
  }
}
