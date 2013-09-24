/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Producao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Danilo
 */
public class ProducaoDAO implements IProducaoDAO{

    private static final String sqlInsert = "insert into PRODUCAO (FUNCIONARIO, PRESTADOR, PROCEDIMENTO,"
            + "DATA, DATA_ENTRADA, DATA_DIGITACAO, QUANTIDADE)"
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String sqlUpdate = "update PRODUCAO set FUNCIONARIO = ?, "
            + "PRESTADOR = ?, PROCEDIMENTO = ?, DATA = ?, DATA_ENTRADA = ?"
            + ", DATA_DIGITACAO = ?, QUANTIDADE = ?  where ID = ?";
    private static final String sqlDelete = "delete from PRODUCAO where ID = ? ";
    private static final String sqlFindAll = "select * from PRODUCAO";
    
    
    @Override
    public int save(Producao producao) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setString(1, producao.getFuncionario());
            pstm.setString(2, producao.getPrestador());
            pstm.setString(3, producao.getProcedimento());
            pstm.setDate(4, (Date) producao.getData());
            pstm.setDate(5, (Date) producao.getDataEntrada());
            pstm.setDate(6, (Date) producao.getDataDigitacao());
            pstm.setString(7, producao.getQuantidade());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;
        
    
    }

    @Override
    public int update(Producao producao) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(1, producao.getFuncionario());
            pstm.setString(2, producao.getPrestador());
            pstm.setString(3, producao.getProcedimento());
            pstm.setDate(4, (Date) producao.getData());
            pstm.setDate(5, (Date) producao.getDataEntrada());
            pstm.setDate(6, (Date) producao.getDataDigitacao());
            pstm.setString(7, producao.getQuantidade());
            pstm.setLong(8, producao.getId());
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;  
    }

    @Override
    public int excluir(Long id) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            pstm = conn.prepareStatement(sqlDelete);
            pstm.setLong(1, id);
            result = pstm.executeUpdate();
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, null);
            }
            ex.printStackTrace();
        }
        return result;  
    }

    @Override
    public List<Producao> findAll() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Producao> producoes = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindAll);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Producao producao = new Producao();
                producao.setId(rs.getLong("id"));
                producao.setFuncionario(rs.getString("funcionario"));
                producao.setPrestador(rs.getString("prestador"));
                producao.setProcedimento(rs.getString("procedimento"));
                producao.setData(rs.getDate("data"));
                producao.setDataEntrada(rs.getDate("data_entrada"));
                producao.setDataDigitacao(rs.getDate("data_digitacao"));
                producao.setQuantidade(rs.getString("quantidade"));
                producoes.add(producao);
            }
        } catch (SQLException ex) {
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException ex1) {
                ex1.printStackTrace();
            } finally {
                DBConnection.close(conn, pstm, rs);
            }
            ex.printStackTrace();
        }
        return producoes;
    }

}
