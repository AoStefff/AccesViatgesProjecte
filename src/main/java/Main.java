import Implementacions.Implementacions;
import Interficies.DAO;
import Objects.Client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    static DAO dao=new Implementacions();
     static Connection con;

    static {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/agencia_viatges","postgres","1234");
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
           System.out.println("\t1. Iniciar sessió\n\t2. Registrar");
           opcio=lec.nextInt();
           lec.nextLine();
           switch (opcio){
               case 1:

                   System.out.println("Dni del usuari: ");
                   String dni=lec.nextLine();
                      while(!userExist(dni)){
                          System.out.println("Dni del usuari: ");
                          dni=lec.nextLine();
                      }
                      System.out.println("Inici de sessió correcte");

                   break;
               case 2:
                   System.out.println("Formulari de registre\n");

                 /*  System.out.println("Nom:");
                   String nom=lec.nextLine();
                   System.out.println("Dni: ");
                   dni=lec.nextLine();
                   System.out.println("Data de Naixament (DD-MM-AAAA)");
                   String data=lec.nextLine();
                   System.out.println("Email: ");
                   String email=lec.next();
                   System.out.println("Telefon: ");
                   String telefon=lec.next();*/

                 //  String []dataa=data.split("-");
                //   Client c=new Client(dni,nom,LocalDate.of(Integer.parseInt(dataa[2]),Integer.parseInt(dataa[1]),Integer.parseInt(dataa[0])),telefon,email);
                   Client c=new Client("41607304F","Stefan",LocalDate.of(2003,03,30),"stmoca@inspalamos.cat","677429940");

                   dao.createClient(c,con);
           }
        }
        while(opcio!=0);

    }
    public static boolean userExist(String d){
        Client c= dao.cercaClient(d,con);
        if (c.getDni().equals(d)){
            return true;
        }else{
            return false;

        }


    }
}