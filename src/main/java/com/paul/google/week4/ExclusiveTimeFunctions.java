package com.paul.google.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/exclusive-time-of-functions/description/">Q3. Exclusive Time of Functions</a>
 */
public class ExclusiveTimeFunctions {

    public static void main(String[] args) {
//n = 2, logs = ["0:start:0","1:start:2","1:end:5","0:end:6"]
        int n = 2;
        List<String> strings = List.of("0:start:0", "1:start:2", "1:end:5", "0:end:6");
        int[] res = exclusiveTime(n, strings);
        System.out.println(Arrays.toString(res));
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        List<Log> listLogs = new ArrayList<>();

        Stack<Log> stack = new Stack<>();
        int[] res = new int[n];
        int max = 0;

        for (String log : logs) {
            String[] splitLog = log.split(":");
            String id = splitLog[0];
            String action = splitLog[1];
            String time = splitLog[2];

            Integer timeInt = Integer.valueOf(time);
            if (action.equals("start")) {
                listLogs.add(new Log(Integer.valueOf(id), timeInt, null));
            } else {
                max = Math.max(max, timeInt);
                listLogs.add(new Log(Integer.valueOf(id), null, timeInt));
            }
        }


        int pos = listLogs.get(0).start();
        stack.add(listLogs.get(0));

        for (int i = 1; i < listLogs.size(); i++) {
            Log log = listLogs.get(i);
            //"0:start:0","1:start:2","1:end:5","0:end:6"
            if (log.start() != null) {
                if (!stack.isEmpty()) {
                    res[stack.peek().id()] += log.start() - pos;
                }
                pos = log.start();
                stack.add(log);

            } else {
                res[log.id()] += log.finish() + 1 - pos;
                pos = log.finish() + 1;
                stack.pop();
            }

        }

        return res;

    }
}

record Log(Integer id, Integer start, Integer finish) {

}