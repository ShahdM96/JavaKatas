package katas.exercises;

import org.junit.jupiter.api.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.Period;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ETLTaskTest {
    private static final String SOURCE_DB = "test_source.db";
    private static final String TARGET_DB = "test_target.db";

    @BeforeAll
    void setupDatabases() throws Exception {
        Files.deleteIfExists(Paths.get(SOURCE_DB));
        Files.deleteIfExists(Paths.get(TARGET_DB));

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + SOURCE_DB);
             Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE users (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "email TEXT NOT NULL, " +
                    "age INTEGER, " +
                    "registration_date TEXT)");

            stmt.execute("INSERT INTO users (id, name, email, age, registration_date) VALUES " +
                    "(1, 'Alice Johnson', 'alice.johnson@example.com', 45, '2010-05-15')," +
                    "(2, 'Bob Smith', 'bob.smith@example.com', 28, '2020-02-10')," +
                    "(3, 'Charlie Brown', 'charlie.b@example.com', 65, '1995-07-23')");
        }
    }

    @Test
    void testETLProcess() throws Exception {
        ETLTask.performETL(SOURCE_DB, TARGET_DB);

        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + TARGET_DB);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM transformed_users ORDER BY user_id")) {

            assertTrue(rs.next());
            assertEquals(1, rs.getInt("user_id"));
            assertEquals("Alice Johnson", rs.getString("full_name"));
            assertEquals("alice.johnson@example.com", rs.getString("email"));
            assertEquals("30-60", rs.getString("age_group"));
            assertEquals(Period.between(LocalDate.of(2010, 5, 15), LocalDate.now()).getYears(), rs.getInt("years_registered"));

            assertTrue(rs.next());
            assertEquals(2, rs.getInt("user_id"));
            assertEquals("Bob Smith", rs.getString("full_name"));
            assertEquals("bob.smith@example.com", rs.getString("email"));
            assertEquals("Under 30", rs.getString("age_group"));
            assertEquals(Period.between(LocalDate.of(2020, 2, 10), LocalDate.now()).getYears(), rs.getInt("years_registered"));

            assertTrue(rs.next());
            assertEquals(3, rs.getInt("user_id"));
            assertEquals("Charlie Brown", rs.getString("full_name"));
            assertEquals("charlie.b@example.com", rs.getString("email"));
            assertEquals("60+", rs.getString("age_group"));
            assertEquals(Period.between(LocalDate.of(1995, 7, 23), LocalDate.now()).getYears(), rs.getInt("years_registered"));

            assertFalse(rs.next());
        }
    }

    @AfterAll
    void cleanup() throws Exception {
        Files.deleteIfExists(Paths.get(SOURCE_DB));
        Files.deleteIfExists(Paths.get(TARGET_DB));
    }
}
