package model;

import java.util.ArrayList;

public class Experience {
    private int id_experience;
    private String date;
    private String place;
    private ArrayList<String> tags;

    public Experience(int id_experience, String date, String place, ArrayList<String> tags) {
        this.id_experience = id_experience;
        this.date = date;
        this.place = place;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Experience{" +
                "id_experience=" + id_experience +
                ", date='" + date + '\'' +
                ", place='" + place + '\'' +
                ", tags=" + tags +
                '}';
    }

    public int getId_experience() {
        return id_experience;
    }

    public void setId_experience(int id_experience) {
        this.id_experience = id_experience;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
