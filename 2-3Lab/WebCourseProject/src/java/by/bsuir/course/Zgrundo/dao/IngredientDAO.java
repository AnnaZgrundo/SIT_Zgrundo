/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

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
public class IngredientDAO {
    
    public final static String SELECT_ALL_INGREDIENTS
            = "SELECT IDIngredient, Ingredient, Cost, Kkal FROM ingredient ";
    public final static String SELECT_INGREDIENTS_BY_ID
            = "SELECT IDIngredient, Ingredient, Cost, Kkal FROM ingredient "
                + "WHERE IDIngredient = ?";
    public final static String SELECT_INGREDIENTS_BY_NAME
            = "SELECT IDIngredient, Ingredient, Cost, Kkal FROM ingredient "
                + "WHERE Ingredient = ?";
    public static String INSERT_INGREDIENT = "INSERT INTO ingredient "
            + "(Ingredient, Cost, Kkal) "
            + "VALUES (?,?,?) ";
    public static String UPDATE_INGREDIENT = "UPDATE ingredient SET Ingredient=?, Cost=?, Kkal=? ";
    public final static String DELETE_INGREDIENT_BY_ID
            = "DELETE FROM ingredient WHERE IDIngredient = ? ";

    private Connection connection;
    
    
    public IngredientDAO() {
        
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Ingredient> readAll() {
        ArrayList<Ingredient> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_INGREDIENTS);

            list = new ArrayList<>();
            while (rs.next()) {
                list.add(new Ingredient(rs.getInt("IDIngredient"), rs.getString("Ingredient"),
                        rs.getInt("Cost"), rs.getInt("Kkal")));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public Ingredient readByID(int id) {
        Ingredient ingredient = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_INGREDIENTS_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ingredient = new Ingredient(rs.getInt("IDIngredient"), rs.getString("Ingredient"),
                        rs.getInt("Cost"), rs.getInt("Kkal"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return ingredient;
    }
    
    public Ingredient readByIngr(String name) {
        Ingredient ingredient = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_INGREDIENTS_BY_NAME);
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ingredient = new Ingredient(rs.getInt("IDIngredient"), rs.getString("Ingredient"),
                        rs.getInt("Cost"), rs.getInt("Kkal"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return ingredient;
    }
    
    public int create(Ingredient ingredient) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            if (new IngredientDAO().readByIngr(ingredient.getIngredient()) != null) {
                ConnectionPool.getConnectionPool().setConnection(connection);
                return -1;
            }
            ps = connection.prepareStatement(INSERT_INGREDIENT);
            ps.setString(1, ingredient.getIngredient());
            ps.setInt(2, ingredient.getCost());
            ps.setInt(3, ingredient.getKkal());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_INGREDIENT_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
    public int update(Ingredient ingredient) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE_INGREDIENT);
            ps.setString(1, ingredient.getIngredient());
            ps.setInt(2, ingredient.getCost());
            ps.setInt(3, ingredient.getKkal());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(IngredientDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    
}
