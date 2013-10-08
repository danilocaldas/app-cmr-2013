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
import java.text.SimpleDateFormat;
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
    //CONSULTAS
    private static final String sqlFindAll = "select * from PRODUCAO";
    private static final String sqlFindProPeriodo = "select * from PRODUCAO where DATA_DIGITACAO between ? and ?";
    private static final String sqlFindProFuncionario = "select * from PRODUCAO where FUNCIONARIO like ?";
    private static final String sqlFindProFuncioPeriodo = "select * from PRODUCAO where FUNCIONARIO = ?"
            + " and DATA_DIGITACAO between ? and ?";
    private static final String sqlFindProPrestador = "select * from PRODUCAO where PRESTADOR like ?";
    
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
            pstm.setDate(4, producao.getData());
            pstm.setDate(5, producao.getDataEntrada());
            pstm.setDate(6, producao.getDataDigitacao());
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
            pstm.setDate(4, producao.getData());
            pstm.setDate(5, producao.getDataEntrada());
            pstm.setDate(6, producao.getDataDigitacao());
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

    @Override
    public List<Producao> findProPeriodo(Date dataInicial, Date dataFinal) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Producao> producoes = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindProPeriodo);
            pstm.setDate(1, dataInicial);
            pstm.setDate(2, dataFinal);
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

    @Override
    public List<Producao> findProFuncionario(String funcionario) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Producao> producoes = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindProFuncionario);
            pstm.setString(1, funcionario);
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

    @Override
    public List<Producao> findProFuncioPeriodo(String funcionario, Date dataInicial, Date dataFinal) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Producao> producoes = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindProFuncioPeriodo);
            pstm.setString(1, funcionario);
            pstm.setDate(2, dataInicial);
            pstm.setDate(3, dataFinal);
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

    @Override
    public List<Producao> findProPrestador(String prestador) {
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        List<Producao> producoes = new ArrayList<>();
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlFindProPrestador);
            pstm.setString(1, prestador);
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
