package Entidad;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "Especialidades")
public class Especialidad implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	//atributos
	
    @Id
    @Column(name = "IdEspecialidad")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEspecialidad;

    @Column (name = "NombreEspecialidad")
    private String nombreEspecialidad;
    
    //constructor
    
    

    //relacion
    
    public String getNombreEspecialidad() {
		return nombreEspecialidad;
	}

	public void setNombreEspecialidad(String nombreEspecialidad) {
		this.nombreEspecialidad = nombreEspecialidad;
	}

	@OneToMany(mappedBy = "especialidad")
    private List<Tecnico> tecnicos;
    
    //constructor
    
    public Especialidad() {
	}
    
    public Especialidad(String nombreEspecialidad) {
		super();
		this.nombreEspecialidad = nombreEspecialidad;

	}
    
	// Getters - Setters
	
	

	public int getidEspecialidad() {
		return idEspecialidad;
	}

	public void setidEspecialidad(int idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}
	
	//toString
	
	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", nombreEspecialidad=" + nombreEspecialidad + "]";
	}
	
}

