package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Login;
import util.ConnectionFactory;

public class LoginDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informa��es pro banco
	ResultSet rs;
	// pega as informa��es
	Login objLogin;
	// representa a tabela

	
	public Login Logar(String usuario) {

		String SQL = "SELECT * FROM vw_ListaUsuaios WHERE Usuario = ? ";

		try {

			st = conexao.prepareStatement(SQL);
			st.setString(1, usuario);
			rs = st.executeQuery();
			if (rs.next()) {
				objLogin = new Login();
				objLogin.setUsuarioLogin(rs.getString(1));
				objLogin.setSenhaLogin(rs.getString(2));
				objLogin.setCodigoLogin(rs.getInt(3));
				objLogin.setNhLogin(rs.getInt(4));
			} else {
				System.out.println("Usu�rio n�o encontrado");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return objLogin;
	}
	
	public int AlterarSenha(Login objLogin) {
		int resultado = 0;
		String SQL = "UPDATE tb_Login SET SenhaLogin = ? WHERE UserLogin = ?";

		try {
			st = conexao.prepareStatement(SQL);
			st.setString(1, objLogin.getSenhaLogin());
			st.setString(2, objLogin.getUsuarioLogin());

			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Senha alterada com sucesso!");
			}
			
			conexao.close();
			st.close();
			return resultado;

		} catch (Exception e) {
			try {
				if (conexao != null) {
					conexao.rollback();
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return resultado;

	}

}
