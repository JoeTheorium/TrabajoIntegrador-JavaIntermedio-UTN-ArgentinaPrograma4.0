package Entidad;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Incidentes")
public class Incidente implements Serializable {

    private static final long serialVersionUID = 1L;

    // atributos
    @Id
    @Column(name = "nroIncidente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nroIncidente;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "FechaDeIngreso")
    private String fechaIngreso;

    @Column(name = "Estado")
    private String estado;

    // relaciones
    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "Incidente_Tecnico",
            joinColumns = @JoinColumn(name = "idIncidente"),
            inverseJoinColumns = @JoinColumn(name = "idTecnico")
    )
    private List<Tecnico> tecnicos;

    @OneToOne
    @JoinColumn(name = "idEspecialidad")
    private Especialidad especialidad;

    // constructor
    public Incidente(String descripcion, String fechaIngreso, String estado, Cliente cliente, List<Tecnico> tecnicos, Especialidad especialidad) {
        super();
        this.descripcion = descripcion;
        this.fechaIngreso = fechaIngreso;
        this.estado = estado;
        this.cliente = cliente;
        this.tecnicos = tecnicos;
        this.especialidad = especialidad;
    }

    public Incidente() {
    }

    // Getters - Setters
    public int getNroIncidente() {
        return nroIncidente;
    }

    public void setNroIncidente(int nroIncidente) {
        this.nroIncidente = nroIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public void setTecnicos(List<Tecnico> tecnicos) {
        this.tecnicos = tecnicos;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    // toString
    @Override
    public String toString() {
        return "Incidente [nroIncidente=" + nroIncidente + ", descripcion=" + descripcion + ", fechaIngreso="
                + fechaIngreso + ", estado=" + estado + ", cliente=" + cliente + ", tecnicos=" + tecnicos + ", especialidad=" + especialidad + "]";
    }
}
