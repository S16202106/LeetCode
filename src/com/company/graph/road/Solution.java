package com.company.graph.road;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

    }

    public int solve(int[][] graph) {
        int[] res = new int[1];
        back(Integer.MAX_VALUE, 0, 0, 0, graph, res);
        return res[0];
    }

    public void back(int weight, int flag, int row, int col, int[][] graph, int[] res) {
        int endR = graph.length;
        int endC = graph[0].length;
        if (row == endR && col == endC) {
            if (weight < res[0])
                res[0] = weight;
        }

        // 向右走
        if (flag != 2) {
            int temp = 0;
            if (col < endR - 1) {
                temp = Math.abs(graph[row][col] - graph[row][col + 1]);
                weight = Math.max(weight, temp);
                back(weight, 1, row, col + 1, graph, res);
            }
        }
        // 向左走
        if (flag != 1) {
            int temp = 0;
            if (col > 0) {
                temp = Math.abs(graph[row][col] - graph[row][col - 1]);
                weight = Math.max(weight, temp);
                back(weight, 2, row, col - 1, graph, res);

            }
        }
        // 向下走
        int temp = 0;
        if (row < endR - 1) {
            temp = Math.abs(graph[row][col] - graph[row + 1][col]);
            weight = Math.max(weight, temp);
            back(weight, 0, row, col + 1, graph, res);
        }


    }
}

