
package Control;

import BancoDados.ConexaoBanco;
import Model.Clientes;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
public class ClienteDAO {
    private Connection conecta;
    
    public ClienteDAO(){
    conecta = new ConexaoBanco().getConnection();
    }

    public void cadastrarCliente(Clientes dados){
       
        try{
            String sql = "INSERT INTO tb_cliente(nome,cpf,celular,email) VALUES"
                +"(?,?,?,?)";
         PreparedStatement insere = conecta.prepareStatement(sql);
         insere.setString(1,dados.getNome());
         insere.setString(2,dados.getCpf());
         insere.setString(3,dados.getCelular());
         insere.setString(4,dados.getEmail());
         insere.execute();
         insere.close();
        JOptionPane.showMessageDialog(null,"CADASTRO COM ÊXITO");
        }catch (Exception erro){
            JOptionPane.showMessageDialog(null,"CADASTRO ERRO"+erro);
        }
    }

}
