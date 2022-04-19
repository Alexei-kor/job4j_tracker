package ru.job4j.tracker;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SqlTrackerTest {

    private static Connection connection;

    @BeforeClass
    public static void initConnection() {
        try (InputStream in = SqlTrackerTest.class.getClassLoader()
                .getResourceAsStream("test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterClass
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @After
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("delete from items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByNameThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item2");
        tracker.add(item);
        List<Item> expected = Arrays.asList(item);
        assertThat(tracker.findByName(item.getName()), is(expected));
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item2");
        tracker.add(item);
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenSaveItemAndReplaceNameAndFindByNewNameThenMustBeTheSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        item.setName("ItemNew");
        tracker.replace(item.getId(), item);
        List<Item> expected = Arrays.asList(item);
        assertThat(tracker.findByName(item.getName()), is(expected));
    }

    @Test
    public void whenSave2ItemAndSelectAllThenMustBe2Items() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        assertThat(tracker.findAll().size(), is(2));
    }

    @Test
    public void whenSaveTwoItemAndDeleteOneThenMustBeOneSame() throws SQLException {
        SqlTracker tracker = new SqlTracker(connection);
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
        tracker.add(item1);
        tracker.add(item2);
        tracker.delete(item1.getId());
        assertThat(tracker.findById(item2.getId()), is(item2));
    }

}