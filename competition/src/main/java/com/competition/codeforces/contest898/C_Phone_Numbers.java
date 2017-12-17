package com.competition.codeforces.contest898;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class C_Phone_Numbers {
    //    buffered writer
    static PrintWriter out = new PrintWriter(System.out);
    //    buffered reader
    static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws Exception{
        int n = Integer.valueOf(rd.readLine());
        Map<String, LinkedList<String>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] item = rd.readLine().split(" ");

            LinkedList<String> entries = map.get(item[0]);
            if (entries == null) {
                entries = new LinkedList<>();
                map.put(item[0], entries);
            }

            String toInsert, toDel;
            for (int j = 2; j < item.length; j++) {
//                toInsert = null;
                toDel = null;
                boolean f = true;

                for (String no : entries) {
                    if (no.endsWith(item[j])) {
                        f = false; break;
                    } else if (item[j].endsWith(no)) {
                        toDel = no;
                    }
                }

                if (toDel != null) {
                    entries.remove(toDel);
                }
                if (f) {
                    entries.add(item[j]);
                }
            }
        }

        out.print(map.keySet().size());
        for (String name : map.keySet()) {
            out.println();
            List<String> entris = map.get(name);
            out.print(name + " " + entris.size());
            for (String no : entris) {
                out.print(" " + no);
            }
        }
        out.flush();
    }
}
