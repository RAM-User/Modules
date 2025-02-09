package com.game.blockBreaker;

import java.awt.*;


class Ball {
    int x, y;
    int dx = 2, dy = -2; // 小球移动速度，初始方向向上
    int size = 20;

    Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move() {
        x += dx;
        y += dy;
    }

    void draw(Graphics g) {
        g.fillOval(x, y, size, size);
    }

    boolean checkCollision(Rectangle rect) {
        return new Rectangle(x, y, size, size).intersects(rect);
    }
}
