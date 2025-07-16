package com.example.dao;

import com.example.model.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/userdb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "yourpassword";

    private static final String INSERT_USER_SQL = "INSERT INTO users (name, email, country) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users;";
    private static final String SELECT_USER_BY_ID = "SELECT id, name, email, country FROM users WHERE id = ?";
    private static final String DELETE_USER_SQL = "DELETE FROM users WHERE id = ?;";
    private static final String UPDATE_USER_SQL = "UPDATE users SET name = ?, email= ?, country =? WHERE id = ?;";

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch(Exception e) { e.printStackTrace(); }
        return conn;
    }

    public void insertUser(User user) throws SQLException {
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(INSERT_USER_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.executeUpdate();
        }
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_ALL_USERS);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                users.add(new User(rs.getInt("id"), rs.getString("name"),
                                   rs.getString("email"), rs.getString("country")));
            }
        } catch(SQLException e) { e.printStackTrace(); }
        return users;
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(SELECT_USER_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(id, rs.getString("name"), rs.getString("email"), rs.getString("country"));
            }
        } catch(SQLException e) { e.printStackTrace(); }
        return user;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(UPDATE_USER_SQL)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            ps.setInt(4, user.getId());
            rowUpdated = ps.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(DELETE_USER_SQL)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
