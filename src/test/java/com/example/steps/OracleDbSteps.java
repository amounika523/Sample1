package com.example.steps;// steps/DBStepDefinitions.java
import com.example.db.OracleDBUtil;
import io.cucumber.java.en.*;
import java.sql.*;

import static org.junit.Assert.*;

public class OracleDbSteps {
    private Connection conn;
    private ResultSet resultSet;

    @Given("the database is up")
    public void theDatabaseIsUp() throws SQLException {
        conn = OracleDBUtil.getConnection();
        assertNotNull(conn);
    }

    @When("I query the {string} table")
    public void iQueryTheTable(String tableName) throws SQLException {
        Statement stmt = conn.createStatement();
        resultSet = stmt.executeQuery("SELECT * FROM " + tableName + " FETCH FIRST 1 ROWS ONLY");
    }


    @When("I try to insert a record to the {string} table with {string} column as {string}")
    public void insert_into_table(String tablename, String columnname, String datavalue) throws SQLException {
        String sql = "INSERT INTO " + tablename + " (" + columnname + ") VALUES (?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, datavalue);  // or setInt / setDate etc., depending on the data type
            pstmt.executeUpdate();
        }
    }

    @Then ("I should see at least 1 row")
    public void iShouldSeeAtLeastOneRow() throws SQLException {
        assertTrue(resultSet.next());
    }

    @Then ("I should see at least 2 row")
    public void iShouldSeeAtLeastTwoRow() throws SQLException {
        assertTrue(resultSet.next());
    }

}

