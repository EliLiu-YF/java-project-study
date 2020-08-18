package com.javase.day0813.Game;

import java.util.Arrays;

public class LevelParam {
    /**
     * 6个等级
     */
    static private Level[] levels = new Level[6];

    static {
        levels[0] = new Level(1, 2, 10, 30, 1);
        levels[1] = new Level(2, 3, 9, 26, 2);
        levels[2] = new Level(3, 4, 8, 22, 5);
        levels[3] = new Level(4, 5, 7, 18, 8);
        levels[4] = new Level(5, 6, 6, 15, 10);
        levels[5] = new Level(6, 7, 5, 12, 15);
    }

    /**
     * 返回该玩家的等级参数
     * @param levelNo
     * @return
     */
    public final static Level level(int levelNo) {
        Level[] lvs = Arrays.stream(levels).filter(el -> el.getLevelNo() == levelNo).toArray(len -> new Level[len]);
        return lvs[0];
    }
}
