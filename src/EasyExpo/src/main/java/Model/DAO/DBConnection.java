package Model.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.TimeZone;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

/**
 * Questa classe istanzia un oggetto Singleton che sarà successivamente coondivio
 * da tutte le omponenti che avranno bisogno di accedere al database.
 *
 * @author GAETANO IULIANO
 * @version 1.0
 * @since 2020-12-29
 */
public class DBConnection {
  private static DataSource datasource;

  /**
   * Returns the Connection to the Database.
   *
   * @return Connection - connessione al database.
   */
  public static Connection getConnection() throws SQLException {
    if (datasource == null) {
      PoolProperties p = new PoolProperties();
      p.setUrl(
          "jdbc:mysql://localhost:3306/EasyExpo?serverTimezone=" + TimeZone.getDefault().getID());
      p.setDriverClassName("com.mysql.jdbc.Driver");
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