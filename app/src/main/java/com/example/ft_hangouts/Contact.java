package com.example.ft_hangouts;

public class Contact {
    private int id;
    private String first_name;
    private String last_name;
    private String nickname;
    private String pseudo;
    private String phone_number;
    private int age;

    public Contact(){
        this.id = 0;
        this.first_name = "first_name";
        this.last_name = "last_name";
        this.nickname = "nickname";
        this.phone_number = "phone_number";
        this.age = 0;
    }
    public Contact(int i, String string, String cursorString, String s, String string1, String cursorString1, int parseInt)
    {
        this.id = 0;
        this.first_name = "first_name";
        this.last_name = "last_name";
        this.nickname = "nickname";
        this.phone_number = "phone_number";
        this.age = 0;
    }
    public Contact(int id, String first_name, String last_name, String nickname, String phone_number, int age)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.phone_number = phone_number;
        this.age = age;
    }
    public Contact(String first_name, String last_name, String nickname, String phone_number, int age)
    {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.nickname = nickname;
        this.phone_number = phone_number;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setAge(int age) {
        this.age = age;
    }
}