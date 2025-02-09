package com.game.blockBreaker;

import java.awt.*;
import java.awt.event.KeyEvent;

class Paddle {
    int x, y;
    int width = 100, height = 20;
    int dx = 5; // 挡板移动速度

    Paddle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void draw(Graphics g) {
        g.fillRect(x, y, width, height);
    }

    void moveLeft() {
        if (x > 0) x -= dx;
    }

    void moveRight(int screenWidth) {
        if (x + width < screenWidth) x += dx;
    }

    void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) moveLeft();
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) moveRight(800);
    }

    void keyReleased(KeyEvent e) {
        // 可以添加释放键的逻辑（如果需要）
    }
}
