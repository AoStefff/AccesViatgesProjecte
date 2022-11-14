package Interficies;

import Objects.*;

import java.sql.Connection;
import java.util.List;

public interface DAO {
    List<Client> TotsCli();
    Client cercaClient(String dni, Connection con);
    Client cercaClient(int id, Connection con);

    boolean createClient(Client cli, Connection con);
    boolean updateClient(Client cli, Connection con);
    boolean deleteClient(Client cli, Connection con);

    List<Bitllet> TotsBit();
    Bitllet cercaBitllet(int id, Connection con);

    boolean createBitllet(Bitllet bit, Connection con);
    boolean updateBitllet(Bitllet bit, Connection con);
    boolean deleteBitllet(Bitllet bit, Connection con);



    List<Compra> TotsCom();
    Compra cercaCompra(int id, Connection con);

    boolean createCompra(Compra com, Connection con);
    boolean updateCompra(Compra com, Connection con);
    boolean deleteCompra(Compra com, Connection con);


    List<Equipatge> TotsEquip();
    Equipatge cercaEquipatge(int id, Connection con);

    boolean createEquipatge(Equipatge equ, Connection con);
    boolean updateEquipatge(Equipatge equ, Connection con);
    boolean deleteEquipatge(Equipatge equ, Connection con);

    List<FacEquip> TotsFequip();
    FacEquip cercaFacEquipatge(int id, Connection con);

    boolean createFacEquipatge(FacEquip feq, Connection con);
    boolean updateFacEquipatge(FacEquip feq, Connection con);
    boolean deleteFacEquipatge(FacEquip feq, Connection con);



    List<Localitat> TotsLoc();
    Localitat cercaLocalitat(int id, Connection con);

    boolean createLocalitat(Localitat loc, Connection con);
    boolean updateLocalitat(Localitat loc, Connection con);
    boolean deleteLocalitat(Localitat loc, Connection con);


    List<Transport> TotsTran();
    Transport cercaTransport(int id, Connection con);

    boolean createTransport(Transport tra, Connection con);
    boolean updateTransport(Transport tra, Connection con);
    boolean deleteTransport(Transport tra, Connection con);


    List<Viatge> TotsVia();
    Viatge cercaViatge(int id, Connection con);

    boolean createViatge(Viatge via, Connection con);
    boolean updateViatge(Viatge via, Connection con);
    boolean deleteViatge(Viatge via, Connection con);



}
