package com.game.blockBreaker;

import java.awt.*;

class Brick {
    int x, y;
    int width = 80, height = 30;
    boolean destroyed = false;

    Brick(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Graphics g) {
        if (!destroyed) {
            g.fillRect(x, y, width, height);
        }
    }

    boolean checkCollision(Ball ball) {
        if (!destroyed && new Rectangle(x, y, width, height).intersects(new Rectangle(ball.x, ball.y, ball.size, ball.size))) {
            destroyed = true;
            return true;
        }
        return false;
    }
}
