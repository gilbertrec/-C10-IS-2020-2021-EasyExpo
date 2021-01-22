package Model.DAO;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import static org.junit.jupiter.api.Assertions.*;

class DBConnectionTest {
    private static DataSource dataSource;
    private DBConnection dbConnection;
    public Connection connection;


    @BeforeAll
    static void init() throws Exception {
        /*MysqlDataSource mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/EasyExpo");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("basedidati");
        mysqlDataSource.setServerTimezone("UTC");
        mysqlDataSource.setVerifyServerCertificate(false);
        mysqlDataSource.setUseSSL(false);
        dataSource = mysqlDataSource;*/

    }

    @BeforeEach
    void setUp() throws SQLException {

    }

    @Test
    void testConnection() throws SQLException {
        assertNotNull(connection);
    }

    @Test
    void testStatement() throws SQLException {
        connection = DBConnection.getConnection();
        Connection con = connection;
        Statement stm = connection.createStatement();
        assertNotNull(stm);
    }




}