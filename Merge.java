public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[] data){
    mergesort(data, 0, data.length-1);
  }

  private static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int mid = (hi + lo) / 2;
    int[] leftSide = new int[mid];
    int j = 0;
    for (int i=lo; i<mid; i++){
      leftSide[j] = data[i];
      j++;
    }
    int[] rightSide = new int[hi - mid];
    j = 0;
    for (int i=mid; i<hi; i++){
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

  public static void main(String[] args){
    int[] data = {1, 2, 3, 4};
    mergesort(data);
    printArray(data);
  }
}
