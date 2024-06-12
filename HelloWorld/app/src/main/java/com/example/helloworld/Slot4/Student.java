package com.example.helloworld.Slot4;

public class Student {
    private String name;
    private String age;
    private int avatar;

    public Student() {
    }

    public Student(String name, String age, int avatar) {
        this.name = name;
        this.age = age;
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}
