class Solution {
  public int[] singleNumber(int[] nums) {
    int cumulativeXOR = 0;
    for (int x : nums) {
      cumulativeXOR ^= x;
    }

    int pos = 0;
    int temp = cumulativeXOR;
    while ((temp & 1) == 0) {
      temp >>= 1;
      pos++;
    }

    int varA = 0;
    int varB = 0;
    int mask = (1 << pos);
    for (int x : nums) {
      if ((x & mask) > 0) {
        varA ^= x;
      } else {
        varB ^= x;
      }
    }
    return new int[] { varA, varB };
  }
}