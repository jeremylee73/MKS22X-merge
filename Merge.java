import java.util.*;
public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[] data){
    mergesort(data, 0, data.length-1);
  }

  private static void swap(int[] data, int a, int b){
    int temp = data[a];
    data[a] = data[b];
    data[b] = temp;
  }

  private static int[] mergeH(int[] data1, int[] data2){
    int[] ans = new int[data1.length + data2.length];
    int largest1 = 0;
    for (int i=0; i<data1.length; i++){
      if (data1[i] >= largest1){
        largest1 = data1[i];
      }
    }
    int largest2 = 0;
    for (int i=0; i<data2.length; i++){
      if (data2[i] >= largest2){
        largest2 = data2[i];
      }
    }
    int j = 0;
    int count = 0;
    if (largest1 > largest2){
      for (int i=0; i<data1.length; i++){
        if (j<data2.length){
          if (data1[i] < data2[j]){
            ans[count] = data1[i];
          } else  {
            ans[count] = data2[j];
            j++;
            i--;
          }
        } else {
          ans[count] = data1[i];
        }
        count++;
      }
    } else {
      for (int i=0; i<data2.length; i++){
        if (j<data1.length){
          if (data2[i] < data1[j]){
            ans[count] = data2[i];
          } else {
            ans[count] = data1[j];
            j++;
            i--;
          }

        } else {
          ans[count] = data2[i];
        }
        count++;
      }
    }
    return ans;
  }

  private static void mergesort(int[] data, int lo, int hi){
    if (hi - lo == 2){
      swap(data, lo, hi);
      return;
    }
    int mid = (hi + lo + 1) / 2;
    int[] leftSide = new int[mid];
    int j = 0;
    for (int i=lo; i<mid; i++){
      leftSide[j] = data[i];
      j++;
    }
    int[] rightSide = new int[hi - mid + 1];
    j = 0;
    for (int i=mid; i<=hi; i++){
      rightSide[j] = data[i];
      j++;
    }
    mergesort(data, findIndex(data,leftSide[0]), findIndex(data, leftSide[leftSide.length-1]));
    mergesort(data, findIndex(data, rightSide[0]), findIndex(data,rightSide[rightSide.length-1]));
  }

  private static int findIndex(int[] data, int val){
    for (int i=0; i<data.length; i++){
      if (data[i] == val){
        return i;
      }
    }
    return -1;
  }

  private static void printArray(int[] arr){
    for (int i=0; i<arr.length-1; i++){
      System.out.print(arr[i] +",");
    }
    System.out.print(arr[arr.length-1]);
    System.out.println();
  }

  public static void main(String[]args){
    int[] test = {9,8,7,6,5,4,3,2,1};
    int[] help1 = {1,3,5};
    int[] help2 = {2,4,6};
    printArray(mergeH(help1, help2));
    //mergesort(test);
    //printArray(test);
  //   System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
  //   int[]MAX_LIST = {1000000000,500,10};
  //   for(int MAX : MAX_LIST){
  //     for(int size = 31250; size < 2000001; size*=2){
  //       long qtime=0;
  //       long btime=0;
  //       //average of 5 sorts.
  //       for(int trial = 0 ; trial <=5; trial++){
  //         int []data1 = new int[size];
  //         int []data2 = new int[size];
  //         for(int i = 0; i < data1.length; i++){
  //           data1[i] = (int)(Math.random()*MAX);
  //           data2[i] = data1[i];
  //         }
  //         long t1,t2;
  //         t1 = System.currentTimeMillis();
  //         Merge.mergesort(data2);
  //         t2 = System.currentTimeMillis();
  //         qtime += t2 - t1;
  //         t1 = System.currentTimeMillis();
  //         Arrays.sort(data1);
  //         t2 = System.currentTimeMillis();
  //         btime+= t2 - t1;
  //         if(!Arrays.equals(data1,data2)){
  //           System.out.println("FAIL TO SORT!");
  //           System.exit(0);
  //         }
  //       }
  //       System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
  //     }
  //     System.out.println();
  //   }
  }
}
