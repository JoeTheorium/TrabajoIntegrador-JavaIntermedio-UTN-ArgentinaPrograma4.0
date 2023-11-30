package Main;


import org.hibernate.Session;

import java.util.Arrays;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import Dao.DaoCliente;
import Dao.DaoEspecialidad;
import Dao.DaoIncidente;
import Dao.DaoTecnico;
import Entidad.Cliente;
import Entidad.Especialidad;
import Entidad.Incidente;
import Entidad.Tecnico;

public class Main {

	public static void main(String[] args) {
		
		//cargarDatos();
	}
	public static void cargarDatos() {
    	SessionFactory sessionFactory;
    	Configuration configuration = new Configuration();
    	configuration.configure();	
    	ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
    	sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    	Session session = sessionFactory.openSession();
 
    	session.beginTransaction();
    	
    	// Clientes
        Cliente cliente1 = new Cliente("Juan", "Perez", 1453513, "34-7878544-23");
        Cliente cliente2 = new Cliente("Matias", "Sanchez", 3462323, "34-5645645-23");
        Cliente cliente3 = new Cliente("Agustin", "Ampudia", 4568794, "34-453453-23");
        Cliente cliente4 = new Cliente("Lucia", "Koltun", 35366432, "34-4353453-23");
        Cliente cliente5 = new Cliente("Micaela", "Sanchez", 63650963, "34-346434-23");

        DaoCliente daoCliente = new DaoCliente();
        daoCliente.Add(cliente1);
        daoCliente.Add(cliente2);
        daoCliente.Add(cliente3);
        daoCliente.Add(cliente4);
        daoCliente.Add(cliente5);

	    // Especialidad
	    
	    Especialidad especialidad1 = new Especialidad("Programacion");
	    Especialidad especialidad2 = new Especialidad("Seguridad en redes");
	    Especialidad especialidad3 = new Especialidad("Administracion de sistemas");
	    
	    DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
	    daoEspecialidad.Add(especialidad1);
	    daoEspecialidad.Add(especialidad2);
	    daoEspecialidad.Add(especialidad3);
	    
	    
		// Tecnico

		Tecnico tecnico1 = new Tecnico("Facundo","Farias",42545434,"12-23523643-23",especialidad1);
		Tecnico tecnico2 = new Tecnico("Gonzalo","Quinero",44564563,"25-76767675-21",especialidad1);
		Tecnico tecnico3 = new Tecnico("Fernanda","Perez",456456523,"74-54544543-29",especialidad2);
		Tecnico tecnico4 = new Tecnico("Emiliano","Cuadros",452324598,"64-4543534-33",especialidad3);
		Tecnico tecnico5 = new Tecnico("Tomas","Grossman",45778234,"24-3423432-36",especialidad3);
		
		DaoTecnico daoTecnico = new DaoTecnico();
	    daoTecnico.Add(tecnico1);
	    daoTecnico.Add(tecnico2);
	    daoTecnico.Add(tecnico3);
	    daoTecnico.Add(tecnico4);
	    daoTecnico.Add(tecnico5);
 
	    
        // Incidentes
	    
	    Incidente incidente1 = new Incidente("Error en el SO", "10/02/2023", "Pendiente", cliente1, Arrays.asList(tecnico1, tecnico2), especialidad1);
	    Incidente incidente2 = new Incidente("Fallas en el Hardware", "14/05/2023", "Pendiente", cliente2, Arrays.asList(tecnico3), especialidad2);
	    Incidente incidente3 = new Incidente("Actualizacion", "04/09/2023", "Pendiente", cliente3, Arrays.asList(tecnico4, tecnico5), especialidad3);
	    Incidente incidente4 = new Incidente("Virus", "21/11/2023", "Pendiente", cliente4, Arrays.asList(tecnico1), especialidad1);
	    Incidente incidente5 = new Incidente("Instalar Software", "23/10/2023", "Pendiente", cliente5, Arrays.asList(tecnico2), especialidad2);

        DaoIncidente daoIncidente = new DaoIncidente();
        daoIncidente.Add(incidente1);
        daoIncidente.Add(incidente2);
        daoIncidente.Add(incidente3);
        daoIncidente.Add(incidente4);
        daoIncidente.Add(incidente5);
        
		

}

}
