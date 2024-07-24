package week4.BOJ9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Seorim {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        LCS(s1, s2);
    }

    private static void LCS(String s1, String s2) {

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i=1; i<=s1.length(); i++) {
            for (int j=1; j<=s2.length(); j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[s1.length()][s2.length()]);
        print(s1, dp, s1.length(), s2.length());

    }

    private static void print(String s, int[][] dp, int i, int j) {

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i-1][j]) {
                i--;
            } else if (dp[i][j] == dp[i][j-1]) {
                j--;
            } else if (dp[i][j] == dp[i-1][j-1] + 1) {
                sb.append(s.charAt(i-1));
                i--; j--;
            }
        }

        System.out.println(sb.reverse());

    }

}
