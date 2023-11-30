package Entidad;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Tecnicos")
public class Tecnico implements Serializable{


	private static final long serialVersionUID = 1L;
	
	//atributos
	
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTecnico;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Apellido")
    private String apellido;
    
    @Column(name = "DNI")
    private int dni;
    
    @Column(name = "CUIL")
    private String cuil;
        
	//Constructor
    
    
    
	public Tecnico(String nombre, String apellido, int dni, String cuil,Especialidad especialidad) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuil = cuil;
		this.especialidad = especialidad;

	}
  

    public Tecnico() {
	}


	//relaciones
    
    @ManyToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    @ManyToMany(mappedBy = "tecnicos")
    private List<Incidente> incidentes;
    
    
	// Getters - Setters
	
	public int getidCliente() {
		return idTecnico;
	}

	public void setidCliente(int idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}
	
	//toString
	@Override
	public String toString() {
		return "Tecnico [idTecnico=" + idTecnico + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", cuil=" + cuil + "]";
	}

	

}