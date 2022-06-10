package br.inatel.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class JogadorBD extends Database{

    public boolean insertJogador(Jogador jogador){
        connect();
        String sql = "INSERT INTO Jogador(nome) VALUES (?)";
        try{
            pst = connection.prepareStatement(sql);
            pst.setString(1, jogador.getNome());
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

    public ArrayList<Jogador> researchJogador(){
        connect();
        ArrayList<Jogador> jogador = new ArrayList<>();
        String sql = "SELECT * from Jogador";

        try{
            statement = connection.createStatement();
            result = statement.executeQuery(sql);

            while(result.next()){
                Jogador jogadorTemp = new Jogador(result.getString("nome"));
                jogadorTemp.idJogador = result.getInt("idJogador");
                jogadorTemp.Partida_idPartida = result.getInt("Partida_idPartida");
                System.out.println("idJogador= " + jogadorTemp.idJogador);
                System.out.println("Nome = " + jogadorTemp.getNome());
                System.out.println("-------------------------------");
                jogador.add(jogadorTemp);
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
        return jogador;
    }

    public boolean updateHighScoreAll(int idJogador, double score ){
        connect();
        String sql = "UPDATE Jogador SET highScoreAll=? WHERE idJogador=?";
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

    public boolean deleteJogador(int idJogador){
        connect();
        String sql = "DELETE FROM Jogador WHERE idJogador=?";
        try{
            pst = connection.prepareStatement(sql);
            pst.setInt(1,idJogador);
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
