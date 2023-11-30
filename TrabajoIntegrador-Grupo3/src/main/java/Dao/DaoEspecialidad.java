package Dao;

import org.hibernate.Session;

import Entidad.Especialidad;
import java.util.List;

public class DaoEspecialidad {

	public static void limpiarDatos() {
	    DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
	    daoEspecialidad.DeleteAll();
	}

	public void DeleteAll() {
	    ConfigHibernate config = new ConfigHibernate();
	    Session session = config.abrirConexion();

	    org.hibernate.Transaction transaction = session.beginTransaction();

	    try {
	        // Obtengo la lista de especialidades
	        List<Especialidad> especialidades = GetAll();

	        // Elimino cada especialidad
	        for (Especialidad especialidad : especialidades) {
	            session.delete(especialidad);
	        }

	        transaction.commit();
	    } catch (Exception e) {
	        transaction.rollback();
	        e.printStackTrace();
	    } finally {
	        config.cerrarSession();
	    }
	}

	public List<Especialidad> GetAll() {
	    ConfigHibernate config = new ConfigHibernate();
	    Session session = config.abrirConexion();

	    session.beginTransaction();
	    List<Especialidad> especialidades = session.createQuery("FROM Especialidad").list();

	    config.cerrarSession();

	    return especialidades;
	}
	
	
	public void Add(Especialidad idEspecialidad)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(idEspecialidad);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Especialidad ReadOne(int idEspecialidad)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
		Especialidad especialidades=(Especialidad)session.get(Especialidad.class,idEspecialidad);
        
        config.cerrarSession();
        
        return especialidades;
	}
	
	public void Update(Especialidad idEspecialidad)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(idEspecialidad);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Especialidad idEspecialidad) 
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(idEspecialidad);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
