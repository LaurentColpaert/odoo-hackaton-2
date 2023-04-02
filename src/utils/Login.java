package utils;

import database.Request;
import model.Capsule;
import model.Person;

public class Login {
    private static Login login;
    private Person person;
    private Capsule capsule;
    private Login(Person person){
        this.person = person;
        System.out.println(person.getCapsules());
        this.capsule = person.getCapsules().get(0);
        System.out.println(capsule.getId_capsule());
    }

    public Person getPerson(){
        return this.person;
    }

    public static Login getInstance(){
        if (login == null){
            login = new Login(Request.getPerson(1));
        }
        return login;
    }

    public Capsule getCapsule() {
        return capsule;
    }

    public void setCapsule(Capsule capsule) {
        this.capsule = capsule;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

}
