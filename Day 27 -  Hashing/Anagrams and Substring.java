import java.util.*;

public class Main {
  public static List<Integer> getHashValue(String s, int i, int j) {
    int[] freq = new int[26];
    for (int k = i; k <= j; k++) {
      freq[s.charAt(k) - 'a']++;
    }
    List<Integer> hashList = new ArrayList<>();
    for (int num : freq) {
      hashList.add(num);
    }
    return hashList;
  }

  public static int anagramsSubstring(String s) {
    int n = s.length();
    Map<List<Integer>, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        List<Integer> hash = getHashValue(s, i, j);
        map.put(hash, map.getOrDefault(hash, 0) + 1);
      }
    }
    int ans = 0;
    for (int freq : map.values()) {
      ans += (freq * (freq - 1)) / 2;
    }
    return ans;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String s = scanner.next();
    System.out.println(anagramsSubstring(s));
    scanner.close();
  }
}
