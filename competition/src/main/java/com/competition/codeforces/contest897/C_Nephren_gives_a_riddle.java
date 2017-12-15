package com.competition.codeforces.contest897;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class C_Nephren_gives_a_riddle {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    static String f0 = "What are you doing at the end of the world? Are you busy? Will you save us?";
    static String p1 = "What are you doing while sending \"";
    static String p2 = "\"? Are you busy? Will you send \"";
    static String p3 = "\"?";

    public static void main(String[] args) throws Exception {


//        System.out.println(f0.length());      75
//        System.out.println(p1.length());      34
//        System.out.println(p2.length());      32
//        System.out.println(p3.length());      2

        char[] chars = new char[100010];
        long[] lens = new long[64];

        lens[0] = 75;
        for (int i = 1; i < 64; i++) {
            lens[i] = lens[i - 1] * 2 + 68;
//            System.out.println(lens[i]);
        }

//        System.out.println(lens[63]);

        int q = Integer.valueOf(rd.readLine());
        String ans = "";
        for (int i = 0; i < q; i++) {
            String[] ar = rd.readLine().split(" ");
            int n = Integer.valueOf(ar[0]);
            long k = Long.valueOf(ar[1]);

            //
            if (n >= 53) {
                if (k < n * 34){
                    ans += p1.charAt((int)(k % 34) - 1);
                    continue;
                }
                if (k == n * 34) {
                    ans += p1.charAt(p1.length() - 1);
                    continue;
                }

                k = k - (n - 53) * 34;
                n = 53;
            }

            char ch = main(n, k, lens);
            ans += String.valueOf(ch);
        }

        System.out.println(ans);
    }

    static char main(int n, long k, long[] lens) {
        if (k < 0)
            return '.';
        if (n < 64 && lens[n] < k)
            return '.';

        if (n == 0)
            return f0.charAt((int)(k - 1));

        if (k <= 34)
            return p1.charAt((int)(k - 1));

//        if (n >= 64)
//            return main(n-1, k - 34, lens);

        if (k > 34 && k <= 34 + lens[n - 1])
            return main(n-1, k - 34, lens);

        if (k > 34 + lens[n - 1] && k <= 34 + lens[n - 1] + 32)
            return p2.charAt((int)(k - 34 - lens[n - 1] - 1));

        if (k > 34 + lens[n - 1] + 32 && k <= 34 + 2 * lens[n - 1] + 32)
            return main(n - 1, k - 34 - lens[n - 1] - 32, lens);

        return p3.charAt((int)(k - 34 - 2 * lens[n - 1] - 32 - 1));
    }
}
