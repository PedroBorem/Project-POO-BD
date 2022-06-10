package br.inatel.C207;

import java.sql.SQLException;
import java.util.ArrayList;

public class RankBD extends Database {

        public boolean insertRank(Rank rank){
            connect();
            String sql = "INSERT INTO Rank(nome) VALUES (?)";
            try{
                pst = connection.prepareStatement(sql);
                pst.setString(1, rank.getNome());
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

        public ArrayList<Rank> researchRank(){
            connect();
            ArrayList<Rank> ranks = new ArrayList<>();
            String sql = "SELECT * from Rank";

            try{
                statement = connection.createStatement();
                result = statement.executeQuery(sql);

                while(result.next()){
                    Rank rank = new Rank(result.getString("nome"));
                    rank.idRank = result.getInt("idRank");
                    System.out.println("idPartida= " + rank.idRank);
                    System.out.println("Modo = " + rank.getNome());
                    System.out.println("-------------------------------");
                    ranks.add(rank);
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
            return ranks;
        }

        public boolean updateRank(int idRank, String nome){
            connect();
            String sql = "UPDATE Rank SET nome=? WHERE idRank=?";
            try{
                pst = connection.prepareStatement(sql);
                pst.setString(1, nome);
                pst.setInt(2,idRank);
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

        public boolean deleteRank(int idRank){
            connect();
            String sql = "DELETE FROM Rank WHERE idRank=?";
            try{
                pst = connection.prepareStatement(sql);
                pst.setInt(1,idRank);
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