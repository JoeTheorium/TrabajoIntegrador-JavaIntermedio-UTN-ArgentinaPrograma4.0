package Entidad;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table (name = "Clientes")
public class Cliente implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	// atributos
	
    @Id
    @Column (name = "IdCliente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCliente;
    
    @Column (name ="Nombre")
    private String nombre;
    
    @Column(name ="Apellido")
    private String apellido;
    
    @Column(name = "DNI")
    private int dni;
    
    @Column(name = "CUIL")
    private String cuil;
    
    // constructor
    public Cliente() {
    }
    
	public Cliente(String nombre, String apellido, int dni, String cuil) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.cuil = cuil;

	}
    
    // relaciones

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Incidente> incidentes;

    // Getters and setters


	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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
	
	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	//toString
	
    @Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", dni="
				+ dni + ", cuil=" + cuil +"]";
	}

}
