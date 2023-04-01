package model;

import java.util.ArrayList;

public class Capsule {
    private int id_capsule;
    private String date_begin;
    private String date_end;
    private ArrayList<Experience> experiences;

    public Capsule(int id_capsule, String date_begin, String date_end, ArrayList<Experience> experiences) {
        this.id_capsule = id_capsule;
        this.date_begin = date_begin;
        this.date_end = date_end;
        this.experiences = experiences;
    }

    public String getDate_begin() {
        return date_begin;
    }

    public void setDate_begin(String date_begin) {
        this.date_begin = date_begin;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    public ArrayList<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(ArrayList<Experience> experiences) {
        this.experiences = experiences;
    }

    @Override
    public String toString() {
        return "Capsule{" +
                "id_capsule=" + id_capsule +
                ", date_begin='" + date_begin + '\'' +
                ", date_end='" + date_end + '\'' +
                ", experiences=" + experiences +
                '}';
    }

    public int getId_capsule() {
        return id_capsule;
    }

    public void setId_capsule(int id_capsule) {
        this.id_capsule = id_capsule;
    }
}
