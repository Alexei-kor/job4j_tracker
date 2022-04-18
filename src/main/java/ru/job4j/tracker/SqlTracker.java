package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection cn;

    private static final Logger LOG = LoggerFactory.getLogger(SqlTracker.class.getName());

    public SqlTracker() {
    }

    public SqlTracker(Connection cn) {
        this.cn = cn;
    }

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
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
            } catch (SQLException e) {
                LOG.error("Error create table 'items'", e);
                throw new IllegalStateException(e);
            }
        } catch (Exception e) {
            LOG.error(String.format("Error IO when reading '%s'", "app.properties"), e);
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
    public Item add(Item item) {
        String sql = "insert into items(name, created) values(?, ?)";
        try (PreparedStatement prSt = cn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prSt.setString(1, item.getName());
            prSt.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            prSt.execute();
            ResultSet resultSet = prSt.getGeneratedKeys();
            if (resultSet.next()) {
                item.setId(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            LOG.error("Error adding values it table 'items'", e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        String sql = "update items set name = ?, created = ? where id = ?";
        boolean rsl = false;
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setString(1, item.getName());
            prSt.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            prSt.setInt(3, id);
            rsl = prSt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error("Error replacing values it table 'items'", e);
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from items where id = ?";
        boolean rsl = false;
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setInt(1, id);
            rsl = prSt.executeUpdate() > 0;
        } catch (SQLException e) {
            LOG.error("Error deleting values it table 'items'", e);
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        String sql = "select * from items";
        try (Statement st = cn.createStatement()) {
            ResultSet set = st.executeQuery(sql);
            while (set.next()) {
                rsl.add(getItemFromResultSet(set));
            }
        } catch (SQLException e) {
            LOG.error("Error selecting all values from table 'items'", e);
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        String sql = "select * from items where name = ?";
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setString(1, key);
            ResultSet set = prSt.executeQuery();
            while (set.next()) {
                rsl.add(getItemFromResultSet(set));
            }
        } catch (SQLException e) {
            LOG.error("Error finding value by name from table 'items'", e);
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        String sql = "select * from items where id = ?";
        try (PreparedStatement prSt = cn.prepareStatement(sql)) {
            prSt.setInt(1, id);
            ResultSet set = prSt.executeQuery();
            if (set.next()) {
                rsl = getItemFromResultSet(set);
            }
        } catch (SQLException e) {
            LOG.error("Error finding value by ID from table 'items'", e);
        }
        return rsl;
    }

    private Item getItemFromResultSet(ResultSet set) throws SQLException {
        return new Item(
                set.getInt("id"),
                set.getString("name"),
                set.getTimestamp("created").toLocalDateTime());
    }

}
