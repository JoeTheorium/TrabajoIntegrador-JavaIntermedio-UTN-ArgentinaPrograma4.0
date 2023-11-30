package Main;

import Dao.DaoCliente;
import Dao.DaoEspecialidad;
import Dao.DaoIncidente;
import Dao.DaoTecnico;
import Entidad.Cliente;
import Entidad.Especialidad;
import Entidad.Incidente;
import Entidad.Tecnico;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//consulta();
		
		//cantidadDeClientes();
		//consultaClienteEnEspecifico();
		//actualizarUnClienteExistente();
		//tecnicosxEspecialidad();
		//eliminarUnClienteExistente();
		//deleteAllTecnicos();
		//deleteAllInsidentes();
		//deleteAllClientes();
		//deleteAllEspecialidad();
	}
	
	public static void consultarTecnicoConMasIncidentesResueltos(EntityManager em, Date fechaInicio) {
        try {
            // Realizar la consulta
            Query consulta = em.createQuery("SELECT t.nombre, COUNT(i) as cantidadIncidentes " +
                    "FROM Tecnico t JOIN t.incidentes i " +
                    "WHERE i.fechaResolucion >= :fechaInicio " +
                    "GROUP BY t.nombre " +
                    "ORDER BY cantidadIncidentes DESC")
                    .setParameter("fechaInicio", fechaInicio)
                    .setMaxResults(1);

            List<Object[]> resultados = consulta.getResultList();

            if (!resultados.isEmpty()) {
                Object[] resultado = resultados.get(0);
                String nombreTecnicoMasIncidentes = (String) resultado[0];
                Long cantidadIncidentes = (Long) resultado[1];
                System.out.println("Técnico con más incidentes resueltos: " + nombreTecnicoMasIncidentes
                        + ", Cantidad de incidentes: " + cantidadIncidentes);
            } else {
                System.out.println("No se encontraron resultados.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public static void deleteAllClientes() {
		//Clientes
        DaoCliente daoCliente = new DaoCliente();
        daoCliente.DeleteAll();
    }
	
	public static void deleteAllInsidentes() {
		//Insidentes
		DaoIncidente daoIncidente = new DaoIncidente();
		daoIncidente.DeleteAll();
    }
	
	public static void deleteAllEspecialidad() {
		//Especialidad
		DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
		daoEspecialidad.DeleteAll();
    }
	public static void deleteAllTecnicos() {
		//Tecnicos
		DaoTecnico daoTecnico = new DaoTecnico();
		daoTecnico.DeleteAll();
    }
	
	
	public static void consulta() {
		
   //Clientes
	DaoCliente daoCliente = new DaoCliente();
		
	// Imprimo clientes usando toString()
    System.out.println("Clientes registrados:");
    for (Cliente cliente : daoCliente.GetAll()) {
        System.out.println(cliente.toString());
    }
    
    
    
    
  //Incidentes
    DaoIncidente daoIncidente = new DaoIncidente();
    
    // Imprimo Incidentes usando toString()
    System.out.println("Incidentes registrados:");
    for (Incidente incidente : daoIncidente.GetAll()) {
        System.out.println(incidente.toString());
    }
    
	// Tecnico
    DaoTecnico daoTecnico = new DaoTecnico();
    
 // Imprimo Incidentes usando toString()
    System.out.println("Tecnicos registrados:");
    for (Tecnico tecnico : daoTecnico.GetAll()) {
        System.out.println(tecnico.toString());
    }
    
 // Especialidad
    
    DaoEspecialidad daoEspecialidad = new DaoEspecialidad();
    
    // Imprimo Incidentes usando toString()
    System.out.println("Especialidades registrados:");
    for (Especialidad especialidad : daoEspecialidad.GetAll()) {
        System.out.println(especialidad.toString());
    }
    
	}
	
	public static void eliminarUnClienteExistente() {
		
		DaoCliente daoCliente = new DaoCliente();
		
		int clienteIdToDelete = 130;
		Cliente clienteAEliminar = daoCliente.ReadOne(clienteIdToDelete);

		// Verificar si el cliente existe antes de intentar eliminarlo
		if (clienteAEliminar != null) {
		    // Eliminar el cliente de la base de datos
		    daoCliente.Delete(clienteAEliminar);
		} else {
		    System.out.println("Cliente no encontrado");
		}
	}

	public static void consultaClienteEnEspecifico() {
		
		DaoCliente daoCliente = new DaoCliente();
    
    // Leer un cliente específico por su idCliente
       int idClienteALeer = 126; // id que desees leer
       Cliente clienteLeido = daoCliente.ReadOne(idClienteALeer);

       // Verifico si el cliente existe
       if (clienteLeido != null) {
           // Imprimo los detalles del cliente en la consola
           System.out.println("Cliente leído:"+ clienteLeido);
       } else {
           System.out.println("Cliente no encontrado con idCliente: " + idClienteALeer);
       }
       
    
	}
	
	public static void actualizarUnClienteExistente() {

	    DaoCliente daoCliente = new DaoCliente();

	    int clienteIdToUpdate = 126;
	    Cliente clienteAActualizar = daoCliente.ReadOne(clienteIdToUpdate);

	    // Verifico si el cliente existe antes de intentar actualizarlo
	    if (clienteAActualizar != null) {
	        // Modifico los atributos del cliente
	        clienteAActualizar.setNombre("pedro");
	        clienteAActualizar.setApellido("jose");
	        clienteAActualizar.setDni(41444444);
	        clienteAActualizar.setCuil("22-212154545-5");

	        // Actualizo el cliente en la base de datos
	        daoCliente.Update(clienteAActualizar);
	        System.out.println(clienteAActualizar);
	    } else {
	        System.out.println("Cliente no encontrado");
	    }
	}
	
	public static void tecnicosxEspecialidad() {
	    DaoTecnico daoTecnico = new DaoTecnico();
	    DaoEspecialidad daoEspecialidad = new DaoEspecialidad();

	    int idEspecialidad = 93; // Reemplaza con el ID de la especialidad que deseas consultar
	    Especialidad especialidad = daoEspecialidad.ReadOne(idEspecialidad);

	    if (especialidad != null) {
	        Long cantidadTecnicos = daoTecnico.contarTecnicosPorEspecialidad(especialidad);
	        System.out.println("Cantidad de técnicos para la especialidad " + especialidad.getNombreEspecialidad() + ": " + cantidadTecnicos);
	    } else {
	        System.out.println("Especialidad no encontrada con ID: " + idEspecialidad);
	    }
	}
	
	
	public static void cantidadDeClientes() {
		
	    DaoCliente daoCliente = new DaoCliente();
	    
	    Long cantidadClientes = daoCliente.contarClientes();
	    System.out.println("Cantidad de clientes en el sistema: " + cantidadClientes);
	}
	

  

}

