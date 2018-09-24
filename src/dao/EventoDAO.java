package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Evento;
import util.ConnectionFactory;

public class EventoDAO {

	Connection conexao = new ConnectionFactory().getConnection();

	PreparedStatement st;
	// envia as informações pro banco
	ResultSet rs;
	// pega as informações
	Evento objEvento;
	// representa a tabela


	public List<Evento> ConsultaEvento() {

		List<Evento> listEvento = new ArrayList<Evento>();

		try {

			st = conexao.prepareStatement("select * from tb_evento where Status_Evento = 1 order by data_Evento desc");
			rs = st.executeQuery();

			while (rs.next()) {

				objEvento = new Evento();
				objEvento.setIdEvento(rs.getInt(1));
				objEvento.setTituloEvento(rs.getString(2));
				objEvento.setDescricaoEvento(rs.getString(3));
				objEvento.setDataEvento(rs.getDate(4));
				listEvento.add(objEvento);
			}

			rs.close();
			st.close();
			conexao.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return listEvento;

	}

}
