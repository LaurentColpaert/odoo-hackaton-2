import database.Request;
import model.Person;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        Request.test();
        ArrayList<Person> persons = Request.getPersons();
        for (Person person : persons){
            System.out.println(person);
        }
    }
}