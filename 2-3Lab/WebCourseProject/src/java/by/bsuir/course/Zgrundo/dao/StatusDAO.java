/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

import by.bsuir.course.Zgrundo.bean.Status;
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
public class StatusDAO {
    
    public final static String SELECT_ALL_STATUS
            = "SELECT IDStatus, Status FROM status ";
    public final static String SELECT_STATUS_BY_ID
            = "SELECT IDStatus, Status FROM status WHERE IDStatus = ?";
    public final static String SELECT_STATUS_BY_NAME
            = "SELECT IDStatus, Status FROM status WHERE Status = ?";
    public static String INSERT_STATUS = "INSERT INTO status "
            + "(Status) VALUES (?) ";
    public static String UPDATE_STATUS = "UPDATE status SET Status=? ";
    public final static String DELETE_STATUS_BY_ID
            = "DELETE FROM status WHERE IDStatus = ? ";

    private Connection connection;
    
    
    public StatusDAO() {
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Status> readAll() {
        ArrayList<Status> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_STATUS);

            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Status(rs.getInt("IDStatus"), rs.getString("Status")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public Status readByID(int id) {
        Status type = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_STATUS_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                type = new Status(rs.getInt("IDStatus"), rs.getString("Status"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return type;
    }
    
    public Status readByStatus(String name) {
        Status type = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_STATUS_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                type = new Status(rs.getInt("IDStatus"), rs.getString("Status"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return type;
    }
    
    public int create(Status type) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            if (new StatusDAO().readByStatus(type.getStatus()) != null) {
                ConnectionPool.getConnectionPool().setConnection(connection);
                return -1;
            }
            ps = connection.prepareStatement(INSERT_STATUS);
            ps.setString(1, type.getStatus());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_STATUS_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int update(Status type) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE_STATUS);
            ps.setString(1, type.getStatus());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(StatusDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
}
