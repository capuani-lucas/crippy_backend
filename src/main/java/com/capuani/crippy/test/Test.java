package com.capuani.crippy.test;

public class Test {

    private long id;
    private String test;
    private int age;

    public Test (long id, String test, int age) {

        this.id = id;
        this.test = test;
        this.age = age;

    }


    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", test='" + test + '\'' +
                ", age=" + age +
                '}';
    }
}
