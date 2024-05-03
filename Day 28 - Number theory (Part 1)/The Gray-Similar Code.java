import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    FastReader in = new FastReader(System.in);
    PrintWriter pw = new PrintWriter(System.out);

    int n = in.nextInt();
    long[] a = new long[n];
    for (int i = 0; i < n; i++)
      a[i] = in.nextLong();
    pw.println(solve(a, n) ? "Yes" : "No");

    pw.close();
  }

  static boolean solve(long[] a, int n) {

    if (n >= 130)
      return true;
    HashMap<Long, Integer> map = new HashMap<>();
    for (long x : a)
      map.put(x, map.getOrDefault(x, 0) + 1);
    for (int i = 0; i < n; i++) {
      long v = a[i];
      map.put(v, map.getOrDefault(v, 0) - 1);
      for (int j = i + 1; j < n; j++) {
        long v2 = a[j];
        map.put(v2, map.getOrDefault(v2, 0) - 1);
        for (int k = j + 1; k < n; k++) {
          long v3 = a[k];
          map.put(v3, map.get(v3) - 1);
          long newVal = v ^ v2 ^ v3;
          // debug(newVal, v, v2, v3);
          if (map.containsKey(newVal)) {
            if (map.getOrDefault(newVal, 0) > 0)
              return true;
          }
          map.put(v3, map.getOrDefault(v3, 0) + 1);
        }
        map.put(v2, map.getOrDefault(v2, 0) + 1);
      }
      map.put(v, map.getOrDefault(v, 0) + 1);
    }

    return false;
  }

  static void debug(Object... obj) {
    System.err.println(Arrays.deepToString(obj));
  }

  public static class FastReader {
    InputStream is;
    private byte[] inbuf = new byte[1024];
    private int lenbuf = 0, ptrbuf = 0;

    public FastReader(InputStream is) {
      this.is = is;
    }

    public int readByte() {
      if (lenbuf == -1)
        throw new InputMismatchException();
      if (ptrbuf >= lenbuf) {
        ptrbuf = 0;
        try {
          lenbuf = is.read(inbuf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (lenbuf <= 0)
          return -1;
      }
      return inbuf[ptrbuf++];
    }

    public boolean isSpaceChar(int c) {
      return !(c >= 33 && c <= 126);
    }

    private boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }

    public int skip() {
      int b;
      while ((b = readByte()) != -1 && isSpaceChar(b))
        ;
      return b;
    }

    public String next() {
      int b = skip();
      StringBuilder sb = new StringBuilder();
      while (!(isSpaceChar(b))) {
        sb.appendCodePoint(b);
        b = readByte();
      }
      return sb.toString();
    }

    public String nextLine() {
      int c = skip();
      StringBuilder sb = new StringBuilder();
      while (!isEndOfLine(c)) {
        sb.appendCodePoint(c);
        c = readByte();
      }
      return sb.toString();
    }

    public int nextInt() {
      int num = 0, b;
      boolean minus = false;
      while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
        ;
      if (b == '-') {
        minus = true;
        b = readByte();
      }
      while (true) {
        if (b >= '0' && b <= '9') {
          num = (num << 3) + (num << 1) + (b - '0');
        } else {
          return minus ? -num : num;
        }
        b = readByte();
      }
    }

    public long nextLong() {
      long num = 0;
      int b;
      boolean minus = false;
      while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
        ;
      if (b == '-') {
        minus = true;
        b = readByte();
      }

      while (true) {
        if (b >= '0' && b <= '9') {
          num = (num << 3) + (num << 1) + (b - '0');
        } else {
          return minus ? -num : num;
        }
        b = readByte();
      }
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }

    public char[] next(int n) {
      char[] buf = new char[n];
      int b = skip(), p = 0;
      while (p < n && !(isSpaceChar(b))) {
        buf[p++] = (char) b;
        b = readByte();
      }
      return n == p ? buf : Arrays.copyOf(buf, p);
    }

    public char readChar() {
      return (char) skip();
    }
  }

}