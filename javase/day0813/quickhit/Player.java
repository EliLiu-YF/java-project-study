package com.javase.day0813.quickhit;

import java.util.Scanner;

public class Player {
	private int levelNo = 1;
	
	private int currScore;
	
	private long startTime;
	
	private long elapsedTime;

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

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(long elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public Player(int levelNo, int currScore, int startTime, int elapsedTime) {
		super();
		this.levelNo = levelNo;
		this.currScore = currScore;
		this.startTime = startTime;
		this.elapsedTime = elapsedTime;
	}
	
	public Player(){
		
	}
	
	/**
	 * 玩家开始玩游戏
	 */
	public void play(){
		Scanner input = new Scanner(System.in);
		Game game = new Game(this);
		//外层循环控制游戏级别
		for(int i =0 ; i < LevelParam.levels.length; i++){
			//记录当前级别开始的时间
			this.startTime = System.currentTimeMillis();
			//内存循环控制每个级别中的游戏次数
			for(int j = 0; j < LevelParam.levels[i].getStrTimes(); j++){
				String strIn = game.printStr();
				String strOut = input.next();
				//比较输入输出字符串
				game.printResult(strIn, strOut);
			}
			this.setLevelNo(this.getLevelNo() + 1);
			this.setCurrScore(0);
			this.setElapsedTime(0);
			//当前玩家级别已经达到最高级
			if(i == 5){
				System.out.println("恭喜你通关,您的最终积分是：" + this.getCurrScore());
				System.exit(0);
			}
		}
	}
	
}
