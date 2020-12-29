package Model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimeZone;

import Model.POJO.Fornitore;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * <p> DBConnection e' una classe che si occupa
 * della connessione al db </p>
 * @author
 * @version 1.0
 * @since   2020-12-29
 */

public class DBConnection {
    private static DataSource datasource;

    /**
     * Metodo che ritorna la connessione al db
     * @return  Connection - Oggetto di tipo {@link Connection}
     *
     */

    public static Connection getConnection() throws SQLException {
        if (datasource == null) {
            PoolProperties p = new PoolProperties();
            p.setUrl("jdbc:mysql://localhost:3306/EasyExpo?serverTimezone=" + TimeZone.getDefault().getID());
            p.setDriverClassName("com.mysql.cj.jdbc.Driver");
            p.setUsername("root");
            p.setPassword("basedidati");
            p.setMaxActive(100);
            p.setInitialSize(10);
            p.setMinIdle(10);
            p.setRemoveAbandonedTimeout(60);
            p.setRemoveAbandoned(true);
            datasource = new DataSource();
            datasource.setPoolProperties(p);
        }
        return datasource.getConnection();
    }
}
