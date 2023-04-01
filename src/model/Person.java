package model;

import java.util.ArrayList;

public class Person {
    private int id_person;
    private String name;
    private String age;
    private int gender;
    private String country;
    private ArrayList<String> languages;

    private ArrayList<Capsule> capsules;


    public Person(int id_person, String name, String age, int gender, String country, ArrayList<String> languages, ArrayList<Capsule> capsules) {
        this(id_person,name,age,gender,country,capsules);
        this.languages = languages;
    }

    public Person(int id_person, String name, String age, int gender, String country) {
        this.id_person = id_person;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.country = country;
    }

    public Person(int id, String name, String age, int gender, String country, ArrayList<Capsule> capsules) {
        this(id, name, age, gender, country);
        this.capsules = capsules;
    }

    public int getId_person() {
        return id_person;
    }

    public void setId_person(int id_person) {
        this.id_person = id_person;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id_person=" + id_person +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", languages=" + languages +
                ", capsules=" + capsules +
                '}';
    }

    public ArrayList<Capsule> getCapsules() {
        return capsules;
    }

    public void setCapsules(ArrayList<Capsule> capsules) {
        this.capsules = capsules;
    }
}
