/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.course.Zgrundo.dao;

import by.bsuir.course.Zgrundo.bean.Dish;
import by.bsuir.course.Zgrundo.bean.DishType;
import by.bsuir.course.Zgrundo.bean.Favourite;
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
public class FavouriteDAO {

    public static final String SELECT_ALL_FAVOURITES = "SELECT favourite.IDFavourite, dish.IDDish, "
            + " dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, dishtype.IDDishType, dishtype.Type,"
            + " user.IDUser, user.Name, dish.Picture, favourite.User "
            + " FROM favourite INNER JOIN dish ON favourite.Dish=dish.IDDish "
                           + " INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType"
                           + " INNER JOIN user ON dish.UserAdd=user.IDUser";

    public static final String SELECT_FAVOURITES_BY_ID = "SELECT favourite.IDFavourite, dish.IDDish, "
            + " dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, dishtype.IDDishType, dishtype.Type,"
            + " user.IDUser, user.Name, dish.Picture, favourite.User "
            + " FROM favourite INNER JOIN dish ON favourite.Dish=dish.IDDish "
                           + " INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType"
                           + " INNER JOIN user ON dish.UserAdd=user.IDUser"
                + " WHERE favourite.IDFavourite = ?";

    public static final String SELECT_FAVOURITES_BY_USER = "SELECT favourite.IDFavourite, dish.IDDish, "
            + " dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, dishtype.IDDishType, dishtype.Type,"
            + " user.IDUser, user.Name, dish.Picture, favourite.User "
            + " FROM favourite INNER JOIN dish ON favourite.Dish=dish.IDDish "
                           + " INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType "
                           + " INNER JOIN user ON dish.UserAdd=user.IDUser "
                + " WHERE favourite.User = ?";

    public static final String SELECT_FAVOURITES_BY_DISH_AND_USER = "SELECT favourite.IDFavourite, dish.IDDish, "
            + " dish.Name, dish.Cost, dish.Kkal, dish.CookingMethod, dishtype.IDDishType, dishtype.Type,"
            + " user.IDUser, user.Name, dish.Picture, favourite.User "
            + " FROM favourite INNER JOIN dish ON favourite.Dish=dish.IDDish "
                           + " INNER JOIN dishtype ON dish.Dishtype=dishtype.IDDishType"
                           + " INNER JOIN user ON dish.UserAdd=user.IDUser"
                + " WHERE favourite.Dish = ? AND favourite.User = ?";

    public static final String INSERT_FAVOURITE = "INSERT INTO favourite (Dish, User) VALUES (?,?) ";

    public static final String UPDATE_FAVOURITE = "UPDATE favourite SET Dish=?, Type=? ";

    public static final String DELETE_FAVOURITE_BY_ID = "DELETE FROM favourite WHERE IDFavourite = ? ";

    private Connection connection;

    public FavouriteDAO() {
        try {
            connection = ConnectionPool.getConnectionPool().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Favourite> read() {
        ArrayList<Favourite> list = null;
        Statement st = null;
        try {
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECT_ALL_FAVOURITES);
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
                dish.setUserAddName(rs.getString("user.Name"));
                dish.setPicture(rs.getString("Picture"));

                Favourite favourite = new Favourite();
                favourite.setIdFavourite(rs.getInt("IDFavourite"));
                favourite.setDish(dish);
                favourite.setIdUser(rs.getInt("User"));

                list.add(favourite);
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public Favourite readByID(int id) {
        Favourite favourite = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_FAVOURITES_BY_ID);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
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
                dish.setUserAddName(rs.getString("user.Name"));
                dish.setPicture(rs.getString("Picture"));

                favourite = new Favourite();
                favourite.setIdFavourite(rs.getInt("IDFavourite"));
                favourite.setDish(dish);
                favourite.setIdUser(rs.getInt("User"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return favourite;
    }

    public ArrayList<Favourite> readByUser(int idUser) {
        ArrayList<Favourite> list = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_FAVOURITES_BY_USER);
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
                dish.setUserAddName(rs.getString("user.Name"));
                dish.setPicture(rs.getString("Picture"));

                Favourite favourite = new Favourite();
                favourite.setIdFavourite(rs.getInt("IDFavourite"));
                favourite.setDish(dish);
                favourite.setIdUser(rs.getInt("User"));

                list.add(favourite);
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return list;
    }
    
    public Favourite readByDishAndUser(int idDish, int idUser) {
        Favourite favourite = null;
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(SELECT_FAVOURITES_BY_DISH_AND_USER);
            ps.setInt(1, idDish);
            ps.setInt(2, idUser);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
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
                dish.setUserAddName(rs.getString("user.Name"));
                dish.setPicture(rs.getString("Picture"));

                favourite = new Favourite();
                favourite.setIdFavourite(rs.getInt("IDFavourite"));
                favourite.setDish(dish);
                favourite.setIdUser(rs.getInt("User"));
            }
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return favourite;
    }

    public int create(Favourite favourite) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            if (new FavouriteDAO().readByDishAndUser(favourite.getDish().getIdDish(), favourite.getIdUser()) != null) {
                ConnectionPool.getConnectionPool().setConnection(connection);
                return -1;
            }
            ps = connection.prepareStatement(INSERT_FAVOURITE);
            ps.setInt(1, favourite.getDish().getIdDish());
            ps.setInt(2, favourite.getIdUser());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

    public int deleteByID(int id) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(DELETE_FAVOURITE_BY_ID);
            ps.setInt(1, id);
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

    public int update(Favourite favourite) {
        PreparedStatement ps = null;
        int count = 0;
        try {
            ps = connection.prepareStatement(UPDATE_FAVOURITE);
            ps.setInt(1, favourite.getDish().getIdDish());
            ps.setInt(2, favourite.getIdUser());
            count = ps.executeUpdate();
        } catch (SQLException ex) {
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            try {
                ConnectionPool.getConnectionPool().setConnection(connection);
            } catch (SQLException ex1) {
                Logger.getLogger(FavouriteDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return count;
    }

}
