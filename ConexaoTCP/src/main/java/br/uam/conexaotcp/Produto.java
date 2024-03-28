import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
 
@Entity
public class Produto implements Serializable {
    @Id
    private int id;
    private String nome;
    private double preco;
    private String validade;
    private String tamanho;
    private String descricao;
 
 
    @Override
    public String toString() {
        return "ID: " + id + "\n" +
                "Nome: " + nome + "\n" +
                "Preço: " + preco + "\n" +
                "Validade: " + validade + "\n" +
                "Tamanho: " + tamanho + "\n" +
                "Descrição: " + descricao;
    }
}