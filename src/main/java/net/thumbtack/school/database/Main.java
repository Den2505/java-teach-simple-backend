package net.thumbtack.school.database;

import net.thumbtack.school.database.jdbc.JdbcService;
import net.thumbtack.school.database.model.Group;
import net.thumbtack.school.database.model.School;
import net.thumbtack.school.database.model.Trainee;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        JdbcService jdbcService = new JdbcService();
        try {
            School school = new School("TTSchool", 2018);
            JdbcService.insertSchool(school);
            School schoolFromDBByColNames = JdbcService.getSchoolByIdUsingColNames(school.getId());
            Group groupFrontEnd = new Group("Frontend", "11");
            Group groupBackEnd = new Group("Backend", "12");
            JdbcService.insertGroup(school, groupFrontEnd);
            JdbcService.insertGroup(school, groupBackEnd);
            List<Group> groups = new ArrayList<>();
            groups.add(groupFrontEnd);
            groups.add(groupBackEnd);
            school.setGroups(groups);
            School schoolFromDBWithGroups = JdbcService.getSchoolByIdWithGroups(school.getId());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
