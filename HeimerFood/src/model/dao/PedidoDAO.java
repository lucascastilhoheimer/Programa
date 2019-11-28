
package model.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import connection.ConnectionFactory;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.*;
        

public class PedidoDAO {
    public void create(Pedido p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("INSERT INTO pedido (numero,valor,nome,pagamento,troco,bairro,data)VALUES(?,?,?,?,?,?,?)");
            stmt.setInt(1, p.getNumero());
            stmt.setDouble(2, p.getValor());
            stmt.setString(3, p.getNome());
            stmt.setString(4, p.getPagamento());
            stmt.setString(5, p.getTroco());
            stmt.setString(6, p.getBairro());
             stmt.setString(7, p.getData());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
           
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao inserir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    
    }
    
        public List<Pedido> read(){
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            
            stmt =  con.prepareStatement("SELECT * FROM pedido");
            
           
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {         
                
                Pedido pedido = new Pedido();
              
                pedido.setNumero(rs.getInt("numero"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setNome(rs.getString("nome"));
                pedido.setPagamento(rs.getString("pagamento"));
                pedido.setTroco(rs.getString("troco"));
                pedido.setBairro(rs.getString("bairro"));
                pedido.setData(rs.getString("data"));
                
                pedidos.add(pedido);
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na leitura: "+ex);
        }finally{
        ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
        
        
    }

        
   
    
        public void update(Pedido p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE pedido SET valor = ?,nome = ?,pagamento = ?,troco = ?, bairro = ?, data = ? WHERE numero = ?");
             
            stmt.setDouble(1, p.getValor());
            stmt.setString(2, p.getNome());
            stmt.setString(3, p.getPagamento());
            stmt.setString(4, p.getTroco());
            stmt.setString(5, p.getBairro());
             stmt.setString(6, p.getData());
            stmt.setInt(7, p.getNumero());
            
           
            
            
            
            stmt.executeUpdate();
            
         
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
           
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    
    }

        
         public void delete(Pedido p){
    
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("DELETE from pedido WHERE numero = ?");
                     
            stmt.setInt(1, p.getNumero());
            
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
           
        } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao Excluir: "+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    
    }
         
         public List<Pedido> readforDesc(String nome){
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            stmt =  con.prepareStatement("SELECT * FROM pedido WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
             
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Pedido pedido = new Pedido();
                pedido.setNumero(rs.getInt("numero"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setNome(rs.getString("nome"));
                pedido.setPagamento(rs.getString("pagamento"));
                pedido.setTroco(rs.getString("troco"));
                pedido.setBairro(rs.getString("bairro"));
                pedido.setData(rs.getString("data"));
                
                pedidos.add(pedido);
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na leitura: "+ex);
        }finally{
        ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
        
        
    }
         
         
           public List<Pedido> readfornumero(int numero){
     Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pedido> pedidos = new ArrayList<>();
        
        try {
            stmt =  con.prepareStatement("SELECT * FROM pedido WHERE numero LIKE ?");
            stmt.setString(1, "%"+numero+"%");
             
            rs = stmt.executeQuery();
            
            while (rs.next()) {                
                Pedido pedido = new Pedido();
                pedido.setNumero(rs.getInt("numero"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setNome(rs.getString("nome"));
                pedido.setPagamento(rs.getString("pagamento"));
                pedido.setTroco(rs.getString("troco"));
                pedido.setBairro(rs.getString("bairro"));
                pedido.setData(rs.getString("data"));
                
                pedidos.add(pedido);
            }
                    
                    } catch (SQLException ex) {
            Logger.getLogger(PedidoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro na leitura: "+ex);
        }finally{
        ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return pedidos;
        
        
    }
           
       
}
