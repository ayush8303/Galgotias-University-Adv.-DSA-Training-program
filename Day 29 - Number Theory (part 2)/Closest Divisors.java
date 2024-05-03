class Solution {
  public int[] closestDivisors(int num) {
    int[] arr1 = new int[2];
    int[] arr2 = new int[2];
    for (int i = (int) Math.sqrt(num + 1); i >= 1; i--) {
      if ((num + 1) % i == 0) {
        arr1[0] = i;
        arr1[1] = (num + 1) / i;
        break;
      }
    }
    for (int i = (int) Math.sqrt(num + 2); i >= 1; i--) {
      if ((num + 2) % i == 0) {
        arr2[0] = i;
        arr2[1] = (num + 2) / i;
        break;
      }
    }
    Arrays.sort(arr1);
    Arrays.sort(arr2);
    return (arr1[1] - arr1[0]) < (arr2[1] - arr2[0]) ? arr1 : arr2;
  }
}