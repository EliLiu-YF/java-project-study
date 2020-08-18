package com.javase.day0804;

import java.util.Objects;

public class User{

    private String id;

    public User(String id) {
        this.id = id;
    }

    public User() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(id, user.id);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    public static void main(String[] args) {
        User user1 = new User("01");
        User user2 = new User("01");
        System.out.println(user1.equals(1));
    }

}
