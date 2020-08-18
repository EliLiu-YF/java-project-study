package com.soso.liuyufeng.soso;

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class CardUtil {
    Map<String, MobileCard> cards = new HashMap<>();

    Map<String, List<ConsumInfo>> consumInfos = new HashMap<>();

    List<Scene> scenes = new ArrayList<>();

    public CardUtil() {

    }

    /**
     * 初始化
     * 初始构造几个MobileCard对象 方便测试
     * 初始化几个消费场景方便useSoso
     */
    public void initScene() {
        Scene scene0 = new Scene("通话", 90, "问候客户，谁知其如此难缠，通话90分钟");
        Scene scene1 = new Scene("通话", 30, "询问妈妈身体状况，本地通话30分钟");
        Scene scene2 = new Scene("短信", 5, "参与环境保护实施方案问卷调查，发送短信5条");
        Scene scene3 = new Scene("短信", 50, "通知朋友手机换号，发送短信50条");
        Scene scene4 = new Scene("上网", 1024, "和女朋友用微信视频聊天，使用流量1GB");
        Scene scene5 = new Scene("上网", 2 * 1024, "晚上手机在线看韩剧，不留神睡着啦！使用2GB");
        scenes.add(scene0);
        scenes.add(scene1);
        scenes.add(scene2);
        scenes.add(scene3);
        scenes.add(scene4);
        scenes.add(scene5);
        //初始化cards consumInfos 反序列化
        File cardFile = new File("liuyufeng_cards.log");
        File consumInfoFile = new File("liuyufeng_consumInfo.log");
        InputStream is1 = null;
        ObjectInputStream ois1 = null;
        InputStream is2 = null;
        ObjectInputStream ois2 = null;
        try {
            if (cardFile.exists()){
                is1 = new FileInputStream(cardFile);
            }
            if (consumInfoFile.exists()){
                is2 = new FileInputStream(consumInfoFile);
            }
            if(is1!=null && is1.available() > 0){
                ois1 = new ObjectInputStream(is1);
                cards = (Map<String, MobileCard>) ois1.readObject();
            }
            if (is2 != null && is2.available() > 0){
                ois2 = new ObjectInputStream(is2);
                consumInfos = (Map<String, List<ConsumInfo>>) ois2.readObject();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is1 != null){
                    is1.close();
                    ois1.close();
                }
                if (is2 != null){
                    is2.close();
                    ois2.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 判断卡号是否存在
     *
     * @param number
     * @param password
     * @return
     */
    public boolean isExistCard(String number, String password) {
        if (!cards.containsKey(number)) {
            return false;
        }
        if (!cards.get(number).getPassWord().equals(password)) {
            return false;
        }
        return true;
    }

    /**
     * 判断卡号是否存在
     *
     * @param number
     * @return
     */
    public boolean isExistCard(String number) {
        if (!cards.containsKey(number)) {
            return false;
        }
        return true;
    }

    /**
     * 随机产生一个139开头的手机号
     *
     * @return
     */
    public String createNumber() {
        StringBuffer str = new StringBuffer("139");
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            String s = String.valueOf(random.nextInt(10));
            str.append(s);
        }

        return str.toString();
    }

    /**
     * 产生多个号码
     *
     * @param count
     * @return
     */
    public String[] getNewNumber(int count) {
        String[] strings = new String[count];
        for (int i = 0; i < count; i++) {
            strings[i] = createNumber();
        }
        return strings;
    }

    /**
     * 添加用户
     *
     * @param card
     */
    public void addCard(MobileCard card) throws Exception {
        if (card == null) {
            throw new Exception("用户为空");
        }
        cards.put(card.getCardNumber(), card);
    }

    /**
     * 注销
     *
     * @param number
     */
    public void delCard(String number) {
        cards.remove(number);
    }

    /**
     * 套餐余量查询
     *
     * @param number
     */
    public void showRemainDetail(String number) {
        Set<String> nums = cards.keySet();
        Iterator<String> iterator = nums.iterator();
        DecimalFormat format = new DecimalFormat("#.0");
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals(number)) {
                MobileCard value = cards.get(key);

                System.out.println("你的卡号: " + number + ", 套餐内剩余:");
                int talkTime = 0;
                if (value.getSerPackage() instanceof NetPackage) {
                    talkTime = 0;
                } else if (value.getSerPackage() instanceof TalkPackage) {
                    talkTime = Math.max(((TalkPackage) value.getSerPackage()).getTalkTime() - value.getRealTalkTime()
                            , 0);
                } else if (value.getSerPackage() instanceof SuperPackage) {
                    talkTime = Math.max(((SuperPackage) value.getSerPackage()).getTalkTime() - value.getRealTalkTime()
                            , 0);
                }
                int smsCount = 0;
                if (value.getSerPackage() instanceof NetPackage) {
                    smsCount = 0;
                } else if (value.getSerPackage() instanceof TalkPackage) {
                    smsCount = Math.max(((TalkPackage) value.getSerPackage()).getSmsCount() - value.getRealSMSCount()
                            , 0);
                } else if (value.getSerPackage() instanceof SuperPackage) {
                    smsCount = Math.max(((SuperPackage) value.getSerPackage()).getSmsCount() - value.getRealSMSCount()
                            , 0);
                }
                int flow = 0;
                if (value.getSerPackage() instanceof TalkPackage) {
                    flow = 0;
                } else if (value.getSerPackage() instanceof NetPackage) {
                    flow = Math.max(((NetPackage) value.getSerPackage()).getFlow() - value.getRealFlow()
                            , 0);
                } else if (value.getSerPackage() instanceof SuperPackage) {
                    flow = Math.max(((SuperPackage) value.getSerPackage()).getFlow() - value.getRealFlow()
                            , 0);
                }
                System.out.println("通话时长: " + talkTime + "分钟");
                System.out.println("短信条数: " + smsCount + "条");
                System.out.println("上网流量: " +
                        String.valueOf(flow / 1024.0).substring(0, String.valueOf(flow / 1024.0).indexOf(".") + 2) + "GB");
            }
        }

    }

    /**
     * 当月账单查询
     * 参数number是卡号
     */
    public void showAmountDetail(String number) {
        Set<String> nums = cards.keySet();
        Iterator<String> iterator = nums.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.equals(number)) {
                MobileCard value = cards.get(key);
                DecimalFormat format = new DecimalFormat("0.0");
                format.setRoundingMode(RoundingMode.FLOOR);
                System.out.println("你的卡号: " + number + ", 当月账单:");
                System.out.println("套餐资费: " + format.format(value.getSerPackage().getPrice()));
                System.out.println("合计: " + format.format(value.getConsumAmount()));
                System.out.println(value.getMoney());
                System.out.println("账户余额: " + format.format(value.getMoney()));

            }
        }
    }

    /**
     * 增加消费记录
     * 需要把消费记录序列化到文件中
     * 消费记录文件名称定为：consumInfo.log
     *
     * @param consumInfo
     */
    public void addConsumInfo(String number, ConsumInfo consumInfo) {
        if (!consumInfos.containsKey(number)) {
            System.out.println("不存在次卡的消费记录,已添加一条消费记录");
            List<ConsumInfo> consumInfoList = new ArrayList<>();
            consumInfoList.add(consumInfo);
            consumInfos.put(number, consumInfoList);
        } else {
            List<ConsumInfo> consumInfoList = consumInfos.get(number);
            consumInfoList.add(consumInfo);
            consumInfos.put(number, consumInfoList);
        }
    }

    /**
     * 使用嗖嗖，模拟消费场景
     *
     * @param number
     */
    public void useSoso(String number) throws Exception {
        if (!isExistCard(number)){
            throw new Exception("该号码不存在");
        }
        Random random = new Random();
        MobileCard card = cards.get(number);
        ConsumInfo consumInfo = new ConsumInfo();
        do {
            int rnd = random.nextInt(6);
            Scene scene = scenes.get(rnd);
            if (card.getSerPackage() instanceof TalkPackage) {
                if (scene.getType().equals("上网")) {
                    continue;
                } else if (scene.getType().equals("通话")) {
                    System.out.println(scene.getDescription());
                    ((TalkPackage) card.getSerPackage()).call(scene.getData(), card);
                    consumInfo.setType(scene.getType());
                    consumInfo.setCousumData(scene.getData());
                    addConsumInfo(number, consumInfo);
                } else if (scene.getType().equals("短信")) {
                    System.out.println(scene.getDescription());
                    ((TalkPackage) card.getSerPackage()).send(scene.getData(), card);
                    consumInfo.setType(scene.getType());
                    consumInfo.setCousumData(scene.getData());
                    addConsumInfo(number, consumInfo);
                }
            } else if (card.getSerPackage() instanceof NetPackage) {
                if (scene.getType().equals("通话") || scene.getType().equals("短信")) {
                    continue;
                }
                System.out.println(scene.getDescription());
                ((NetPackage) card.getSerPackage()).netPlay(scene.getData(), card);
                consumInfo.setType(scene.getType());
                consumInfo.setCousumData(scene.getData());
                addConsumInfo(number, consumInfo);
            } else {
                if (scene.getType().equals("上网")) {
                    System.out.println(scene.getDescription());
                    ((SuperPackage) card.getSerPackage()).netPlay(scene.getData(), card);
                    consumInfo.setType(scene.getType());
                    consumInfo.setCousumData(scene.getData());
                    addConsumInfo(number, consumInfo);
                } else if (scene.getType().equals("通话")) {
                    System.out.println(scene.getDescription());
                    ((SuperPackage) card.getSerPackage()).call(scene.getData(), card);
                    consumInfo.setType(scene.getType());
                    consumInfo.setCousumData(scene.getData());
                    addConsumInfo(number, consumInfo);
                } else if (scene.getType().equals("短信")) {
                    System.out.println(scene.getDescription());
                    ((SuperPackage) card.getSerPackage()).send(scene.getData(), card);
                    consumInfo.setType(scene.getType());
                    consumInfo.setCousumData(scene.getData());
                    addConsumInfo(number, consumInfo);
                }
            }
            break;
        }while (true);
        cards.put(number, card);
    }

    /**
     * 打印消费说明
     * 需要从"资费说明.txt"文件中读取数据并打印出来
     */
    public void showDescription() {
        File file = new File("资费说明");
        Reader reader = null;
        BufferedReader bufferedReader = null;
        try {
            reader = new FileReader(file);
            bufferedReader = new BufferedReader(reader);
            String data = bufferedReader.readLine();
            while (data != null) {
                System.out.println(data);
                data = bufferedReader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 更改套餐
     *
     * @param number
     * @param
     */
    public void changeingPack(String number, String packNumber) throws Exception {
        MobileCard card = cards.get(number);
        switch (Integer.parseInt(packNumber)) {
            case 1:
                if (card.getSerPackage() instanceof TalkPackage) {
                    throw new Exception("对不起,你已是该套餐用户,无需更改!");
                }
                TalkPackage talkPackage = new TalkPackage();
                if (card.getMoney() < talkPackage.getPrice()) {
                    throw new Exception("对不起,你的余额不足以支付新套餐本月资费,请充值后在办理更换套餐业务");
                }
                card.setSerPackage(talkPackage);
                break;
            case 2:
                if (card.getSerPackage() instanceof NetPackage) {
                    throw new Exception("对不起,你已是该套餐用户,无需更改!");
                }
                NetPackage netPackage = new NetPackage();
                if (card.getMoney() < netPackage.getPrice()) {
                    throw new Exception("对不起,你的余额不足以支付新套餐本月资费,请充值后在办理更换套餐业务");
                }
                card.setSerPackage(netPackage);
                break;
            case 3:
                if (card.getSerPackage() instanceof SuperPackage) {
                    throw new Exception("对不起,你已是该套餐用户,无需更改!");
                }
                SuperPackage superPackage = new SuperPackage();
                if (card.getMoney() < superPackage.getPrice()) {
                    throw new Exception("对不起,你的余额不足以支付新套餐本月资费,请充值后在办理更换套餐业务");
                }
                card.setSerPackage(superPackage);
                break;
        }
        card.setMoney(card.getMoney() - card.getSerPackage().getPrice());
        card.setRealFlow(0);
        card.setRealSMSCount(0);
        card.setRealTalkTime(0);
        cards.put(number, card);
    }

    /**
     * 打印消费记录
     *
     * @param number
     */
    public void showConsumInfo(String number) {
        Writer writer = null;
        BufferedWriter bufferedWriter = null;
        try {
            if (!consumInfos.containsKey(number)) {
                System.out.println("没有消费记录!");
                return;
            }
            List<ConsumInfo> consumInfoList = consumInfos.get(number);
            writer = new FileWriter(number + "消费清单.txt");
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("*******" + number + "消费记录*******\n");

            bufferedWriter.write("序号\t类型\t数据(通话(条)/上网(MB)/短信(条))\n");
            for (int i = 0; i < consumInfoList.size(); i++) {
                bufferedWriter.write(i + 1 + "\t" + consumInfoList.get(i).getType() + "\t"
                        + consumInfoList.get(i).getCousumData() + "\n");
            }
            bufferedWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 充值
     *
     * @param number 充值的手机号码
     * @param money  充值金额
     */
    public double changeMoney(String number, double money) throws Exception {
        if (!isExistCard(number)) {
            throw new Exception("'该号卡不存在");
        }
        MobileCard card = cards.get(number);
        card.setMoney(card.getMoney() + money);
        cards.put(number, card);
        return card.getMoney();
    }


}
