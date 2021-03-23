package hu.nive.ujratervezes.zarovizsga.peoplesql;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeopleDao {
    private final DataSource dataSource;

    public PeopleDao(MariaDbDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT ip_address FROM people WHERE first_name = ? AND last_name = ?")) {

            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            return getIpByPreparedStatement(stmt);

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not connect to database", sqlException);
        }
    }

    private String getIpByPreparedStatement(PreparedStatement stmt) {
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getString("ip_address");
            }
            return "";
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Can not select from people table", sqlException);
        }
    }
}
