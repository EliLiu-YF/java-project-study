package com.javase.day0805;

import java.io.Serializable;

public class User implements Serializable {
    String id;

    String name;

    int score;

    public User(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}
