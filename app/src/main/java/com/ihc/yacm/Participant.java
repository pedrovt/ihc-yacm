package com.ihc.yacm;

public class Participant {

    // /------------\
    // | ATTRIBUTES |
    // \------------/
    private String name;
    private char sex;           // char but boolean, only M or F
    private Integer age = null;
    private String email = null;


    // /--------------\
    // | CONSTRUCTORS |
    // \--------------/
    public Participant (String name, char sex, int age, String email) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public Participant (String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public Participant (String name, char sex, String email) {
        this.name = name;
        this.sex = sex;
        this.email = email;
    }

    public Participant (String name, char sex) {
        this.name = name;
        this.sex = sex;
    }


    // /-----------\
    // | FUNCTIONS |
    // \-----------/
    public String getName()     { return this.name; }
    public char getSex()        { return this.sex;  }
    public Integer getAge()     { return this.age;  }
    public String getTags()     { return this.email; }

    public void setName(String name)    { this.name = name; }
    public void setSex(char sex)        { this.sex = sex; }
    public void setAge(int age)         { this.age = age; }
    public void setEmail(String email)  { this.email = email; }
}