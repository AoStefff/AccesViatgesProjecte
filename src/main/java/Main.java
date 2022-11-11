import Implementacions.Implementacions;
import Interficies.DAO;
import Objects.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static DAO cdao=new Implementacions();
     static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agencia_viatges","postgres","mcgastron99");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        Scanner lec=new Scanner(System.in);

        int opcio = 0;
       do{
           System.out.println("\t1. Iniciar sessió\t\n2. Registrar");
           opcio=lec.nextInt();
           lec.nextLine();
           switch (opcio){
               case 1:
                   System.out.println("Nom: ");
                   String nom=lec.nextLine();
                   System.out.println("Dni del usuari: ");
                   String dni=lec.nextLine();
                      if(!userExist(dni)){

                      }
                      else
                   break;
               case 2:
                   System.out.println("Dni del nou usuari");

           }
        }
        while(opcio!=0);

    }
    public static boolean userExist(String d){
        cdao.cercaClient(d,con);

        return false;

    }
}