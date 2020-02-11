/*
 *
 * Author: Vadym Puiko
 *
 * Date: 17.02.2020
 *
 */
package com.sportwear.dao;

import com.sportwear.entity.Address;
import com.sportwear.entity.Brand;
import com.sportwear.connection.DatabaseConnect;
import com.sportwear.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BrandDao implements IGenericDao<Brand, Long> {
    private static Logger logger = Logger.getLogger(AddressDao.class.getName());
    private static final String SELECT_ALL_BRAND = "select * from brands";
    private static final String SELECT_BY_ID_BRAND = "select * from brands where id=?";
    private static final String INSERT_INTO_BRAND = "insert into brands (name) values (?)";
    private static final String UPDATE_BRAND = "update brands set name=? where id=?";
    private static final String DELETE_BRAND = "delete from brands where id=?";

    /**
     * @param brand
     */
    @Override
    public void create(Brand brand) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(INSERT_INTO_BRAND);
        ) {
            ps.setString(1, brand.getName());
            ps.executeUpdate();
        }catch (SQLException e) {
            Logger.getGlobal().info("Error BrandDao");
        }
    }

    /**
     * @return brand list
     */
    @Override
    public List<Brand> readAll() {
        List<Brand> brands = new ArrayList<>();
        try (
                Connection c = DatabaseConnect.getConnection();
                Statement st = c.createStatement();
                ResultSet rs = st.executeQuery(SELECT_ALL_BRAND);
        ) {
            while (rs.next()) {
                Brand brand = readOperation(rs);
                brands.add(brand);
            }
        }catch (SQLException e) {
            Logger.getGlobal().info("Error BrandDao");
        }
        return brands;
    }

    /**
     * @param id
     * @return brand
     */
    @Override
    public Brand readById(Long id) {
        Brand brand = null;
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(SELECT_BY_ID_BRAND);
        ) {
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                brand = readOperation(rs);
            }
        }catch (SQLException e) {
            logger.info("Error BrandDao");
        }
        return brand;
    }

    /**
     * @param brand
     * @param id
     */
    @Override
    public void update(Brand brand, Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(UPDATE_BRAND);
        ) {
            ps.setString(1, brand.getName());
            ps.setLong(2, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            logger.info("Error BrandDao");
        }
    }

    /**
     * @param id
     */
    @Override
    public void delete(Long id) {
        try (
                Connection c = DatabaseConnect.getConnection();
                PreparedStatement ps = c.prepareStatement(DELETE_BRAND);
        ) {
            ps.setLong(1, id);
            ps.executeUpdate();
        }catch (SQLException e) {
            logger.info("Error BrandDao");
        }
    }

    private Brand readOperation(ResultSet resultSet) {
        Brand brand = null;
        try {
            brand = new Brand();
            brand.setId(resultSet.getLong("id"));
            brand.setName(resultSet.getString("name"));
        }catch (SQLException e) {
            logger.info("Error BrandDao");
        }
        return brand;
    }
}
