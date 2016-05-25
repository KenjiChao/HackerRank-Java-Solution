import java.io.*;
import java.util.*;

public class DSP {
    private static InputReader in;
    private static PrintWriter out;
    private static int n;
    private static int k;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out, true);

        n = in.nextInt();
        k = in.nextInt();
        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt() % k;
        }

        out.println(solve());

        out.close();
        System.exit(0);
    }

    private static int solve() {
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int key = (k - nums[i]) % k;
            if (map.containsKey(key)) {
                ret += map.get(key);
            }

            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        return ret;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
