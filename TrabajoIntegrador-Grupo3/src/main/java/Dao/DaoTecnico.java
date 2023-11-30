package Dao;

import org.hibernate.Query;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;

import Entidad.Especialidad;
import Entidad.Tecnico;

public class DaoTecnico {

	public static void limpiarDatos() {
        DaoTecnico daoTecnico = new DaoTecnico();
        daoTecnico.DeleteAll();
    }

    public void DeleteAll() {
        ConfigHibernate config = new ConfigHibernate();
        Session session = config.abrirConexion();

        org.hibernate.Transaction transaction = session.beginTransaction();

        try {
            // Obtengo la lista de técnicos
            List<Tecnico> tecnicos = GetAll();

            // Elimino cada técnico
            for (Tecnico tecnico : tecnicos) {
                session.delete(tecnico);
            }

            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            config.cerrarSession();
        }
    }

    public List<Tecnico> GetAll() {
        ConfigHibernate config = new ConfigHibernate();
        Session session = config.abrirConexion();

        session.beginTransaction();
        List<Tecnico> tecnicos = session.createQuery("FROM Tecnico").list();

        config.cerrarSession();

        return tecnicos;
    }
    
    public Long contarTecnicosPorEspecialidad(Especialidad especialidad) {
        ConfigHibernate config = new ConfigHibernate();
        Session session = config.abrirConexion();

        session.beginTransaction();

        try {
            String queryString = "SELECT COUNT(t.idTecnico) " +
                "FROM Tecnico t " +
                "WHERE t.especialidad = :especialidad";

            // Utilizo la interfaz Query de Hibernate
            Query query = session.createQuery(queryString);
            query.setParameter("especialidad", especialidad);

            Long cantidadTecnicos = (Long) query.uniqueResult();

            return cantidadTecnicos;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            config.cerrarSession();
        }

        return 0L;
    }
    /*
    public void obtenerTecnicoConMasIncidentesResueltosEnUltimosNDias(Date fechaInicio) {
        ConfigHibernate config = new ConfigHibernate();
        Session session = config.abrirConexion();

        session.beginTransaction();

            Query consultaA = em.createQuery("SELECT t.nombre, COUNT(i) as cantidadIncidentes " +
                                        "FROM Tecnico t JOIN t.incidentes i " +
                                        "WHERE i.fechaResolucion >= :fechaInicio " +
                                        "GROUP BY t.nombre " +
                                        "ORDER BY cantidadIncidentes DESC")
                           .setParameter("fechaInicio", fechaInicio)
                           .setMaxResults(1);

        Object[] resultadoA = (Object[]) consultaA.getSingleResult();
        String nombreTecnicoMasIncidentes = (String) resultadoA[0];
        Long cantidadIncidentes = (Long) resultadoA[1];
        System.out.println("a. Técnico con más incidentes resueltos: " + nombreTecnicoMasIncidentes
                + ", Cantidad de incidentes: " + cantidadIncidentes);*/
    
	public void Add(Tecnico tecnicos)
	{
		ConfigHibernate ch = new ConfigHibernate();
		Session session= ch.abrirConexion();
		     
	    session.beginTransaction();
	    session.save(tecnicos);
	    
	    session.getTransaction().commit();    
		ch.cerrarSession();
	}
	
	public Tecnico ReadOne(int idTecnico)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
		session.beginTransaction();
        Tecnico tecnicos=(Tecnico)session.get(Tecnico.class,idTecnico);
        
        config.cerrarSession();
        
        return tecnicos;
	}
	
	public void Update(Tecnico tecnicos)
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.update(tecnicos);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
	
	public void Delete(Tecnico tecnicos) 
	{
		ConfigHibernate config = new ConfigHibernate();
		Session session= config.abrirConexion();
		
        session.beginTransaction();
        session.delete(tecnicos);
        session.getTransaction().commit();        
        
        config.cerrarSession();
	}
}
