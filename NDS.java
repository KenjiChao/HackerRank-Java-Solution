import java.io.*;
import java.util.*;

public class NDS {
    private static InputReader in;
    private static PrintWriter out;
    private static int n;
    private static int k;
    private static int[] nums;
    private static int[] histogram;

    public static void main(String[] args) throws IOException {
        in = new InputReader(System.in);
        out = new PrintWriter(System.out, true);

        n = in.nextInt();
        k = in.nextInt();
        nums = new int[n];
        histogram = new int[k + 1];
        for (int i = 0; i < n; i++) {
            nums[i] = (int) (in.nextLong() % (long) k);
            histogram[nums[i]] += 1;
        }

        out.println(solve());

        out.close();
        System.exit(0);
    }

    private static int solve() {
        int ret = 0;

        if (histogram[0] > 1) {
            histogram[0] = 1;
        }

        if (k % 2 == 0 && histogram[k / 2] > 1) {
            histogram[k / 2] = 1;
        }

        for (int i = 0; i <= k / 2; i++) {
            ret += Math.max(histogram[i], histogram[k - i]);
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
