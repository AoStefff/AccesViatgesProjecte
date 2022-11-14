import Implementacions.Implementacions;
import Interficies.DAO;
import Objects.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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


    public static void main(String[] args) throws SQLException {
        Scanner lec=new Scanner(System.in);

        int opcio = 0;
       do{
           System.out.println("\t[1] Iniciar sessió\n\t[2] Registrar");
           opcio=lec.nextInt();
           lec.nextLine();
           switch (opcio){
               case 1:

                   System.out.println("Dni del usuari: ");
                   String dni=lec.nextLine();
                      while(!userExist(dni)){
                          System.out.println("No existeix l'usuari: ");
                          dni=lec.nextLine();
                      }
                      System.out.println("Inici de sessió correcte");
                     Client cli= dao.cercaClient(dni,con);
                     if(cli.isAdmin()){
                         menuAdmin();
                     }
                     else{
                         menuUser(cli);
                     }
                   break;


                     case 2:
                   System.out.println("Formulari de registre\n");
                   System.out.println("Nom:");
                   String nom=lec.nextLine();
                   System.out.println("Dni: ");
                   dni=lec.nextLine();
                   System.out.println("Data de Naixament (DD-MM-AAAA)");
                   String data=lec.nextLine();
                   System.out.println("Email: ");
                   String email=lec.next();
                   System.out.println("Telefon: ");
                   String telefon=lec.next();
                   while(userExist(dni)){
                       System.out.println("Dni del usuari: ");
                       dni=lec.nextLine();
                   }
                   String []dataa=data.split("-");
                   Client c=new Client(dni,nom,LocalDate.of(Integer.parseInt(dataa[2]),Integer.parseInt(dataa[1]),Integer.parseInt(dataa[0])),telefon,email,false);
                   dao.createClient(c,con);
           }
        }
        while(opcio!=0);

    }



public static void menuAdmin(){
    Scanner lec=new Scanner(System.in);

    int opcio;
        do{
            System.out.println("\t[1] Visualitza tots els viatges actius\n\t[2] Afegeix viatge\n\t[3] Deshabilitar viatges");
            opcio=lec.nextInt();
            lec.nextLine();
            switch (opcio){
                case 1:
                    ArrayList<Viatge> viatgeList = dao.TotsVia(con);

                    for(Viatge v:viatgeList){
                        System.out.println("\n---------------");
                        System.out.println(dao.cercaTransport(v.getIdTransport(),con).getNom());
                        System.out.print(v.getIdOrigen()+" ---> "+v.getIdDesti());
                        System.out.print(v.getDataHora());

                    }
                    break;
                case 2:
                    ArrayList<Localitat> localitats = dao.TotsLoc(con);
                    ArrayList<Transport> transports = dao.TotsTran(con);
                    int idOrigen = 0;
                    int idDesti=0;
                    int idTransport=0;
                    boolean trobat = false;
                    int i=0;
                    do{
                        System.out.print("Entra l'origen del viatge: ");
                        String origen = lec.nextLine().toLowerCase();
                        while (!trobat && i<localitats.size()){
                            if (localitats.get(i).getNom().toLowerCase().equals(origen))  {
                                trobat=true;
                                idOrigen = localitats.get(i).getId();
                            }
                            i++;
                        }
                    }while (!trobat);
                    trobat = false;
                    i=0;
                    do{
                        System.out.print("Entra el destí del viatge: ");
                        String desti = lec.nextLine().toLowerCase();
                        while (!trobat && i<localitats.size()){
                            if (localitats.get(i).getNom().toLowerCase().equals(desti)) {
                                idDesti = localitats.get(i).getId();
                                trobat=true;
                            }
                            i++;
                        }
                    }while (!trobat);
                    System.out.println("Entra la data 'DD-MM-AAAA' del viatge");
                    String [] data = lec.nextLine().split("-");
                    System.out.println("Entra l'hora 'HH:MM' del viatge");
                    String [] hora =lec.nextLine().split(":");
                    LocalDateTime dateTime = LocalDateTime.of(LocalDate.of(Integer.parseInt(data[0]),Integer.parseInt(data[1]),Integer.parseInt(data[2])),LocalTime.of(Integer.parseInt(hora[0]),Integer.parseInt(hora[1])));
                    trobat = false;
                    i=0;
                    do{
                        System.out.print("Entra el transport del viatge: ");
                        String transport = lec.nextLine().toLowerCase();
                        while (!trobat && i<localitats.size()){
                            if (localitats.get(i).getNom().toLowerCase().equals(transport)) {
                                trobat=true;
                                idTransport = localitats.get(i).getId();
                            }
                            i++;
                        }
                    }while (!trobat);
                    boolean habilitat = true;
                    Viatge nouViatge = new Viatge(idOrigen,idDesti,dateTime,idTransport,habilitat);
                    dao.createViatge(nouViatge,con);
                    break;
                case 3:

                    break;
            }
    }while(opcio!=0);
}
public static void menuUser(Client c){
    Scanner lec=new Scanner(System.in);

    int opcio;
    do{
        System.out.println("\t[1] Visualitza viatges per  \n\t[2] Comprar  bitllets \n\t[3] Editar");

        opcio=lec.nextInt();
        lec.nextLine();
        switch (opcio){
            case 1:
                ArrayList<Viatge> viatgeList = dao.TotsVia(con);
                String origen;
                System.out.println("Introdueix la teva ciutat de sortida");
                origen=lec.nextLine();
                for(Viatge v:viatgeList){
                    if (dao.cercaLocalitat(v.getIdOrigen(),con).getNom().equalsIgnoreCase(origen) && LocalDateTime.now().isBefore(v.getDataHora())) {
                        System.out.println("\n---------------");
                        System.out.println(dao.cercaTransport(v.getIdTransport(), con).getNom());
                        System.out.print(v.getIdOrigen() + " ---> " + v.getIdDesti());
                        System.out.print(v.getDataHora());
                        System.out.println("Copia aquest codi per comprar bitllets d'aquest viatge: "+v.getIdViatge());
                    }
                }
                break;
            case 2:
                int codi=0;
                System.out.println("Enganxa el codi que ha copiat: ");
               codi= lec.nextInt();
                lec.nextLine();

                ArrayList<Bitllet>bitllets=dao.TotsBit(con);
                boolean trobat=false;
                Bitllet b = null;
                int i=0;
                while(!trobat){
                    if(bitllets.get(i).getIdViatge()==codi){
                        b=bitllets.get(i);
                        trobat=true;
                    }
                }
                Viatge v = dao.cercaViatge(codi,con);
                Transport t = dao.cercaTransport(v.getIdTransport(),con);
                int seients= t.getsNormal() + t.getsPreferent();
                 ArrayList<Compra>compres = dao.TotsCom(con);
                 int dispo=seients;
                 for(Compra co:compres){
                     if(co.getIdBitllet()==b.getId()){
                         dispo--;
                     }
                 }
                 System.out.println("Actualment queden "+dispo+" bitllets disponibles");
                 System.out.println("Preu per bitllet "+b.getPreu());
                 System.out.println("Vols comprar-ne? (S/N)");
                 String resp="";
                 resp=lec.next();
                 if (resp.equalsIgnoreCase("S")){
                         System.out.println("Quants bitllets vols comprar?");
                            int q=lec.nextInt();
                            lec.nextLine();
                            if(q<=dispo){
                               System.out.println(b.getPreu()*q);
                               for (int j=0;j<q;j++){
                                   System.out.println("Introdueix el nom del passatger");
                                   String nom=lec.nextLine();
                                   System.out.println("Introdueix el dni del passatger");
                                   String dni=lec.nextLine();

                                   System.out.println("Portarà maletes? (S/N)");
                                   resp=lec.nextLine();
                                   if (resp.equalsIgnoreCase("S")){
                                       //Cear maletes MAX 3
                                       //Per maleta
                                   }

                               }

                            }
                            else{
                                System.out.println("No hi ha tants bitlllets disponibles");

                            }







                 }

                break;
            case 3:

                break;
        }
    }while (opcio!=0);
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