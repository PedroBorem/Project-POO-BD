package br.inatel.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class PaisesBD extends Database {

    public boolean insertPais(Paises pais){
        connect();
        String sql = "INSERT INTO Paises(nome,longitude,latitude) VALUES (?,?,?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, pais.getNome());
            pst.setDouble(2,pais.getLongitude());
            pst.setDouble(3,pais.getLatitude());
            pst.execute();
            check = true;
        }
        catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public ArrayList<Paises> researchPaises(){
        connect();
        ArrayList<Paises> paises = new ArrayList<>();
        String sql = "SELECT * from Paises";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Paises paisTemp = new Paises(result.getString("nome"),result.getDouble("longitude"),result.getDouble("latitude"));
                paisTemp.idPaises = result.getInt("idPaises");
                System.out.println("idPais = " + paisTemp.idPaises);
                System.out.println("Nome = " + paisTemp.getNome());
                System.out.println("longitude = " + paisTemp.getLongitude());
                System.out.println("latitude = " + paisTemp.getLatitude());
                System.out.println("-------------------------------");
                paises.add(paisTemp);
            }
        }catch(SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
        }
        finally {
            try{
                connection.close();
                statement.close();
                result.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return paises;
    }

    public boolean updateCoordenadas(int idPaises, double longitude, double latitude){
        connect();
        String sql = "UPDATE Paises SET longitude=?,latitude=? WHERE idPaises=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, longitude);
            pst.setDouble(2, latitude);
            pst.setInt(3,idPaises);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }

    public boolean deletePais(int idPaises){
        connect();
        String sql = "DELETE FROM Paises WHERE idPaises=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idPaises);
            pst.execute();
            check = true;
        }catch (SQLException e){
            System.out.println("Erro de operação: " + e.getMessage());
            check = false;
        }
        finally {
            try{
                connection.close();
                pst.close();
            }
            catch (SQLException e){
                System.out.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
        return check;
    }
}
