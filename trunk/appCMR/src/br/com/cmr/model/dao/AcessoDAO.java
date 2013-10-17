/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cmr.model.dao;

import br.com.cmr.model.entity.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ritacosta
 */
public class AcessoDAO implements IAcessoDAO {

    private static final String sqlAcesso = "select login, senha from usuarios where "
            + "login = ? and senha = ?"
            + "and role_user = 'ATIVO'";

    @Override
    public List<Usuarios> pesquisar(String nome, String senha, String role_user) {
        List<Usuarios> usuarios = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sqlAcesso);
            pstm.setString(1, nome);
            pstm.setString(2, senha);
            rs = pstm.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Seja bem vindo:", "Boas Vindas", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Usuário não cadastrado ou Inativo.\n"
                        + " Contate o administrador do sistema", "Error", JOptionPane.ERROR_MESSAGE);
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
        return usuarios;
    }
}
