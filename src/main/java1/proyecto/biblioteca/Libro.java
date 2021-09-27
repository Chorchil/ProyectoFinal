package proyecto.biblioteca;
import java.time.LocalDate;
public class Libro {
	private String nombre;
	private String codigo;
	private String autor;
	private int anioPublicacion;
	private String editorial;
	private int cantPag;
	private int precio;
	private String estado;
	private int cedula;
	private LocalDate fechaReserva= LocalDate.now();
	
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public LocalDate getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(LocalDate fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public int getAnioPublicacion() {
		return anioPublicacion;
	}
	public void setAnioPublicacion(int anioPublicacion) {
		this.anioPublicacion = anioPublicacion;
	}
	public String getEditorial() {
		return editorial;
	}
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	public int getCantPag() {
		return cantPag;
	}
	public void setCantPag(int cantPag) {
		this.cantPag = cantPag;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Libros: \n"
				+ "Codigo: " + codigo + "- Nombre:" + nombre + "- Autor:" + autor + "- Año: "
				+ anioPublicacion + 
				"- Estado=" + estado ;
	}
	public String toString2() {
		return "Libros: \n"
				+ "Codigo: " + codigo + "- Nombre:" + nombre + "- Estado: " + estado + "- Fecha de entrega: "
				+ (fechaReserva.plusDays(5)) + 
				"- Reservado por:" + cedula ;
	}
	
	

}
