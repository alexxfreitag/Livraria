package dao;

import factory.ConnectionFactory;
import modelo.Usuario;
import java.sql.*;
import java.sql.PreparedStatement;

public class  UsuarioDAO {

    private Connection connection;
    Long id;
    String nome;
    String senha;
    String cpf;
    String email;
    String telefone;

    public UsuarioDAO() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void adiciona(Usuario usuario) {
        String sql = "INSERT INTO usuario(nome,senha,cpf,email,telefone) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getCpf());
            stmt.setString(4, usuario.getEmail());
            stmt.setString(5, usuario.getTelefone());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void remove(Usuario usuario) {
        String sql = "DELETE usuario WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, usuario.getId());
            stmt.execute();
            stmt.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }

    }

    public void cria() {
        final String createUsuario = "CREATE TABLE IF NOT EXISTS usuario (\n"
                + "id BIGINT(10) AUTO_INCREMENT,\n"
                + "nome VARCHAR(255),\n"
                + "senha VARCHAR(255),\n"
                + "cpf VARCHAR(255),\n"
                + "email VARCHAR(255),\n"
                + "telefone VARCHAR(255),\n"
                + "PRIMARY KEY (id));";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createUsuario);
            connection.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }

}
