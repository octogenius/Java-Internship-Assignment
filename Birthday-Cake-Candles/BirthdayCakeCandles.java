import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer;
import java.lang.Math;
import java.lang.String;
import java.lang.System;
import java.util.StringTokenizer;

public class BirthdayCakeCandles {

    BufferedReader br;
    StringTokenizer st;

    public static void main(String[] args) {
        new BirthdayCakeCandles();
    }

    public BirthdayCakeCandles() {

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            int candlesCount = nextInt();
            int[] candleHeights = new int[candlesCount];

            for (int x = 0; x < candlesCount; x++) {
                candleHeights[x] = nextInt();
            }

            int largestCandle = 0;
            int largestCandlesCount = 0;

            for (int x = 0; x < candlesCount; x++) {
                if (candleHeights[x] > largestCandle) {
                    largestCandle = Math.max(candleHeights[x], largestCandle);
                    largestCandlesCount = 0;
                }

                if (candleHeights[x] == largestCandle) {
                    largestCandlesCount++;
                }
            }

            System.out.print(largestCandlesCount);

        } catch (Exception e) {
            System.out.print(e);
        }
    }

    String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine().trim());
        }

        return st.nextToken();
    }

    int nextInt() throws IOException {
        return Integer.parseInt(next());
    }
}
