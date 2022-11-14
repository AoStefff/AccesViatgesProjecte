package Implementacions;

import Interficies.DAO;
import Objects.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.List;

public class Implementacions implements DAO {

    @Override
    public List<Client> TotsCli() {

        return null;
    }

    @Override
    public Client cercaClient(String dni, Connection con) {
        Client c;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from client where dni='"+dni+"'");
            rs.getRow();
            rs.next();
             c=new Client(rs.getInt("id_client"),rs.getString("dni"),rs.getString("nom"),(rs.getDate("data_naix").toLocalDate()),rs.getString("mail"),rs.getString("telefon"),rs.getBoolean("admin"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }
    public Client cercaClient(int id, Connection con) {
        Client c;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select "+id+" from client");
            rs.getRow();

            c=new Client(rs.getInt("id_client"),rs.getString("dni"),rs.getString("nom"),rs.getDate("data_naix").toLocalDate(),rs.getString("mail"),rs.getString("telefon"),rs.getBoolean("admin"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }


    @Override
    public boolean createClient(Client cli, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into client (dni,nom,data_naix,mail,telefon) values('"+cli.getDni()+"','"+cli.getNom()+"','"+cli.getDataNaix()+"','"+cli.getTelefon()+"','"+cli.getEmail()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateClient(Client cli, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update client SET (dni,nom,data_naix,mail,telefon) = ('"+cli.getDni()+"','"+cli.getNom()+"','"+cli.getDataNaix()+"','"+cli.getTelefon()+"','"+cli.getEmail()+"') where id_client='"+cli.getId()+"'");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteClient(Client cli, Connection con) {
        return false;
    }

    @Override
    public List<Bitllet> TotsBit() {
        return null;
    }

    @Override
    public Bitllet cercaBitllet(int id, Connection con) {
        Bitllet b;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from bitllets where id='"+id+"'");
            rs.getRow();
            rs.next();
            b=new Bitllet(rs.getInt("id_bitllet"),rs.getDouble("preu"),rs.getInt("tipus_s"),rs.getInt("id_viatge"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return b;
    }

    @Override
    public boolean createBitllet(Bitllet bit, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into bitllets (preu,tipus_s,id_viatge) values('"+bit.getPreu()+"','"+bit.getTipusSeient()+"','"+bit.getIdViatge()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateBitllet(Bitllet bit, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update bitllets SET (preu,tipus_s,id_viatge) = ('"+bit.getPreu()+"','"+bit.getTipusSeient()+"','"+bit.getIdViatge()+"') where id_bitllet='"+bit.getId()+"'");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteBitllet(Bitllet bit, Connection con) {
        return false;
    }

    @Override
    public List<Compra> TotsCom() {
        return null;
    }

    @Override
    public Compra cercaCompra(int id, Connection con) {
        Compra c;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select "+id+" from client");
            rs.getRow();

            c=new Compra(rs.getInt("id_bitllet"),rs.getInt("id_viatge"),rs.getInt("id_client"),rs.getDate("data_compra").toLocalDate(),rs.getDouble("preu"),rs.getString("nom_viatger"),rs.getString("dni_viatger"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return c;
    }

    @Override
    public boolean createCompra(Compra com, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into compres (id_bitllet,id_viatge,id_client,data_compra,preu,nom_viatger,dni_viatger) values('"+com.getIdBitllet()+"','"+com.getIdViatge()+"','"+com.getIdClient()+"','"+com.getDataCompra()+"','"+com.getPreu()+"','"+com.getNomPassatger()+"','"+com.getDniPassatger()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateCompra(Compra com, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update compres SET (id_bitllet,id_viatge,id_client,data_compra,preu,nom_viatger,dni_viatger) = ('"+com.getIdBitllet()+"','"+com.getIdViatge()+"','"+com.getIdClient()+"','"+com.getDataCompra()+"','"+com.getPreu()+"','"+com.getNomPassatger()+"','"+com.getDniPassatger()+"') where id_bitllet='"+com.getIdBitllet()+"' AND id_viatge='"+com.getIdViatge());
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteCompra(Compra com, Connection con) {
        return false;
    }

    @Override
    public List<Equipatge> TotsEquip() {
        return null;
    }

    @Override
    public Equipatge cercaEquipatge(int id, Connection con) {
        Equipatge q;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select "+id+" from equipatge");
            rs.getRow();

            q=new Equipatge(rs.getInt("id_equipatge"),rs.getString("nom"),rs.getDouble("pes"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return q;
    }

    @Override
    public boolean createEquipatge(Equipatge equ, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into equipatge values('"+equ.getId()+"','"+equ.getNom()+"','"+equ.getPes()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateEquipatge(Equipatge equ, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update equipatge SET('"+equ.getId()+"','"+equ.getNom()+"','"+equ.getPes()+"') where id_equipatge='"+equ.getId()+"'");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteEquipatge(Equipatge equ, Connection con) {
        return false;
    }

    public List<FacEquip> TotsFequip() {
        return null;
    }

    @Override
    public FacEquip cercaFacEquipatge(int id, Connection con) {
        FacEquip f;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select "+id+" from factura_equipatge");
            rs.getRow();

            f=new FacEquip(rs.getInt("id_factura"),rs.getInt("id_viatge"),rs.getInt("id_client"),rs.getInt("id_equipatge"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return f;
    }

    @Override
    public boolean createFacEquipatge(FacEquip feq, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into factura_equipatge values('"+feq.getId()+"','"+feq.getIdVia()+"','"+feq.getIdCli()+"','"+feq.getIdEqui()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateFacEquipatge(FacEquip feq, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update factura_equipatge SET ('"+feq.getId()+"','"+feq.getIdVia()+"','"+feq.getIdCli()+"','"+feq.getIdEqui()+"') where id_factura='"+feq.getId()+"'");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteFacEquipatge(FacEquip feq, Connection con) {
        return false;
    }

    @Override
    public List<Localitat> TotsLoc() {
        return null;
    }

    @Override
    public Localitat cercaLocalitat(int id, Connection con) {
        Localitat l;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from localitats where id='"+id+"'");
            rs.getRow();
            rs.next();
            l=new Localitat(rs.getInt("id_localitat"),rs.getString("nom"),rs.getString("pais"),rs.getString("abreviacio"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return l;
    }

    @Override
    public boolean createLocalitat(Localitat loc, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into localitats (nom,pais,abreviacio) values('"+loc.getNom()+"','"+loc.getPais()+"','"+loc.getAbreviacio()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateLocalitat(Localitat loc, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Update localitats SET (nom,pais,abreviacio) = ('"+loc.getNom()+"','"+loc.getPais()+"','"+loc.getAbreviacio()+"') where id_localitat='"+loc.getId()+"'");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean deleteLocalitat(Localitat loc, Connection con) {
        return false;
    }

    @Override
    public List<Transport> TotsTran() {
        return null;
    }

    @Override
    public Transport cercaTransport(int id, Connection con) {
        Transport t;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from bitllets where id='"+id+"'");
            rs.getRow();
            rs.next();
            t=new Transport(rs.getInt("id_transport"),rs.getInt("s_normal"),rs.getInt("s_preferent"),rs.getString("nom"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return t;
    }

    @Override
    public boolean createTransport(Transport tra, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into transport (s_normal,s_preferent,nom) values('"+tra.getsNormal()+"','"+tra.getsPreferent()+"','"+tra.getNom()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateTransport(Transport tra, Connection con) {
        return false;
    }

    @Override
    public boolean deleteTransport(Transport tra, Connection con) {
        return false;
    }

    @Override
    public List<Viatge> TotsVia() {
        return null;
    }

    @Override
    public Viatge cercaViatge(int id, Connection con) {
        Viatge v;
        try {
            Statement stmt=con.createStatement();
            ResultSet rs= stmt.executeQuery("Select * from viatge where id_viatge='"+id+"'");
            rs.getRow();
            rs.next();
            v=new Viatge(rs.getInt("id_vitge"),rs.getInt("id_origen"),rs.getInt("id_desti"),rs.getTimestamp("data").toLocalDateTime(),rs.getInt("integer"),rs.getBoolean("habilitat"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return v;    }

    @Override
    public boolean createViatge(Viatge via, Connection con) {
        try {
            Statement stmt=con.createStatement();
            stmt.executeUpdate("Insert into viatge (id_origen,id_desti,data,id_transport,habilitat) values('"+via.getIdOrigen()+"','"+via.getIdDesti()+"','"+via.getDataHora()+"','"+via.getIdTransport()+"','"+via.isHabilitat()+"')");
        }
        catch(Exception a) {
            return false;
        }

        return true;
    }

    @Override
    public boolean updateViatge(Viatge via, Connection con) {
        return false;
    }

    @Override
    public boolean deleteViatge(Viatge via, Connection con) {
        return false;
    }
}
