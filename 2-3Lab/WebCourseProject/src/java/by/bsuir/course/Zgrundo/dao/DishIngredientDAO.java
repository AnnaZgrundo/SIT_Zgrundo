/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

import by.bsuir.course.Zgrundo.bean.DishIngredient;
import by.bsuir.course.Zgrundo.bean.Ingredient;
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
public class DishIngredientDAO {
    
    public final static String SELECT_ALL
            = "SELECT IDDish, IDIngredient, Weight FROM dish_ingredient ";
    public final static String SELECT_BY_DISH
            = "SELECT IDDish, IDIngredient, Weight FROM dish_ingredient "
            + "WHERE IDDish = ?";
    public final static String SELECT_BY_DISH_AND_INGR
            = "SELECT IDDish, IDIngredient, Weight FROM dish_ingredient "
            + "WHERE IDDish = ? AND IDIngredient = ?";
    public static String INSERT = "INSERT INTO dish_ingredient "
            + "(IDDish, IDIngredient, Weight) "
            + "VALUES (?,?,?) ";
    public static String UPDATE = "UPDATE dish_ingredient SET IDDish=?, IDIngredient=?, Weight=? ";
    public final static String DELETE_BY_ID
            = "DELETE FROM dish_ingredient WHERE IDDish = ? ";
    
    private Connection connection;
    
    public DishIngredientDAO() {
        
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<DishIngredient> readAll() {
        ArrayList<DishIngredient> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL);
            
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new DishIngredient(rs.getInt("IDDish"), rs.getInt("IDIngredient"),
                        rs.getInt("Weight")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public ArrayList<DishIngredient> readByDish(int idDish) {
        ArrayList<DishIngredient> list = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_BY_DISH);
            ps.setInt(1, idDish);
            ResultSet rs = ps.executeQuery();
            
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new DishIngredient(rs.getInt("IDDish"), rs.getInt("IDIngredient"),
                        rs.getInt("Weight")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public ArrayList<DishIngredient> readByDishAndIngr(int idDish, int idIngr) {
        ArrayList<DishIngredient> list = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_BY_DISH_AND_INGR);
            ps.setInt(1, idDish);
            ps.setInt(2, idIngr);
            ResultSet rs = ps.executeQuery();
            
            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new DishIngredient(rs.getInt("IDDish"), rs.getInt("IDIngredient"),
                        rs.getInt("Weight")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public int create(DishIngredient dishIngredient) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            if (new DishIngredientDAO().readByDishAndIngr(dishIngredient.getIdDish(), dishIngredient.getIdIngredient()) != null) {
                ConnectionPool.getConnectionPool().setConnection(connection);
                return -1;
            }
            ps = connection.prepareStatement(INSERT);
            ps.setInt(1, dishIngredient.getIdDish());
            ps.setInt(2, dishIngredient.getIdIngredient());
            ps.setInt(3, dishIngredient.getWeight());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int update(DishIngredient dishIngredient) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE);
            ps.setInt(1, dishIngredient.getIdDish());
            ps.setInt(2, dishIngredient.getIdIngredient());
            ps.setInt(3, dishIngredient.getWeight());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishIngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
}
