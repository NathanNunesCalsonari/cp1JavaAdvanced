import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException; 

public class Cliente {     
	
	public static void main(String[] args) {         
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProdutoPU");         
		EntityManager em = emf.createEntityManager();         
		try {             
			int produtoId = 1;             
			Produto produto = em.find(Produto.class, produtoId);             
			System.out.println("Informações do produto recebidas do servidor:");             
			System.out.println(produto);         
			} finally 
		{             
				em.close();             
				emf.close();         
				}     
		} }