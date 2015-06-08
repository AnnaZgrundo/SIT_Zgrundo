/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

import by.bsuir.course.Zgrundo.bean.Dish;
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
public class DishDAO {

    public static final String SELECT_ALL_DISHES = "SELECT dish.IDDish, "
            + "dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, "
            + "dishtype.IDDishType, dishtype.Type, user.IDUser, user.Name, "
            + "dish.Picture, dish.Status, dish.Time "
            + "FROM dish INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType "
            + "INNER JOIN user ON dish.UserAdd=user.IDUser";
    
    public static final String SELECT_DISHES_BY_ID = "SELECT dish.IDDish, "
            + "dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, "
            + "dishtype.IDDishType, dishtype.Type, user.IDUser, user.Name, "
            + "dish.Picture, dish.Status, dish.Time "
            + "FROM dish INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType "
            + "INNER JOIN user ON dish.UserAdd=user.IDUser "
            + "WHERE IDDish = ?";

    public static final String SELECT_DISHES_BY_USER = "SELECT dish.IDDish, "
            + "dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, "
            + "dishtype.IDDishType, dishtype.Type, user.IDUser, user.Name, "
            + "dish.Picture, dish.Status, dish.Time "
            + "FROM dish INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType "
            + "INNER JOIN user ON dish.UserAdd=user.IDUser "
            + "WHERE UserAdd = ?";

    public static final String SELECT_DISHES_BY_TYPE = "SELECT dish.IDDish, "
            + "dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, "
            + "dishtype.IDDishType, dishtype.Type, user.IDUser, user.Name, "
            + "dish.Picture, dish.Status, dish.Time "
            + "FROM dish INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType "
            + "INNER JOIN user ON dish.UserAdd=user.IDUser "
            + "WHERE Dishtype = ?";

    public static final String INSERT_DISH = "INSERT INTO dish "
            + "(IDDish, Name, Cost, Kkal, CookingMethod, Dishtype, User, Picture, Status, Time) "
            + " VALUES (?,?,?,?,?,?,?,?,?,?)";

    public static final String UPDATE_DISH = "UPDATE dish SET Name=?, Cost=?,"
            + " Kkal=?, CookingMethod=?, Type=?, User=?, Picture=?, Status=?, Time=?";

    public static final String DELETE_DISH_BY_ID = "DELETE FROM dish WHERE IDDish = ? ";

    public static final String COUNT_COST = "select sum(t.cost) as sum_cost from "
            + "(select (ingredient.Cost * t1.weight) as cost, t1.IDIngredient"
            + " from (select weight,IDIngredient from dish_ingredient"
            + " where dish_ingredient.IDDish = 1 ) t1,"
            + " Ingredient\n"
            + " where t1.IDIngredient = Ingredient.IDIngredient) t";

    private Connection connection;

    public DishDAO() {
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Dish> readAll() {
        
        ArrayList<Dish> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_DISHES);
            list = new ArrayList<>();

            while (rs.next()) {
                DishType type = new DishType();
                type.setIdDishType(rs.getInt("IDDishType"));
                type.setType(rs.getString("Type"));

                Dish dish = new Dish();
                dish.setIdDish(rs.getInt("IDDish"));
                dish.setName(rs.getString("Name"));
                dish.setCost(rs.getInt("Cost"));
                dish.setKkal(rs.getInt("Kkal"));
                dish.setCookingMethod(rs.getString("CookingMethod"));
                dish.setType(type);
                dish.setUserAddID(rs.getInt("IDUser"));
                dish.setUserAddName(rs.getString("Name"));
                dish.setPicture(rs.getString("Picture"));

                list.add(dish);
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }

    public Dish readByID(int idDish) {
        Dish dish = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_DISHES_BY_ID);
            ps.setInt(1, idDish);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                DishType type = new DishType();
                type.setIdDishType(rs.getInt("IDDishType"));
                type.setType(rs.getString("Type"));

                dish = new Dish();
                dish.setIdDish(rs.getInt("IDDish"));
                dish.setName(rs.getString("Name"));
                dish.setCost(rs.getInt("Cost"));
                dish.setKkal(rs.getInt("Kkal"));
                dish.setCookingMethod(rs.getString("CookingMethod"));
                dish.setType(type);
                dish.setUserAddID(rs.getInt("IDUser"));
                dish.setUserAddName(rs.getString("Name"));
                dish.setPicture(rs.getString("Picture"));

            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return dish;
    }

    public ArrayList<Dish> readByUser(int idUser) {
        ArrayList<Dish> list = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_DISHES_BY_USER);
            ps.setInt(1, idUser);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                DishType type = new DishType();
                type.setIdDishType(rs.getInt("IDDishType"));
                type.setType(rs.getString("Type"));

                Dish dish = new Dish();
                dish.setIdDish(rs.getInt("IDDish"));
                dish.setName(rs.getString("Name"));
                dish.setCost(rs.getInt("Cost"));
                dish.setKkal(rs.getInt("Kkal"));
                dish.setCookingMethod(rs.getString("CookingMethod"));
                dish.setType(type);
                dish.setUserAddID(rs.getInt("IDUser"));
                dish.setUserAddName(rs.getString("Name"));
                dish.setPicture(rs.getString("Picture"));

                list.add(dish);
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }

    public ArrayList<Dish> readByType(int idType) {
        ArrayList<Dish> list = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_DISHES_BY_TYPE);
            ps.setInt(1, idType);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();

            while (rs.next()) {
                DishType type = new DishType();
                type.setIdDishType(rs.getInt("IDDishType"));
                type.setType(rs.getString("Type"));

                Dish dish = new Dish();
                dish.setIdDish(rs.getInt("IDDish"));
                dish.setName(rs.getString("Name"));
                dish.setCost(rs.getInt("Cost"));
                dish.setKkal(rs.getInt("Kkal"));
                dish.setCookingMethod(rs.getString("CookingMethod"));
                dish.setType(type);
                dish.setUserAddID(rs.getInt("IDUser"));
                dish.setUserAddName(rs.getString("Name"));
                dish.setPicture(rs.getString("Picture"));

                list.add(dish);
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }

    public int create(Dish dish) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(INSERT_DISH);
            ps.setString(1, dish.getName());
            ps.setInt(2, dish.getCost());
            ps.setInt(3, dish.getKkal());
            ps.setString(4, dish.getCookingMethod());
            ps.setInt(5, dish.getType().getIdDishType());
            ps.setInt(6, dish.getUserAddID());
            ps.setString(6, dish.getUserAddName());
            ps.setString(7, dish.getUserAddName());
            ps.setString(8, dish.getPicture());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_DISH_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

    public int update(Dish dish) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE_DISH);
            ps.setString(1, dish.getName());
            ps.setInt(2, dish.getCost());
            ps.setInt(3, dish.getKkal());
            ps.setString(4, dish.getCookingMethod());
            ps.setInt(5, dish.getType().getIdDishType());
            ps.setInt(6, dish.getUserAddID());
            ps.setString(7, dish.getPicture());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }
    ///////////////////////////////
    public int getCost(int id) {
        int cost = 0;
        try {
            Statement st = null;
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(COUNT_COST);
            cost = rs.getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(DishDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }

}