/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

import by.bsuir.course.Zgrundo.bean.User;
import by.bsuir.course.Zgrundo.connection.ConnectionPool;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ko
 */
public class UserDAO {

    public final static String SELECT_ALL_USERS
            = "SELECT IDUser, Login, Password, Name, Admin FROM user ";
    public final static String SELECT_USER_BY_LOGIN
            = "SELECT IDUser, Login, Password, Name, Admin FROM user WHERE Login = ? ";
    public static String INSERT_USER = "INSERT INTO user "
            + "(Login, Password, Name, Admin) "
            + "VALUES (?,?,?,?) ";
    public static String UPDATE_USER = "UPDATE user SET Login=?, Password=?, Name=? "
            + " WHERE IDUser = ?";
    public final static String DELETE_USER_BY_ID
            = "DELETE FROM user WHERE IDUser = ? ";

    private Connection connection;

    public UserDAO() {
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<User> readAll() {
        ArrayList<User> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_USERS);

            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new User(rs.getInt("IDUser"), rs.getString("Login"),
                        rs.getString("Password"), rs.getString("Name"), rs.getInt("Admin")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }

    public User readByLogin(String login) {
        PreparedStatement ps = null;
        User user = null;
        try {
            ps = connection.prepareStatement(SELECT_USER_BY_LOGIN);
            ps.setString(1, login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("IDUser"), rs.getString("Login"),
                        rs.getString("Password"), rs.getString("Name"), rs.getInt("Admin"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return user;
    }

    public int create(User user) {
        int count = 0;
        PreparedStatement ps = null;
        try {
            if (new UserDAO().readByLogin(user.getLogin()) != null) {
                ConnectionPool.getConnectionPool().setConnection(connection);
                return -1;
            }
            ps = connection.prepareStatement(INSERT_USER);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getAdmin());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_USER_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

    public int update(User user) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE_USER);
            ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getIdUser());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

}
