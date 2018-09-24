package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Horario;
import util.ConnectionFactory;

public class HorarioDAO {
	
	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Horario objHorario;
	// representa a tabela
	

	public Horario BuscarHorarioTurma(int codigo) {
		String SQL = "SELECT * from tb_Horario where id_Turma = ?";
		try {
			st = conexao.prepareStatement(SQL);
			st.setInt(1, codigo);;
			rs = st.executeQuery();
			if(rs.next()) {
				objHorario = new Horario();
				objHorario.setId_Horario(rs.getInt(1));
				objHorario.setId_Turma(rs.getInt(2));
				objHorario.setCaminhoHorario(rs.getString(3));
				objHorario.setStatus(rs.getString(4));
			} else {
				JOptionPane.showMessageDialog(null, "Horario não encontrado");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return objHorario;
	}
	

}
