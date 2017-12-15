package com.competition.codeforces.contest877;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * Created by fengbo on 17/10/24.
 */
public class B_Nikita_and_string {

//    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
//    buffered reader
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        String s = reader.readLine();

        int[] leftCountOfA = new int[s.length() + 10];
        int[] rightCountOfA = new int[s.length() + 10];

        int len = s.length();

        //
        leftCountOfA[0] = 0;
        for (int i = 1; i <= len; i++) {
            if (s.charAt(i - 1) == 'a') leftCountOfA[i] = leftCountOfA[i-1] + 1;
            else leftCountOfA[i] = leftCountOfA[i - 1];
        }
        //
        rightCountOfA[len] = 0;
        for (int i = len - 1; i >= 0 ; i--) {
            if (s.charAt(i) == 'a') rightCountOfA[i] = rightCountOfA[i + 1] + 1;
            else rightCountOfA[i] = rightCountOfA[i + 1];
        }

        int ans = 0;

        for (int l = 0; l <= len; l++) {
            for (int r = l; r <= len ; r++) {
                int la = leftCountOfA[l];
                int ra = rightCountOfA[r];
                int mb = r - l - (leftCountOfA[r] - leftCountOfA[l]);
                ans  = Math.max(ans, la + ra + mb);
            }
        }

        out.println(ans);
        out.flush();
    }
}
