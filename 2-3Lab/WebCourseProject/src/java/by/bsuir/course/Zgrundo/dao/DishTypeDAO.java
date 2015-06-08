/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

import by.bsuir.course.Zgrundo.bean.DishType;
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
public class DishTypeDAO {
    
    public final static String SELECT_ALL_DISHTYPES
            = "SELECT IDDishType, Type FROM dishtype ";
    public final static String SELECT_DISHTYPES_BY_ID
            = "SELECT IDDishType, Type FROM dishtype WHERE IDDishType = ?";
    public final static String SELECT_DISHTYPES_BY_TYPE
            = "SELECT IDDishType, Type FROM dishtype WHERE Type = ?";
    public static String INSERT_DISHTYPE = "INSERT INTO dishtype "
            + "(Type) VALUES (?) ";
    public static String UPDATE_DISHTYPE = "UPDATE dishtype SET Type=? ";
    public final static String DELETE_DISHTYPE_BY_ID
            = "DELETE FROM dishtype WHERE IDDishType = ? ";

    private Connection connection;
    
    
    public DishTypeDAO() {
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<DishType> readAll() {
        ArrayList<DishType> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_DISHTYPES);

            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new DishType(rs.getInt("IDDishType"), rs.getString("Type")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public DishType readByID(int id) {
        DishType type = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_DISHTYPES_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                type = new DishType(rs.getInt("IDDishType"), rs.getString("Type"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return type;
    }
    
    public DishType readByType(String name) {
        DishType type = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_DISHTYPES_BY_TYPE);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                type = new DishType(rs.getInt("IDDishType"), rs.getString("Type"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return type;
    }
    
    public int create(DishType type) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            if (new DishTypeDAO().readByType(type.getType()) != null) {
                ConnectionPool.getConnectionPool().setConnection(connection);
                return -1;
            }
            ps = connection.prepareStatement(INSERT_DISHTYPE);
            ps.setString(1, type.getType());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_DISHTYPE_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int update(DishType type) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE_DISHTYPE);
            ps.setString(1, type.getType());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishTypeDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
}
