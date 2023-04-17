package com.example.diplomserver;

import com.example.diplomserver.Model.*;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class Handler {
    public static Connection getDbConnection() throws SQLException, IOException, ClassNotFoundException{
        Connection dbConnection;
        String connection = "jdbc:mysql://localhost:3306/diplom";
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connection,"root","root");
        return dbConnection;
    }

    public ArrayList show(String table) throws SQLException, IOException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<User>();
        ArrayList<Doctors> doctors = new ArrayList<Doctors>();

        Statement preparedSt = getDbConnection().createStatement();
        ResultSet set = preparedSt.executeQuery("SELECT * FROM " + table);
        switch (table) {
            case "users":{
                System.out.println("Вывод всех пользователей и администраторов.");
                while (set.next()){
                    User item = new User(set.getString(2),set.getString(3),
                            set.getString(4));
                    System.out.println(item);
                    users.add(item);
                }
                return users;
            }
            case "doctors":{
                while (set.next()){
                    Doctors item = new Doctors(set.getString(2), set.getString(3),set.getString(4),
                            set.getString(5),set.getString(6),set.getString(7),
                            set.getString(8),set.getString(9),set.getString(10));
                    System.out.println(item);
                    doctors.add(item);
                }
                return doctors;
            }
        }
        return null;
    }

    public void insertUser(User user) {
        try {
            Statement statement = getDbConnection().createStatement();
            statement.executeUpdate("INSERT INTO users(login, password, role)" + " VALUES('" + user.getLogin() +
                    "', '" + user.getPassword() + "', '" + user.getRole() + "');");
        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void delete(int idForDelete, String table) throws IOException {
        String delete = "DELETE FROM " + table + "\n" + "WHERE id = " + idForDelete;
        try {
            PreparedStatement preparedSt = getDbConnection().prepareStatement(delete);
            preparedSt.executeUpdate();

        } catch (SQLException | IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Boolean checkUser(String login) throws SQLException, IOException, ClassNotFoundException {
        Statement preparedSt = getDbConnection().createStatement();
        ResultSet set = preparedSt.executeQuery("SELECT * FROM users");
        Boolean flag = true;
        while (set.next()){
            if(Objects.equals(login, set.getString(2))){
                flag = false;
            }
        }
        return flag;
    }
    public static String findUser(String request) throws SQLException, IOException, ClassNotFoundException {
        Statement preparedSt = getDbConnection().createStatement();
        ResultSet set = preparedSt.executeQuery("SELECT * FROM users");
        String[] arr = request.split("=");
        String res = "Неверный логин или пароль!";

        while (set.next()){
            if(Objects.equals(arr[0], set.getString(2))){
                if(Objects.equals(arr[1], set.getString(3))){
                    switch (set.getString(4)){
                        case "admin":{
                            res = "Admin;" + set.getString(2);
                        }
                        case "doctor":{
                            res = "Doctor;" + set.getString(2);
                        }
                        case "user":{
                            res = "User;" + set.getString(2);
                        }
                    }
                }
            }
        }
        return res;
    }

    public void update(Basic basic, String table) throws SQLException, IOException, ClassNotFoundException {
        String updatePart1 = null;
        String updatePart2;
        String text1 = basic.getText1(), text2 = basic.getText2(), text3 = basic.getText3(),
                text4 = basic.getText4(), text5 = basic.getText5(),text6 = basic.getText6(),text7 = basic.getText7();

        switch (table){

            case "users" -> {
                User user = (User) showOneNote(basic.getId(), "users");

                if(Objects.equals(text1, "=")) text1 = user.getLogin();
                if(Objects.equals(text2, "=")) text2 = user.getPassword();
                if(Objects.equals(text3, "=")) text3 = user.getRole();

                updatePart2 = " SET " + "login = '" + text1 + "', password = " + text2 +
                        ", role = '" + text3 + "'";
                updatePart1 = "UPDATE " + table + updatePart2 + " WHERE id = " + basic.getId();

                System.out.println(updatePart1);
            }
            case "patient"->{

            }
        }
        PreparedStatement preparedSt = getDbConnection().prepareStatement(updatePart1);
        preparedSt.executeUpdate();
    }

    public Object showOneNote(int id, String table) throws SQLException, IOException, ClassNotFoundException {
        Statement preparedSt = getDbConnection().createStatement();
        ResultSet set = preparedSt.executeQuery("SELECT * FROM " + table + " WHERE id = " + id);

        switch (table){
            case "users" -> {
                System.out.println("Вывод пользователя на изменение.\n");
                User users = new User();
                while (set.next()){
                    users = new User(set.getString(2), set.getString(3),
                            set.getString(4));
                    System.out.println(users);
                }
                return users;
            }
        }
        return null;
    }
}
