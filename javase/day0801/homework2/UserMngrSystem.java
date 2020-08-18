package com.javase.day0801.homework2;

import com.tools.InputUtil;

import java.util.ArrayList;

public class UserMngrSystem {
    /**
     * 管理员
     */
    Administrator administrator = new Administrator("admin", "123");
    /**
     * 用户
     */
    ArrayList<User> userArrayList = new ArrayList<>(0);

    /**
     * 删除用户
     *
     * @param user
     * @return
     */
    public boolean delUser(User user) {
        if (user == null) {
            return false;
        }
        userArrayList.remove(user);
        return true;
    }

    /**
     * 删除用户界面
     */
    public void delView() {
        System.out.println("****************管理员删除个人信息*****************");
        String id = InputUtil.inputStr("请输入删除用户个人id");
        User user = findUser(id);
        if (!delUser(user)) {
            System.out.println("不存在该用户");
            System.out.println("返回上一层..");
            operationView();
        }
        System.out.println("用户删除成功!");
        int again = -1;
        do {
            again = InputUtil.inputInt("请输入你要操作的功能(按0返回上一层)");
        } while (again != 0);
        operationView();
    }

    /**
     * 添加用户,不存在或id冲突返回null
     *
     * @param user
     * @return
     */
    public User add(User user) {
        for (User user1 : userArrayList) {
            if (user1.getId().equals(user.getId())) {
                return null;
            }
        }
        userArrayList.add(user);
        return user;
    }

    /**
     * 添加用户界面
     */
    public void addView() {
        System.out.println("****************管理员添加的个人信息*****************");
        String id = InputUtil.inputStr("请输入添加用户个人id");
        String name = InputUtil.inputStr("请输入添加的用户名");
        int age = InputUtil.inputInt("请输入添加的年龄");
        String addr = InputUtil.inputStr("请输入添加的地址(省市县区用','分隔)");
        String[] addrArr = new String[3];
        addrArr = addr.split(",");
        Address address = new Address(addrArr[0], addrArr[1], addrArr[2]);
        String tel = InputUtil.inputStr("请输入电话号码");
        User user = new User(id, name, age, address, tel);
        User user1 = add(user);
        if (user1 == null) {
            System.out.println("已存在该用户或id冲突");
            System.out.println("返回上一层...");
            operationView();
        }
        System.out.println("****************用户添加成功显示信息如下*****************");
        System.out.println("用户ID\t用户名\t年龄\t地址\t\t\t\t电话");
        System.out.println(user1.toString());
        int again = -1;
        do {
            again = InputUtil.inputInt("请输入你要操作的功能(按0返回上一层)");
        } while (again != 0);
        operationView();
    }

    /**
     * 修改页面界面
     *
     * @param id
     */
    public void modifyUserView(String id) {
        System.out.println("****************管理员修改任何人的个人信息*****************");
        String name = InputUtil.inputStr("请输入修改的用户名");
        int age = InputUtil.inputInt("请输入修改的年龄");
        String addr = InputUtil.inputStr("请输入地址(省市县区用','分隔)");
        String[] addrArr = new String[3];
        addrArr = addr.split(",");
        Address address = new Address(addrArr[0], addrArr[1], addrArr[2]);
        String tel = InputUtil.inputStr("请输入电话号码");
        User user = modifyUser(id, name, age, address, tel);
        System.out.println("****************用户修改成功显示信息如下*****************");
        System.out.println("用户ID\t用户名\t年龄\t地址\t\t\t\t电话");
        System.out.println(user.toString());
        int again = -1;
        do {
            again = InputUtil.inputInt("请输入你要操作的功能(按0返回上一层)");
        } while (again != 0);
        operationView();
    }

    /**
     * 根据ID修改用户信息
     *
     * @param
     * @return
     */
    public User modifyUser(String id, String name, int age, Address address, String tel) {
        int i;
        User user = null;
        for (i = 0; i < userArrayList.size(); i++) {
            if (userArrayList.get(i).getId().equals(id)) {
                userArrayList.get(i).setName(name);
                userArrayList.get(i).setAge(age);
                userArrayList.get(i).setAddress(address);
                userArrayList.get(i).setTel(tel);
                user = userArrayList.get(i);
                break;
            }
        }
        return user;
    }

    /**
     * 按id查找用户界面
     *
     * @param user
     */
    public void findUserByIdView(User user) {
        System.out.println("**************管理员按id查看用户信息**************");
        if (user == null) {
            System.out.println("不存在该用户!");
        } else {
            System.out.println(user.toString());
        }
        System.out.println("**********************************************");
        int again = -1;
        do {
            again = InputUtil.inputInt("请输入你的操作(0返回上级操作)");
        } while (again != 0);
        findView();
    }

    /**
     * 按id查找用户
     *
     * @param id
     * @return
     */
    public User findUser(String id) {
        if (userArrayList.size() == 0) {
            return null;
        }
        for (User user : userArrayList) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    /**
     * 查看全部用户界面
     *
     * @param list
     */
    public void findUserView(ArrayList<User> list) {
        System.out.println("**************管理员查看全部用户信息**************");
        if (list == null) {
            System.out.println("没有用户");
        } else {
            System.out.println("用户ID\t用户名\t年龄\t地址\t\t\t\t电话");
            for (User user : list) {
                System.out.println(user.toString());
            }
        }
        System.out.println("**********************************************");
        int again = -1;
        do {
            again = InputUtil.inputInt("请输入你的操作(0返回上级操作)");
        } while (again != 0);
        findView();
    }

    /**
     * 查找全部用户
     *
     * @return 没有用户返回null
     */
    public ArrayList<User> findUser() {
        if (userArrayList.size() == 0) {
            return null;
        }
        return this.userArrayList;
    }

    /**
     * 管理员查找界面
     */
    public void findView() {
        System.out.println("****************管理员查看用户功能****************");
        System.out.println("\t\t\t\t1.查看全部用户");
        System.out.println("\t\t\t\t2.按id查看用户信息");
        System.out.println("\t\t\t\t3.退出系统");
        System.out.println("***********************************************");
        int num = InputUtil.inputInt("请输入你操作的功能");
        switch (num) {
            case 1:
                ArrayList<User> list = findUser();
                findUserView(list);
                break;
            case 2:
                String id = InputUtil.inputStr("请输入你要查找的ID");
                User user = findUser(id);
                findUserByIdView(user);
                break;
            case 3:
                operationView();
                break;
        }
    }

    /**
     * 管理员操作界面
     */
    public void operationView() {
        System.out.println("****************管理员用户操作功能****************");
        System.out.println("\t\t\t\t1.查看用户信息");
        System.out.println("\t\t\t\t1.修改用户信息");
        System.out.println("\t\t\t\t1.添加用户信息");
        System.out.println("\t\t\t\t1.删除用户信息");
        System.out.println("***********************************************");
        int num = InputUtil.inputInt("请输入你操作的功能");
        switch (num) {
            case 1:
                findView();
                break;
            case 2:
                String id;
                do {
                    id = InputUtil.inputStr("请输入你要修改用户的id");
                    User user = findUser(id);
                    if (user == null) {
                        System.out.println("没有该用户");
                        continue;
                    }
                    break;
                } while (true);
                modifyUserView(id);
                break;
            case 3:
                addView();
                break;
            case 4:
                delView();
                break;
        }
    }

    /**
     * 登录
     *
     * @param userName
     * @param pwd
     * @return
     */
    public boolean login(String userName, String pwd) {
        if (administrator.getUserName().equals(userName) && administrator.getPwd().equals(pwd)) {
            return true;
        }
        return false;
    }

    /**
     * 系统主界面
     */
    public void systemMainView() {
        System.out.println("***************欢迎使用用户管理系统****************");
        System.out.println("\t\t\t\t\t1.登录");
        System.out.println("\t\t\t\t\t2.退出");
        System.out.println("************************************************");
        int num = InputUtil.inputInt("请输入操作功能");
        switch (num) {
            case 1:
                int times = 0;
                do {
                    String userName = InputUtil.inputStr("请输入用户名");
                    String pwd = InputUtil.inputStr("请输入密码");
                    if (login(userName, pwd)) {
                        System.out.println("登录成功!");
                        break;
                    } else {
                        System.out.println("用户名或密码输入错误!");
                        ++times;
                    }
                } while (times < 3);
                if (times == 3) {
                    System.out.println("系统强制关闭...");
                    System.exit(0);
                }
                operationView();
                break;
            case 2:
                System.out.println("系统正在关闭...");
                System.exit(0);
                break;
        }
    }
}
