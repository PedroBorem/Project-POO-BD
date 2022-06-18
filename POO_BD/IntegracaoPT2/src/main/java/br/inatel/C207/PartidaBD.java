package br.inatel.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class PartidaBD extends Database{

    public boolean insertPartida(Partida partida){
        connect();
        String sql = "INSERT INTO Partida(modo) VALUES (?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setBoolean(1, partida.isModo());
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

    public boolean updateHighScoreContinente(int idJogador, double score ){
        connect();
        String sql = "UPDATE Jogador SET highScoreContinente=? WHERE idJogador=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, score);
            pst.setInt(2,idJogador);
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

    public boolean updateHighScore(int idJogador, double score ){
        connect();
        String sql = "UPDATE Jogador SET highScore=? WHERE idJogador=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setDouble(1, score);
            pst.setInt(2,idJogador);
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

    public boolean deletePartida(int idPartida){
        connect();
        String sql = "DELETE FROM Partida WHERE idPartida=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idPartida);
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

    public Paises[] getPaises(){
        connect();
        Paises[] pais = new Paises[5];
        String sql = "SELECT * FROM Paises ORDER BY RAND() LIMIT 4";
        int i = 0;
        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Paises paisTemp = new Paises();
                paisTemp.setNome(result.getString("nome"));
                paisTemp.setLatitude(result.getDouble("latitude"));
                paisTemp.setLongitude(result.getDouble("longitude"));
                paisTemp.idPaises = result.getInt("idPaises");
                System.out.println(paisTemp.getNome());
                System.out.println("-------------------------------");
                pais[i] = paisTemp;
                i++;
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
        return pais;
    }

    public Paises[] getPaises(int idContinente){
        connect();
        Paises[] pais = new Paises[4];
        String sql = "SELECT DISTINCT 4 from Paises WHERE Continente_idContinente = ?";
        int i = 0;
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idContinente);
            result = pst.executeQuery();

            while(result.next()){
                Paises paisTemp = new Paises(result.getString("nome"),result.getDouble("longitude"),result.getDouble("latitude"));
                paisTemp.idPaises = result.getInt("idPaises");
                System.out.println("-------------------------------");
                pais[i] = paisTemp;
                i++;
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
        return pais;
    }

    public int getidContinente(){
        connect();
        Continente continente = new Continente();
        String sql = "SELECT 1 from Continente";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Continente contTemp = new Continente(result.getString("nome"));
                contTemp.idContinente = result.getInt("idContinente");
                System.out.println("-------------------------------");
                continente = contTemp;
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
        return continente.idContinente;
    }
}
