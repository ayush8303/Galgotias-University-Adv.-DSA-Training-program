
class Solution {
  String s;
  Map<Integer, List<List<String>>> mp;

  public Solution() {
    this.mp = new HashMap<>();
  }

  public boolean isPalindrome(int i, int j) {
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }

  public List<List<String>> dp(int i) {
    if (i == s.length())
      return new ArrayList<>();

    if (mp.containsKey(i))
      return mp.get(i);

    List<List<String>> ans = new ArrayList<>();

    for (int j = i; j < s.length(); j++) {
      if (isPalindrome(i, j)) {
        List<List<String>> res = dp(j + 1);
        String substring = s.substring(i, j + 1);

        for (List<String> x : res) {
          List<String> newList = new ArrayList<>(x);
          newList.add(0, substring);
          ans.add(newList);
        }

        if (res.isEmpty()) {
          List<String> singleList = new ArrayList<>();
          singleList.add(substring);
          ans.add(singleList);
        }
      }
    }

    mp.put(i, ans);
    return ans;
  }

  public List<List<String>> partition(String s) {
    this.s = s;
    return dp(0);
  }

}