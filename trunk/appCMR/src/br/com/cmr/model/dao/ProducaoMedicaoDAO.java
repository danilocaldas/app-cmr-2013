/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.ProducaoMedica;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ritacosta
 */
public class ProducaoMedicaoDAO implements IProducaoMedicaDAO {

    public static final String sqlInsert = "insert into producao_medica "
            + "(data_entrada_cmr, prestador, procedimento, quantidade_laudos, "
            + "data_analise, funcionario, data_encaminhamento, nucleos) values (?,?,?,?,?,?,?,?)";
    public static final String sqlUpdate = "";
    public static final String sqlDelete = "";
    public static final String sqlList = "select * from producao_medica";

    @Override
    public int save(ProducaoMedica pMedica) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlInsert);
            pstm.setDate(++index, pMedica.getEntradaCmr());
            pstm.setString(++index, pMedica.getPrestador());
            pstm.setString(++index, pMedica.getProcedimento());
            pstm.setInt(++index, pMedica.getQuantidade());
            pstm.setDate(++index, pMedica.getAnalise());
            pstm.setString(++index, pMedica.getFuncionario());
            pstm.setDate(++index, pMedica.getEncaminhamento());
            pstm.setString(++index, pMedica.getNucleos());
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
    public int updade(ProducaoMedica pMedica) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        int result = 0;
        try {
            int index = 0;
            pstm = conn.prepareStatement(sqlUpdate);
            pstm.setString(++index, pMedica.getFuncionario());
            pstm.setString(++index, pMedica.getPrestador());
            pstm.setString(++index, pMedica.getProcedimento());
            pstm.setString(++index, pMedica.getNucleos());
            pstm.setInt(++index, pMedica.getQuantidade());
            pstm.setDate(++index, pMedica.getEntradaCmr());
            pstm.setDate(++index, pMedica.getAnalise());
            pstm.setDate(++index, pMedica.getEncaminhamento());
            pstm.setLong(++index, pMedica.getId());
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
    public int delete(Long id) {
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
    public List<ProducaoMedica> listar() {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        List<ProducaoMedica> pMedicas = new ArrayList();
        try {
            pstm = conn.prepareStatement(sqlList);
            rs = pstm.executeQuery();
            while(rs.next()){
                ProducaoMedica pMedica = new ProducaoMedica();
                pMedica.setId(rs.getLong("id"));
                pMedica.setEntradaCmr(rs.getDate("data_entrada_cmr"));
                pMedica.setPrestador(rs.getString("prestador"));
                pMedica.setProcedimento(rs.getString("procedimento"));
                pMedica.setQuantidade(rs.getInt("quantidade_laudos"));
                pMedica.setAnalise(rs.getDate("data_analise"));
                pMedica.setFuncionario(rs.getString("funcionario"));
                pMedica.setEncaminhamento(rs.getDate("data_encaminhamento"));
                pMedica.setNucleos(rs.getString("nucleos"));
                pMedicas.add(pMedica);
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
        return pMedicas;
    }
}
