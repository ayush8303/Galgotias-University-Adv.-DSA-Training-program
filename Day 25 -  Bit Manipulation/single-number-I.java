import java.util.*;

class Solution {
  public int singleNumber(int[] nums) {
    int cumulativeXor = 0;
    for (int x : nums) {
      cumulativeXor ^= x;
    }
    return cumulativeXor;
  }
}
