package com.javase.day0813.quickhit;

import java.util.Random;

public class Game {

	private Player player;
	
	public Game(Player player){
		this.player = player;
	}
	
	/**
	 * 输出字符串，返回字符串用于和玩家输入比较。
	 * 随机生成各级别的字符串
	 * @return
	 */
	public String printStr(){
		StringBuffer sb = new StringBuffer();
		//player.getLevelNo();
		//得到指定级别的字符个数
		//玩家所在的级别
		int levelNo = player.getLevelNo();
		Level l = LevelParam.levels[levelNo - 1];
		int len = l.getStrLength();
		/**
		 * int len = LevelParam.levels[player.getLevelNo() - 1].getStrLength()
		 */
		Random random = new Random();
		//生成指定个数的字符
		for(int i = 0; i < len; i++){
			int temp = random.nextInt(7);
			switch(temp){
			case 0:
				sb.append(">");
				break;
			case 1:
				sb.append("<");
				break;
			case 2:
				sb.append("+");
				break;
			case 3:
				sb.append("a");
				break;
			case 4:
				sb.append("z");
				break;
			case 5:
				sb.append("p");
				break;
			case 6:
				sb.append("d");
				break;
			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	/**
	 * 比较游戏输出out和玩家输入in，根据比较结果输出相应信息
	 * @param out
	 * @param in
	 */
	public void printResult(String out, String in){
		if(!out.equals(in)){
			System.out.println("输入错误,游戏结束!");
			System.exit(-1);
		}
		//如果输入的和生成的字符串相等，记录时间，判断时间,增加积分
		long elapsedTime = System.currentTimeMillis() - player.getStartTime();
		player.setElapsedTime(elapsedTime);
		if((elapsedTime / 1000) > LevelParam.levels[player.getLevelNo() - 1].getTimeLimit()){
			System.out.println("您已超时，游戏结束");
			System.exit(-1);
		}
		
		int perScore = LevelParam.levels[player.getLevelNo() - 1].getPerScore();
		player.setCurrScore(player.getCurrScore() + perScore);
		
		System.out.println("输入正确，您的积分是：" + player.getCurrScore() + ", 您的级别：" + player.getLevelNo() + ",已用时间:" + player.getElapsedTime() / 1000 + " 秒");
		
	}
}
