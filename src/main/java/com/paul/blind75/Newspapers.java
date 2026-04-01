package com.paul.blind75;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Newspapers {
    public static void main(String[] args) {
//        List<Integer> integers = List.of(7, 2, 5, 10, 8);
        List<Integer> integers = List.of(2, 3, 5, 7);
        int res = newspapersSplit(new ArrayList<>(integers), 3);
        System.out.println(res);

    }


    public static int newspapersSplit(List<Integer> newspapers, int numCoworkers) {
        int n = newspapers.size();

        int l = 0;
        int r = n;
        int min = newspapers.stream().mapToInt(value -> value).sum();

        while (l <= r) {

            int mid = l + (r - l)/2;

            int step = mid;

            int sum = findSum(newspapers, n, step);

            if (min == sum ) return sum;

            if (sum > min) {
                r = mid - 1;

            } else {
                l = mid + 1;


            }
        }




        return min;
    }

    private static int findSum(List<Integer> newspapers, int n, int step) {
        int i = 0;

        int sum = 0;
        List<NewsData> list = new ArrayList<>();
        for (; i < n; i++) {
            Integer paper = newspapers.get(i);
            sum += paper;
            if (i == step) {
                list.add(new NewsData(step - i, i, sum));
                step += i;
                sum = 0;
            }
        }

        if (sum != 0) {
            list.add(new NewsData(step - i, i, sum));
        }

        list.sort(Comparator.comparingInt(NewsData::sum));

        return list.getLast().sum();
    }
}

record NewsData(int start, int end, int sum) {

}


/*final class NewsData {
    private final int start;
    private final int end;
    private final int sum;

    NewsData(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
    }

    public int start() {
        return start;
    }

    public int end() {
        return end;
    }

    public int sum() {
        return sum;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        NewsData newsData = (NewsData) o;
        return start == newsData.start && end == newsData.end && sum == newsData.sum;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        result = 31 * result + sum;
        return result;
    }
}*/
