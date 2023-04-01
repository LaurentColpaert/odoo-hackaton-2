package database;

import model.Capsule;
import model.Experience;
import model.Person;

import java.sql.*;
import java.util.ArrayList;

public class Request {
    public static ArrayList<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList<>();

        String query = "select id_person, name, age, gender, country from person";
        try (Statement stmt = DatabaseConnection.getInstance().getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id_person");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                int gender = rs.getInt("gender");
                String country = rs.getString("country");
                ArrayList<Capsule> capsules = getCapsules(id);
                ArrayList<String> languages = getLanguages(id);
                persons.add(new Person(id,name,age,gender,country,languages,capsules));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return persons;
    }

    private static ArrayList<String> getLanguages(int id) {
        ArrayList<String> languages = new ArrayList<>();

        String query = "select language.language" +
                " from language,language_person, person " +
                " where person.id_person = ? and language_person.id_person == person.id_person and " +
                "language.id_language == language_person.id_language ";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                languages.add(rs.getString("language"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return languages;
    }


    private static ArrayList<Capsule> getCapsules(int id) {
        ArrayList<Capsule> capsules = new ArrayList<>();

        String query = "select capsule.id_capsule, capsule.date_begin, capsule.date_end" +
                " from capsule, person " +
                " where person.id_person = ? and capsule.id_person == person.id_person";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_capsule = rs.getInt("id_capsule");
                String date_begin = rs.getString("date_begin");
                String date_end = rs.getString("date_end");
                ArrayList<Experience> experiences = getExperiences(id_capsule);
                capsules.add(new Capsule(id_capsule,date_begin,date_end,experiences));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return capsules;
    }

    private static ArrayList<Experience> getExperiences(int id_capsule) {
        ArrayList<Experience> experiences = new ArrayList<>();

        String query = "select experience.id_experience, experience.date, experience.place" +
                " from experience, capsule " +
                " where capsule.id_capsule = ? and capsule.id_capsule == experience.id_capsule";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1,id_capsule);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id_experience = rs.getInt("id_experience");
                String date = rs.getString("date");
                String place = rs.getString("place");
                ArrayList<String> tags = getTag(id_experience);
                experiences.add(new Experience(id_capsule,date,place,tags));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return experiences;
    }

    private static ArrayList<String> getTag(int id) {
        ArrayList<String> tags = new ArrayList<>();

        String query = "select tag.tag" +
                " from tag,tag_experience, experience " +
                " where experience.id_experience = ? and experience.id_experience == tag_experience.id_experience and " +
                "tag.id_tag == tag_experience.id_tag";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tags.add(rs.getString("tag"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }
    public static ArrayList<String> getTags() {
        ArrayList<String> tags = new ArrayList<>();
        String query = "select tag from tag";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tags.add(rs.getString("tag"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return tags;
    }

    public static void test() throws Exception{
        DatabaseMetaData metaData = DatabaseConnection.getInstance().getConnection().getMetaData();
        String[] types = {"TABLE"};
        //Retrieving the columns in the database
        ResultSet tables = metaData.getTables(null, null, "%", types);
        while (tables.next()) {
            System.out.println(tables.getString("TABLE_NAME"));
        }
    }

    public static void insertPerson( Person person) {
        String sql = "INSERT INTO person(name, age, gender, country) VALUES(?,?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, person.getName());
            pstmt.setInt(2, person.getAge());
            pstmt.setInt(3, person.getGender());
            pstmt.setString(4, person.getCountry());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertCapsule( int id_person, String date_begin,  String date_end) {
        String sql = "INSERT INTO personne(id_person, date_begin, date_end) VALUES(?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_person);
            pstmt.setString(2, date_begin);
            pstmt.setString(3, date_end);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertExperience( int id_capsule, String date,  String place) {
        String sql = "INSERT INTO personne(id_capsule, date, place) VALUES(?,?,?)";

        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_capsule);
            pstmt.setString(2, date);
            pstmt.setString(3, place);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Person getPerson(int i) {
        Person person = null;

        String query = "select id_person, name, age, gender, country from person where id_person == ?";
        try (PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(query)) {
            stmt.setInt(1,i);
            ResultSet rs = stmt.executeQuery();
            int id = rs.getInt("id_person");
            String name = rs.getString("name");
            int age = rs.getInt("age");
            int gender = rs.getInt("gender");
            String country = rs.getString("country");
            ArrayList<Capsule> capsules = getCapsules(id);
            ArrayList<String> languages = getLanguages(id);
            person = new Person(id,name,age,gender,country,languages,capsules);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
}
