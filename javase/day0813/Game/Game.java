package com.javase.day0813.Game;

import java.util.Random;

public class Game {
    /**
     * 玩家
     */
    private Player player;

    public Game(Player player) {
        this.player = player;
    }

    public Game() {
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * 输出返回字符串
     *
     * @return
     */
    public String printStr() {
        StringBuilder stringBuilder = new StringBuilder();
        Level lv = LevelParam.level(player.getLevelNo());
        Random random = new Random();
        for (int i = 0; i < lv.getStrLength(); i++) {
            int ran = random.nextInt(3);
            switch (ran){
                case 0:
                    stringBuilder.append("<");
                    break;
                case 1:
                    stringBuilder.append("*");
                    break;
                case 2:
                    stringBuilder.append(">");
                    break;
            }
        }
        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }

    /**
     * 将输出字符串与玩家输入字符串进行比较
     *
     * @param out
     * @param in
     */
    public void printResult(String out, String in) throws Exception {
        if (!out.equals(in)){
            throw new Exception("输入错误");
        }
        long currentTime = System.currentTimeMillis();
        System.out.println((currentTime - player.getStartTime()) / 1000);
        if ((currentTime - player.getStartTime()) / 1000 >
        LevelParam.level(player.getLevelNo()).getTimeLimit()){
            throw new Exception("你输入的太慢了,输入超时,退出!");
        }
        player.setCurrScore(player.getCurrScore() + LevelParam.level(player.getLevelNo()).getPerScore());
        player.setElapsedTime((int)(currentTime - player.getStartTime()) / 1000);
    }
}
