package dao;
import factory.ConnectionFactory;
import modelo.Livro;
import java.sql.*;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;

public class LivroDAO { 
    
    private Connection connection;
    Long id;
    String titulo;
    String autor;
    int ano;
    String editora;
    public ResultSet rs;
    
    public LivroDAO(){ 
        this.connection = new ConnectionFactory().getConnection();
    } 
    
    public void adiciona(Livro livro){ 
        String sql = "INSERT INTO livro(titulo,autor,ano,editora) VALUES(?,?,?,?)";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getAutor());
            stmt.setInt(3, livro.getAno());
            stmt.setString(4, livro.getEditora());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
    
    public void remove(Livro livro){ 
        String sql = "DELETE livro WHERE id = ?";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setLong(1, livro.getId());
            stmt.execute();
            stmt.close();
        } 
        catch (SQLException u) { 
            throw new RuntimeException(u);
        } 
        
    }
    
    public void consultaTudo(){ 
        String sql = "SELECT * FROM livro ";
        try { 
            PreparedStatement stmt = connection.prepareStatement(sql);
            rs = stmt.executeQuery();
        } 
        catch (SQLException u) { 
            JOptionPane.showMessageDialog(null, "Não foi possível realizar a consulta!");
            
        } 
        
    }
    
    public void cria() {
        final String createLivro = "CREATE TABLE IF NOT EXISTS livro (\n"
                + "id BIGINT(10) AUTO_INCREMENT,\n"
                + "titulo VARCHAR(255),\n"
                + "autor VARCHAR(255),\n"
                + "ano INTEGER,\n"
                + "editora VARCHAR(255),\n"
                + "PRIMARY KEY (id));";

        try {
            Statement stmt = connection.createStatement();
            stmt.execute(createLivro);
            connection.close();
        } catch (SQLException u) {
            throw new RuntimeException(u);
        }
    }
    
}