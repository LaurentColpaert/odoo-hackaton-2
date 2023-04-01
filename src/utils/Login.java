package utils;

import database.Request;
import model.Person;

public class Login {
    private static Login login;
    private Person person;
    private Login(Person person){this.person = person;}

    public Person getPerson(){
        return this.person;
    }

    public static Login getInstance(){
        if (login == null){
            login = new Login(Request.getPerson(1));
        }
        return login;
    }
}
