package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            cn = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
            try (Statement st = cn.createStatement()) {
                st.execute("create table if not exists items ("
                        + "id serial primary key,"
                        + "name text,"
                        + "created timestamp"
                        + ");");
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (cn != null) {
            cn.close();
        }
    }

    @Override
    public Item add(Item item) throws SQLException {
        String sql = "insert into items(name, created) values(?, ?)";
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setString(1, item.getName());
            prSt.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            prSt.execute();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) throws SQLException {
        String sql = "update items set name = ?, created = ? where id = ?";
        boolean rsl = false;
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setString(1, item.getName());
            prSt.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            prSt.setInt(3, id);
            rsl = prSt.executeUpdate() > 0;
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        String sql = "delete from items where id = ?";
        boolean rsl = false;
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setInt(1, id);
            rsl = prSt.executeUpdate() > 0;
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() throws SQLException {
        List<Item> rsl = new ArrayList<>();
        String sql = "select * from items";
        try (Statement st = cn.createStatement()) {
            ResultSet set = st.executeQuery(sql);
            while (set.next()) {
                rsl.add(new Item(set.getInt("id"), set.getString("name")));
            }
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) throws SQLException {
        List<Item> rsl = new ArrayList<>();
        String sql = "select * from items where name = ?";
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setString(1, key);
            ResultSet set = prSt.executeQuery();
            while (set.next()) {
                rsl.add(new Item(set.getInt("id"), set.getString("name")));
            }
        }
        return rsl;
    }

    @Override
    public Item findById(int id) throws SQLException {
        Item rsl = null;
        String sql = "select * from items where id = ?";
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setInt(1, id);
            ResultSet set = prSt.executeQuery();
            if (set.next()) {
                rsl = new Item(set.getInt("id"), set.getString("name"));
            }
        }
        return rsl;
    }
}
