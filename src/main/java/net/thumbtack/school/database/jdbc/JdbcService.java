package net.thumbtack.school.database.jdbc;

import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Subject;
import net.thumbtack.school.database.model.Trainee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JdbcService {

    // Добавляет Trainee в базу данных.

    public static void insertTrainee(Trainee trainee) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `trainee`" +
                "(firstName,lastName,rating) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS)) {
            // preparedStatement.setInt(1, trainee.getId());
            preparedStatement.setString(1, trainee.getFirstName());
            preparedStatement.setString(2, trainee.getLastName());
            preparedStatement.setInt(3, trainee.getRating());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                trainee.setId(resultSet.getInt(1));
                resultSet.close();
            }
            resultSet.close();
        }
    }
    //Изменяет ранее записанный Trainee в базе данных. В случае ошибки выбрасывает SQLException.

    public static void updateTrainee(Trainee trainee) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "UPDATE `trainee` SET firstName = ?, lastName = ?, rating = ? where id = ?")) {
            preparedStatement.setString(1, trainee.getFirstName());
            preparedStatement.setString(2, trainee.getLastName());
            preparedStatement.setInt(3, trainee.getRating());
            preparedStatement.setInt(4, trainee.getId());
            preparedStatement.executeUpdate();
        }
    }

    private static Trainee getTraineeByResultSet(ResultSet set, String parameter) throws SQLException {
        Trainee trainee = new Trainee();
        if (parameter.equals("names")) {
            trainee.setId(set.getInt("id"));
            trainee.setFirstName(set.getString("firstName"));
            trainee.setLastName(set.getString("lastNAme"));
            trainee.setRating(set.getInt("rating"));
        }

        if (parameter.equals("numbers")) {
            trainee.setId(set.getInt(1));
            trainee.setFirstName(set.getString(2));
            trainee.setLastName(set.getString(3));
            trainee.setRating(set.getInt(4));
        }
        return trainee;
    }
    // Получает Trainee  из базы данных по его ID, используя метод получения “по именам полей”. Если Trainee с таким ID нет, возвращает null.

    public static Trainee getTraineeByIdUsingColNames(int traineeId) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from `trainee` where id = " + traineeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exist = resultSet.first();
        return exist ? getTraineeByResultSet(resultSet, "names") : null;
    }
    // Получает Trainee  из базы данных по его ID, используя метод получения “по номерам полей”. Если Trainee с таким ID нет, возвращает null.

    public static Trainee getTraineeByIdUsingColNumbers(int traineeId) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from `trainee` where id = " + traineeId);
        ResultSet resultSet = preparedStatement.executeQuery();
        boolean exist = resultSet.first();
        return exist ? getTraineeByResultSet(resultSet, "numbers") : null;
    }
    // Получает все Trainee  из базы данных, используя метод получения “по именам полей”. Если ни одного Trainee в БД нет,  возвращает пустой список.

    public static List<Trainee> getTraineesUsingColNames() throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from `trainee`");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Trainee> trainees = new ArrayList<>();
        while (resultSet.next()) {
            trainees.add(getTraineeByResultSet(resultSet, "names"));
        }
        resultSet.close();
        return trainees;
    }
    //  Получает все Trainee  из базы данных, используя метод получения “по номерам полей”. Если ни одного Trainee в БД нет,  возвращает пустой список.

    public static List<Trainee> getTraineesUsingColNumbers() throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("Select * from `trainee`");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Trainee> trainees = new ArrayList<>();
        while (resultSet.next()) {
            trainees.add(getTraineeByResultSet(resultSet, "numbers"));
        }
        return trainees;
    }

    // Удаляет Trainee из базы данных.

    public static void deleteTrainee(Trainee trainee) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM `trainee` where `id` =" + trainee.getId());
        preparedStatement.executeUpdate();
    }

    // Удаляет все Trainee из базы данных

    public static void deleteTrainees() throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `trainee`");
        preparedStatement.executeUpdate();

    }

    //  Добавляет Subject в базу данных

    public static void insertSubject(Subject subject) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `subject`(name) VALUES (?)", Statement.RETURN_GENERATED_KEYS)) {
            //preparedStatement.setInt(1, subject.getId());
            preparedStatement.setString(1, subject.getName());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next())
                subject.setId(resultSet.getInt(1));
            resultSet.close();
        }
    }

    private static Subject getSubjectFromResultSet(ResultSet resultSet, String parameter) throws SQLException {
        Subject subject = new Subject();
        if (parameter.equals("names")) {
            subject.setId(resultSet.getInt("id"));
            subject.setName(resultSet.getString("name"));
        }
        if (parameter.equals("numbers")) {
            subject.setId(resultSet.getInt(1));
            subject.setName(resultSet.getString(2));
        }
        resultSet.close();
        return subject;
    }

    //  Получает Subject  из базы данных по его ID, используя метод получения “по именам полей”. Если Subject с таким ID нет, возвращает null.

    public static Subject getSubjectByIdUsingColNames(int subjectId) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Select * from `subject` where id = " + subjectId)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exist = resultSet.first();
            return exist ? getSubjectFromResultSet(resultSet, "names") : null;
        }
    }

    //  Получает Subject  из базы данных по его ID, используя метод получения “по номерам полей”. Если Subject с таким ID нет, возвращает null.

    public static Subject getSubjectByIdUsingColNumbers(int subjectId) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "Select * from `subject` where id = " + subjectId)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exist = resultSet.first();
            return exist ? getSubjectFromResultSet(resultSet, "numbers") : null;
        }
    }

    // Удаляет все Subject из базы данных.

    public static void deleteSubjects() throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();

        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `subject`")) {
            preparedStatement.executeUpdate();
        }

    }

    // Добавляет School в базу данных

    public static void insertSchool(School school) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `school`(name,year) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);) {
            // preparedStatement.setInt(1, school.getId());
            preparedStatement.setString(1, school.getName());
            preparedStatement.setInt(2, school.getYear());
            preparedStatement.executeUpdate();
            for (Group elem : school.getGroups()) {
                insertGroup(school, elem);
            }
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next())
                school.setId(resultSet.getInt(1));
            resultSet.close();
        }
    }


    private static School getSchoolByResultSet(ResultSet resultSet, String parameter) throws SQLException {
        School school = new School();
        if (parameter.equals("names")) {
            school.setId(resultSet.getInt("id"));
            school.setName(resultSet.getString("name"));
            school.setYear(resultSet.getInt("year"));
            school.setGroups(Collections.emptyList());
        }
        if (parameter.equals("numbers")) {
            school.setId(resultSet.getInt(1));
            school.setName(resultSet.getString(2));
            school.setYear(resultSet.getInt(3));
            school.setGroups(Collections.emptyList());
        }
        resultSet.close();
        return school;
    }

    // Получает School  из базы данных по ее ID, используя метод получения “по именам полей”.
    // Если School с таким ID нет, возвращает null.

    public static School getSchoolByIdUsingColNames(int schoolId) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from `school` where `id` =" + schoolId)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exist = resultSet.first();
            return exist ? getSchoolByResultSet(resultSet, "names") : null;
        }

    }

    // Получает School  из базы данных по ее ID, используя метод получения “по номерам полей”.
    // Если School с таким ID нет, возвращает null.

    public static School getSchoolByIdUsingColNumbers(int schoolId) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from `school` where `id` =" + schoolId)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exist = resultSet.first();
            return exist ? getSchoolByResultSet(resultSet, "numbers") : null;
        }

    }

    public static void deleteSchools() throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `school`")) {
            preparedStatement.executeUpdate();
        }
    }

    // Добавляет Group в базу данных, устанавливая ее принадлежность к школе School.

    public static void insertGroup(School school, Group group) throws SQLException {
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO `group`(name,room,school_id) VALUES(?,?,?) ", Statement.RETURN_GENERATED_KEYS)) {
            //preparedStatement.setInt(1, group.getId());
            preparedStatement.setString(1, group.getName());
            preparedStatement.setString(2, group.getRoom());
            preparedStatement.setInt(3, school.getId());
            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next())
                group.setId(resultSet.getInt(1));
            resultSet.close();
        }
    }

    private static Group getGroupByResultSet(ResultSet resultSet) throws SQLException {
        Group group = new Group();
        group.setId(resultSet.getInt("id"));
        group.setName(resultSet.getString("name"));
        group.setRoom(resultSet.getString("room"));
        group.setTrainees(new ArrayList<>());
        group.setSubjects(new ArrayList<>());
        resultSet.close();
        return group;
    }

    private static List<Group> getGroupsBySchoolId(int schoolId) throws SQLException {
        List<Group> groups = new ArrayList<>();
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * from `group` where `school_id` = " + schoolId)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                groups.add(getGroupByResultSet(resultSet));
            }
        }
        return groups;
    }

    private static List<School> getSchoolAndGroupsByResultSet(ResultSet resultSet) throws SQLException {
        School school = new School();
        List<School> schools = new ArrayList<>();
        do {
            if (school.getId() != resultSet.getInt("id")) {
                school = new School();
                school.setId(resultSet.getInt("id"));
                school.setName(resultSet.getString("name"));
                school.setYear(resultSet.getInt("year"));
                schools.add(school);
            }
            Group group = new Group();
            group.setId(resultSet.getInt("group_id"));
            group.setName(resultSet.getString("group_name"));
            group.setRoom(resultSet.getString("room"));
            group.setSubjects(new ArrayList<>());
            group.setTrainees(new ArrayList<>());
            school.addGroup(group);
        } while (resultSet.next());
        resultSet.close();
        return schools;
    }

    // Получает School по ее ID вместе со всеми ее Group из базы данных.
    // Если School с таким ID нет, возвращает null.
    // Метод получения (по именам или номерам полей) - на Ваше усмотрение.

    public static School getSchoolByIdWithGroups(int id) throws SQLException {
        School school = new School();
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "select * from `school` left join " +
                        "(select `id` as `group_id`, `name` as `group_name`, `room`, `school_id` from `group`) " +
                        "as q ON school.id = q.school_id  where `id` = " + id)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exist = resultSet.first();
            return exist ? getSchoolAndGroupsByResultSet(resultSet).get(0) : null;
        }
    }

    //Получает список всех School вместе со всеми их Group из базы данных.
    // Если ни одной  School в БД нет,  возвращает пустой список.
    // Метод получения (по именам или номерам полей) - на Ваше усмотрение.

    public static List<School> getSchoolsWithGroups() throws SQLException {
        List<School> schools = new ArrayList<>();
        JdbcUtils.createConnection();
        Connection connection = JdbcUtils.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("select * from `school` left join " +
                "(select `id` as `group_id`, `name` as `group_name`, `room`, `school_id` from `group`) " +
                "as q ON school.id = q.school_id order by `id`")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            boolean exist = resultSet.first();
            return exist ? getSchoolAndGroupsByResultSet(resultSet) : schools;
        }
    }

}
