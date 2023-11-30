package Dao;
import org.hibernate.Query;
import org.hibernate.Session;
import java.util.List;
import Entidad.Cliente;


public class DaoCliente {
	public static void limpiarDatos() {
	    DaoCliente daoCliente = new DaoCliente();
	    daoCliente.DeleteAll();}
	
	public void DeleteAll() {
        ConfigHibernate config = new ConfigHibernate();
        Session session = config.abrirConexion();

        org.hibernate.Transaction transaction = session.beginTransaction();

        try {
            // Obtengo la lista de clientes
            List<Cliente> clientes = GetAll();

            // Elimino cada cliente
            for (Cliente cliente : clientes) {
                session.delete(cliente);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            config.cerrarSession();
        }
    }
	

	public List<Cliente> GetAll() {
        ConfigHibernate config = new ConfigHibernate();
        Session session = config.abrirConexion();

        session.beginTransaction();
        List<Cliente> clientes = session.createQuery("FROM Cliente").list();

        config.cerrarSession();

        return clientes;
    }
	
	public Long contarClientes() {
	    ConfigHibernate config = new ConfigHibernate();
	    Session session = config.abrirConexion();

	    session.beginTransaction();

	    try {
	        String queryString = "SELECT COUNT(c.idCliente) FROM Cliente c";
	        Query query = session.createQuery(queryString);

	        return (Long) query.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        config.cerrarSession();
	    }

	    return null;
	}
	
	public void Add(Cliente cliente)
	{
		ConfigHibernate ch = new ConfigHibernate();
        Session session = ch.abrirConexion();

        session.beginTransaction();
        session.save(cliente);

        session.getTransaction().commit();
        ch.cerrarSession();
	}
	
	
	public Cliente ReadOne(int idCliente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Cliente clientes=(Cliente)session.get(Cliente.class,idCliente);
      
        config.cerrarSession();
        
        return clientes;
	}
	
	public void Update (Cliente cliente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.merge(cliente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Cliente idCliente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(idCliente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
