import Implementacions.Implementacions;
import Interficies.DAO;
import Objects.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) throws SQLException {

        Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/agencia_viatges","postgres","1234");
        DAO cdao=new Implementacions();
        Client c=new Client("41533839W","Arnau Perpinyà Tor", LocalDate.of(2001,02,8),"685745496","arpeto@inspalamos.cat");
        cdao.createClient(c,con);

    }
}