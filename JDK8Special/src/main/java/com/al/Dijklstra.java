package com.al;

public class Dijklstra {
    public static void main(String[] args) {
        int dis[][] = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int distance = dis[2][2];
        for (int i = 3; i > 0; i--) {
            distance = minDistance(dis[i - 1][i], dis[i][i - 1], distance);
        }
    }

    private static int minDistance(int left, int up, int distance) {
        return Math.min(distance + left, distance + up);
    }
}
