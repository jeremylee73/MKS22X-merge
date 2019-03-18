public class Merge{
  /*sort the array from least to greatest value. This is a wrapper function*/
  public static void mergesort(int[] data){

  }

  private static void mergesort(int[] data, int lo, int hi){
    if (lo >= hi){
      return;
    }
    int mid = data.length / 2;
    int[] leftSide = new int[mid];
    for (int i=0; i<mid; i++){
      leftSide[i] = data[i];
    }
    int[] rightSide = new int[mid+1];
    if (data.length % 2 == 0){
      rightSide = new int[mid];
    }
    int j = 0;
    for (int i=mid; i<data.length; i++){
      rightSide[j] = data[i];
      j++;
    }
  }

  public static void main(String[] args){
    int[] data = {1, 2, 3, 4};
    mergesort(data, 0, 3);
  }
}
