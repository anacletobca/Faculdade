package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    final private String driver = "org.gjt.mm.mysql.Driver";
    final private String url = "jdbc:mysql://localhost/campeonato";
    final private String user = "root";
    final private String password = "root";
     
    public Connection getConexao() throws ClassNotFoundException, SQLException {
         
        Class.forName(driver);
        return DriverManager.getConnection(url, user, password);
    }
}
