package com.javase.day0803;

import java.util.Comparator;

public class UserComp implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        return o1.getId() - o2.getId();
    }
}
