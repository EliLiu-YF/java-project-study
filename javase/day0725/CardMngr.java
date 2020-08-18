package com.javase.day0725;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class CardMngr {
    Card[] cards = new Card[54];

    int size = 0;

    public void init(){
        String[] pokers = {"黑桃A", "黑桃2", "黑桃3", "黑桃4", "黑桃5"
                , "黑桃6", "黑桃7", "黑桃8", "黑桃9", "黑桃10"
                , "黑桃J", "黑桃Q", "黑桃K",
                "梅花A", "梅花2", "梅花3", "梅花4", "梅花5"
                , "梅花6", "梅花7", "梅花8", "梅花9", "梅花10"
                , "梅花J", "梅花Q", "梅花K",
                "红心A", "红心2", "红心3", "红心4", "红心5"
                , "红心6", "红心7", "红心8", "红心9", "红心10"
                , "红心J", "红心Q", "红心K",
                "方块A", "方块2", "方块3", "方块4", "方块5"
                , "方块6", "方块7", "方块8", "方块9", "方块10"
                , "方块J", "方块Q", "方块K", "小王", "大王"};
        int[] values = new int[54];
        for (int i = 0; i < values.length; i++) {
            values[i] = i+1;
        }
        Random random = new Random();

        for (int i = 1; i <= 54; i++){
            Card card = new Card();
            int rnd = random.nextInt(pokers.length);
            card.value = values[rnd];
            card.desc = pokers[rnd];
            cards[i-1] = card;
            for (int j = rnd; j < pokers.length - 1; j++) {
                pokers[j] = pokers[j+1];
                values[j] = values[j+1];
            }
            pokers[pokers.length-1] = pokers[rnd];
            values[values.length-1] = values[rnd];
            pokers = Arrays.copyOf(pokers, pokers.length -1);
            values = Arrays.copyOf(values,values.length-1);
            ++size;
        }
    }

    /**
     * 初始化牌
     */
    public void initializeCards() {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card();
            cards[i].value = i + 1;
            switch (i / 13) {
                case 0:
                    cards[i].desc = "黑桃";
                    break;
                case 1:
                    cards[i].desc = "梅花";
                    break;
                case 2:
                    cards[i].desc = "红心";
                    break;
                case 3:
                    cards[i].desc = "方块";
                    break;
            }
            if (i + 1 == 53) {
                cards[i].desc = "小王";
            } else if (i + 1 == 54) {
                cards[i].desc = "大王";
            } else if ((i + 1) % 13 > 1 && (i + 1) % 13 < 11) {
                cards[i].desc += (i + 1) % 13;
            } else if ((i + 1) % 13 == 1) {
                cards[i].desc += "A";
            } else if ((i + 1) % 13 == 11) {
                cards[i].desc += "J";
            } else if ((i + 1) % 13 == 12) {
                cards[i].desc += "Q";
            } else if ((i + 1) % 13 == 0) {
                cards[i].desc += "K";
            }
        }
        size = cards.length;
    }

    /**
     * 根据value值返回牌的信息
     *
     * @param value
     * @return
     */
    public String getCardString(int value) {
        if (!(value >= 1 && value <= 54)) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (cards[i].value == value) {
                return cards[i].show();
            }
        }
        return "不存在";
    }

    /**
     * 根据牌的整数值返回牌的整个对象
     *
     * @param value
     * @return
     */
    public Card getCard(int value) {
        if (!(value >= 1 && value <= 54)) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            if (cards[i].value == value) {
                return cards[i];
            }
        }
        return null;
    }

    /**
     * 随机num张牌 不重复
     *
     * @param num
     * @return
     */

    public Card[] randomCard(int num) {
        Random random = new Random();
        Card[] cardArr = new Card[num];
        for (int i = 0; i < num; i++) {
            int index = random.nextInt(size);
            Card card = cards[index];
            //将index索引之后的元素往前移,空出最后一个位置
            for (int j = index; j < size - 1; j++) {
                cards[j] = cards[j + 1];
            }
            cards[size - 1] = card;
            cards = Arrays.copyOf(cards, size - 1);
            size = cards.length;
            cardArr[i] = card;
        }

        return cardArr;
    }

    /**
     * 打印剩余牌的信息
     */
    public void show() {
        for (Card card : cards) {
            System.out.println(card.show());
        }
    }

    /**
     * 增加牌到数组中,如果当前数组已有54张牌，或者数组中已有这张牌，则返回失败
     * @param card
     * @return
     */
    public boolean addCard(Card card) {
        if (size == 54) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (cards[i].value == card.value) {
                return false;
            }
        }
        cards = Arrays.copyOf(cards, size + 1);
        ++size;
        cards[size - 1] = card;
        return true;
    }

    /**
     * 删除指定值的牌
     * @param value
     * @return
     */
    public boolean delCard(int value){
        Card card;
        int i;
        for (i = 0; i < size; i++) {
            if (cards[i].value == value){
                card = cards[i];
                for (int j = i; j < size - 1; j++) {
                    cards[j] = cards[j + 1];
                }
                cards[size - 1] = card;
                cards = Arrays.copyOf(cards, size - 1);
                size = cards.length;
                return true;
            }
        }
        return false;

    }

    /**
     * 改变牌值为value的描述信息为desc,如果没找到这张牌，返回false
     * @param value
     * @param desc
     * @return
     */
    public boolean updateCard(int value, String desc){
        for (int i = 0; i < size; i++) {
            if (cards[i].value == value){
                cards[i].desc = desc;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CardMngr cardMngr = new CardMngr();
//        cardMngr.initializeCards();
//        cardMngr.delCard(54);
//        cardMngr.show();
        cardMngr.init();
        cardMngr.show();
    }
}
