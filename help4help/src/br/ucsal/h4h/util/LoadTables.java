/*
package br.ucsal.h4h.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadTables {

	public void creatScherma(Connection c) throws SQLException {

		Statement stmt = c.createStatement();
		stmt.execute("CREATE TABLE TIPO_DOACAO(ID INT, NOME_TIPO VARCHAR(30))");
		stmt.execute("ALTER TABLE TIPO_DOACAO ADD CONSTRAINT PK_TIPO_DOACAO PRIMARY KEY(id)");
		stmt.execute("CREATE TABLE usuarios(id integer,login varchar, senha varchar(16),email varchar);");
		stmt.execute("CREATE TABLE doacoes(id integer,id_usuario, id_instituicao int, id_tipo_doacao integer, data_doacao varchar(12), quantidade varchar(30));");
		stmt.execute("CREATE TABLE instituicoes(id_instituicao integer, login varchar(16), senha varchar(16), email varchar, telefone varchar);");
		stmt.execute("ALTER TABLE usuarios ADD CONSTRAINT pk_usuario PRIMARY KEY (id);");
		stmt.execute("ALTER TABLE instituicoes ADD CONSTRAINT pk_instituicao PRIMARY KEY (id);");
		stmt.execute("ALTER TABLE doacoes ADD CONSTRAINT fk_doacao_usuario FOREIGN KEY (id_usuario) REFERENCES usuario(id);");
		stmt.execute("ALTER TABLE doacoes ADD CONSTRAINT fk_doacao_instituicao FOREIGN KEY (id_instituicao) REFERENCES instituicao (id);");
		stmt.execute("ALTER TABLE doacoes ADD CONSTRAINT fk_doacao_tipo FOREIGN KEY (id_tipo_doacao) REFERENCES tipo_doacao(id)");
		
	}
}
*/