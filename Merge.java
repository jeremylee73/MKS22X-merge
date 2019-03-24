import java.util.*;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[] data){
    int[] temp = new int[data.length];
    mergesort(data, temp, 0, data.length-1);
  }

  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static void mergeH(int[] data, int[]temp, int lo, int mid, int hi){
    int l1 = lo;
    int l2 = mid+1;
    int count = lo;
    while (l1 <= mid && l2 <= hi){
      if (temp[l1] < temp[l2]){
        data[count] = temp[l1];
        l1++;
      }
      else{
        data[count] = temp[l2];
        l2++;
      }
      count++;
    }
    if (l1 <= mid){
      for(int i=l1; i<=mid; i++){
        data[count] = temp[i];
        count++;
      }
    } else{
        for (int i = l2; i<=hi ; i++){
          data[count] = temp[i];
          count++;
        }
      }
  }

  private static void mergesort(int[] data, int[] temp, int lo, int hi){
    if (hi - lo <= 2){
      insertionSort(data, lo, hi);
      return;
    } else if (hi - lo < 1){
      return;
    }
    int mid = (hi + lo) / 2;
    for(int i=lo; i<=hi; i++) {
      temp[i] = data[i];
    }
    mergesort(temp, data, lo, mid);
    mergesort(temp, data, mid+1, hi);
    mergeH(data, temp, lo, mid, hi);
  }

  private static int findIndex(int[] data, int val){
    for (int i=0; i<data.length; i++){
      if (data[i] == val){
        return i;
      }
    }
    return -1;
  }

  public static void printArray(int[] arr){
    for (int i=0; i<arr.length-1; i++){
      System.out.print(arr[i] +",");
    }
    System.out.println();
  }

  public static void insertionSort(int[] data, int lo, int hi){
    int i;
    for(int j=lo; j<hi+1; j++) {
      int key = data[j];
      for(i = j; i > lo && key < data[i -1]; i--) {
        data[i] = data[i - 1];
      }
      data[i] = key;
    }
  }

  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Merge.mergesort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
