package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Sugestao;
import util.ConnectionFactory;

public class SugestaoDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	//envia as informa��es pro banco
	ResultSet rs;
	//pega as informa��es
	Sugestao objSugestao;
	//representa a tabela 	
	
	public int CadastrarSugestao(Sugestao objSugestao) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Sugestao(FKSgt, MsgSgt) VALUES (?,?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			//o st vai enviar por meio da conex�o o valor do SQL
			
			st.setInt(1, objSugestao.getFkSugestao());
			st.setString(2, objSugestao.getMensagemSugestao());

			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Sugest�o cadastrada com sucesso");
			}
			
			conexao.close();
			st.close();
			return resultado;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return resultado;
	}

}
