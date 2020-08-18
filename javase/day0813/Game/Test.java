package com.javase.day0813.Game;

import com.tools.InputUtil;

public class Test {
    public static void main(String[] args) {
        Player player = new Player(1, 0, System.currentTimeMillis(), 0);
        player.play();
    }
}
