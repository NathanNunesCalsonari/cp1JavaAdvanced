import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
public class Servidor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProdutoPU");
        EntityManager em = emf.createEntityManager();
 
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Servidor aguardando conexão...");
 
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado: " + socket.getInetAddress());
 
                Thread t = new Thread(new ServidorThread(socket, em));
                t.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
 
class ServidorThread implements Runnable {
    private Socket socket;
    private EntityManager em;
 
    public ServidorThread(Socket socket, EntityManager em) {
        this.socket = socket;
        this.em = em;
    }
 
    @Override
    public void run() {
        try {
            int produtoId = 1; 
            Produto produto = buscarProdutoNoBancoDeDados(produtoId);
 
            System.out.println("Enviando informações do produto para o cliente...");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
 
    private Produto buscarProdutoNoBancoDeDados(int produtoId) {
        TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p WHERE p.id = :id", Produto.class);
        query.setParameter("id", produtoId);
        return query.getSingleResult();
    }
}