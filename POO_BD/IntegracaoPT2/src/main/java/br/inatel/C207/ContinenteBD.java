package br.inatel.C207;

import com.mysql.cj.xdevapi.JsonArray;

import java.sql.SQLException;

public class ContinenteBD extends Database {

    public String getContinenteNome(int idContinente){
        connect();
        String continente = null;
        String sql = "SELECT nome FROM Continente WHERE idContinente = ?";

        try{

            pst = connection.prepareStatement(sql);
            pst.setInt(1,idContinente);
            result = pst.executeQuery();

            while(result.next()){
                Continente continenteTemp = new Continente(result.getString("nome"));
                continente = continenteTemp.getNome();
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
        return continente;
    }

    public boolean insertContinente(Continente continente){
        connect();
        String sql = "INSERT INTO Continente(nome) VALUES (?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, continente.getNome());
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
}
