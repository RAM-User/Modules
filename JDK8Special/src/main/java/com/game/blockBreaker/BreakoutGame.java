package com.game.blockBreaker;

import com.sun.xml.internal.ws.util.CompletedFuture;
import javafx.beans.Observable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.CompletableFuture;

public class BreakoutGame extends JPanel implements ActionListener {
    private Timer timer;
    private Ball ball;
    private Paddle paddle;
    private Brick[][] bricks;
    private int score = 0;
    private boolean gameOver = false;

    public BreakoutGame() {
        setFocusable(true);
        setPreferredSize(new Dimension(800, 600));
        ball = new Ball(400, 300); // 小球初始位置
        paddle = new Paddle(400, 550); // 挡板初始位置
        bricks = new Brick[5][10];
        // 设置顶部砖块
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks[i][j] = new Brick(j * 80, i * 30);
            }
        }
        // 定时器 10/1000秒触发一次
        timer = new Timer(10, this);
        timer.start();
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                paddle.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {
                paddle.keyReleased(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        ball.draw(g);
        paddle.draw(g);
        for (Brick[] row : bricks) {
            for (Brick brick : row) {
                if (!brick.destroyed) {
                    brick.draw(g);
                }
            }
        }
        g.drawString("Score: " + score, 10, 20);
        if (gameOver) {
            g.drawString("Game Over! Your score: " + score, 350, 300);
            g.drawString("Press R to restart", 350, 330);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            ball.move();
            if (ball.checkCollision(new Rectangle(paddle.x, paddle.y, paddle.width, paddle.height))) {
                ball.dy = -ball.dy;
            }
            for (Brick[] row : bricks) {
                for (Brick brick : row) {
                    if (!brick.destroyed) {
                        if (brick.checkCollision(ball)) {
                            score++;
                            ball.dy = -ball.dy;
                        }
                    }
                }
            }
            if (ball.y > getHeight()) {
                gameOver = true;
                timer.stop();
            }
        }
        repaint();
    }

    public void resetGame() {
        ball = new Ball(400, 300); // 重置小球位置
        paddle = new Paddle(400, 550); // 重置挡板位置
        bricks = new Brick[5][10];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 10; j++) {
                bricks[i][j] = new Brick(j * 80, i * 30);
            }
        }
        score = 0;
        gameOver = false;
        timer.start();
    }

    public static void main(String[] args) {
        // 创建游戏窗口
        JFrame frame = new JFrame("Breakout Game");
        // 游戏面板
        BreakoutGame game = new BreakoutGame();
        // 添加游戏面板到窗口
        frame.add(game);
        // 调整窗口大小
        frame.pack();
        // 设置默认窗口管理操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 显示窗口
        frame.setVisible(true);
        // 添加键盘监听器
        frame.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_R && game.gameOver) {
                    game.resetGame();
                }
            }
        });
    }



}
