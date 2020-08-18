package com.javase.day0813.Game;

import com.tools.InputUtil;

public class Player {
    /**
     * 玩家等级号
     */
    private int levelNo;
    /**
     * 玩家当前级别积分
     */
    private int currScore;
    /**
     * 当前级别开始时间
     */
    private long startTime;
    /**
     * 当前级别已用时间
     */
    private int elapsedTime;

    /**
     * 玩游戏
     */
    public void play() {
        Game game = new Game(this);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < LevelParam.level(this.getLevelNo()).getStrTimes(); j++) {
                String str = game.printStr();
                String inputStr = InputUtil.inputStr("");
                try {
                    game.printResult(str, inputStr);
                    System.out.println("输入正确,您的积分" + this.getCurrScore() + ",你的级别" + this.getLevelNo()
                            + ",已用时间" + this.getElapsedTime());
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.exit(0);
                }
            }
            this.setLevelNo(this.getLevelNo() + 1);
            this.setCurrScore(0);
            this.setElapsedTime(0);
            this.setStartTime(System.currentTimeMillis());
            game.setPlayer(this);
        }
    }

    public Player(int levelNo, int currScore, long startTime, int elapsedTime) {
        this.levelNo = levelNo;
        this.currScore = currScore;
        this.startTime = startTime;
        this.elapsedTime = elapsedTime;
    }

    public Player() {
    }

    public int getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(int levelNo) {
        this.levelNo = levelNo;
    }

    public int getCurrScore() {
        return currScore;
    }

    public void setCurrScore(int currScore) {
        this.currScore = currScore;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public int getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(int elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
