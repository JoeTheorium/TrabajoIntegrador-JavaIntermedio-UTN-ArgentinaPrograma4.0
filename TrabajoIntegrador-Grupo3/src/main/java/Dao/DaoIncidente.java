package Dao;

import java.util.List;

import org.hibernate.Session;

import Entidad.Incidente;

public class DaoIncidente {

	public static void limpiarDatos() {
	    DaoIncidente daoIncidente = new DaoIncidente();
	    daoIncidente.DeleteAll();
	}

	public void DeleteAll() {
	    ConfigHibernate config = new ConfigHibernate();
	    Session session = config.abrirConexion();

	    org.hibernate.Transaction transaction = session.beginTransaction();

	    try {
	        // Obtengo la lista de incidentes
	        List<Incidente> incidentes = GetAll();

	        // Elimino cada incidente
	        for (Incidente incidente : incidentes) {
	            session.delete(incidente);
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        config.cerrarSession();
	    }
	}
	
	public List<Incidente> GetAll() {
	    ConfigHibernate config = new ConfigHibernate();
	    Session session = config.abrirConexion();

	    session.beginTransaction();
	    List<Incidente> incidentes = session.createQuery("FROM Incidente i LEFT JOIN FETCH i.tecnicos").list();

	    config.cerrarSession();

	    return incidentes;
	}
	
	public void Add(Incidente incidentes)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(incidentes);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Incidente ReadOne(int nroIncidente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Incidente incidentes=(Incidente)session.get(Incidente.class,nroIncidente);
        
        config.cerrarSession();
        
        return incidentes;
	}
	
	public void Update(Incidente nroIncidente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(nroIncidente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Incidente nroIncidente)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(nroIncidente);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
