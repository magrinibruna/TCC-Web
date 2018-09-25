package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Mensagem;
import util.ConnectionFactory;

public class MensagemDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();
	
	PreparedStatement st;
	//envia as informa��es pro banco
	ResultSet rs;
	//pega as informa��es
	Mensagem objMensagem;
	//representa a tabela 	
	
	public int cadastrarMensagem(Mensagem objMensagem) {
		int resultado = 0;
		String SQL = "INSERT INTO tb_Mensagem(EnvMsg_Aluno, EnvMsg_Professor, RecebeMsg_Aluno,  RecebeMsg_Turma, RecebeMsg_Professor, AssMsg, DescMsg)" +
		"VALUES ( ?, ?, ?, ?, ? ,? ,?)";
		
		try {
			
			st = conexao.prepareStatement(SQL);
			//o st vai enviar por meio da conex�o o valor do SQL
			
			st.setInt(1, objMensagem.getEnviaMensagem_Aluno());
			st.setInt(2, objMensagem.getEnviaMensagem_Professor());
			st.setInt(3, objMensagem.getRecebeMensagem_Aluno());
			st.setInt(4, objMensagem.getRecebeMensagem_Turma());
			st.setInt(5, objMensagem.getRecebeMensagem_Professor());
			st.setString(6, objMensagem.getAssuntoMensagem());
			st.setString(7, objMensagem.getDescricaoMensagem());
			
			resultado = st.executeUpdate();
			
			if (resultado == 1) {
				JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
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
