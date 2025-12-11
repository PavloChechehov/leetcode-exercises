package com.paul.atlassian;

import java.util.Stack;



/**
 * <a href="https://leetcode.com/problems/crawler-log-folder/description/">1598. Crawler Log Folder</a>
 * */
public class CrawlerLogFolder {

    public static void main(String[] args) {
        String[] logs1 = {"d1/", "d2/", "./", "d3/", "../", "d31/"};
        int res1 = minOperations(logs1);
        System.out.println(res1);
        assert res1 == 3;

        String[] logs2 = {"d1/","../","../","../"};
        int res2 = minOperations(logs2);
        System.out.println(res2);
        assert res2 == 0;

    }

    public static int minOperations(String[] logs) {
        // main
        //    -> d1
        //       -> d2


        Stack<String> folders = new Stack<>();


        for(String log: logs) {

            switch (log) {
                case "../" -> {
                    if (!folders.isEmpty()) folders.pop();
                }
                case "./"  -> {
                    // do nothing, stay in the same folders
                }
                default -> folders.add(log);
            }
        }

        return folders.size();
    }
}
