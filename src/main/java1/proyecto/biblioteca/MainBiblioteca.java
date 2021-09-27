package proyecto.biblioteca;

import java.util.*;
import java.time.LocalDate;

public class MainBiblioteca {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner lectorS = new Scanner(System.in);
		Scanner lectorI = new Scanner(System.in);
		String nombre;
		String codigo;
		String autor;
		int anioPublicacion;
		String editorial;
		int cantPag;
		int precio;
		String estado;
		int menu = 0;
		String opEstu = "";
		String opBiblio = "";
		List<Libro> listaLibros = new ArrayList<Libro>();
		String menuRegistro;
		String tipoLibro;
		String codigoAutorizacion;
		int tiempoLectura;
		String busqueda;
		String busquedaCodigo;
		int cedula;
		LocalDate fechaReserva = LocalDate.now();
		String decicionPrestamo;
		int busquedaCedula;
		String estadoBusqueda;
		String desicionAplazar;
		LocalDate fechaAplazada=fechaReserva.plusDays(5);
		do {
			System.out.println("****************************************************************");
			System.out.println("BIENVENIDOS AL SISTEMA DE BIBLIOTECA DE LA UNIVERSIDAD CENTRAL DEL ECUADOR!!");
			System.out.println(
					"Pulse 1 para acceder al menu de estudiantes\nPulse 2 para el menu de Bibliotecario\nPulse 3 para SALIR");
			System.out.println("****************************************************************");
			menu = lectorI.nextInt();
			switch (menu) {
			case 2:
				System.out.println(
						"Digite 'a' para registrar un libro.\nDigite 'b' para prestar un libro.\nDigite 'c' para aplazar la fecha de entrega.");

				opBiblio = lectorS.nextLine();
				if (opBiblio.equals("a")) {
					System.out.println("Para registrar un libro ingrese los datos correspondientes.");
					do {
						Libro libroi = new Libro();
						System.out.println("Nombre: ");
						libroi.setNombre(nombre = lectorS.nextLine());
						System.out.println("Autor: ");
						libroi.setAutor(autor = lectorS.nextLine());
						System.out.println("Año de publicación: ");
						libroi.setAnioPublicacion(anioPublicacion = lectorI.nextInt());
						System.out.println("Codigo: ");
						libroi.setCodigo(codigo = lectorS.nextLine());
						System.out.println("Cantidad de paginas: ");
						libroi.setCantPag(cantPag = lectorI.nextInt());
						System.out.println("Editorial: ");
						libroi.setEditorial(editorial = lectorS.nextLine());
						System.out.println("Precio: ");
						libroi.setPrecio(precio = lectorI.nextInt());
						System.out.println("Estado: ");
						libroi.setEstado(estado = lectorS.nextLine());

						listaLibros.add(libroi);

						System.out.println(
								"Que tipo de libro es el libro ingresado\n1.Libro de trabajo:\n2.Libro de lectura:");
						tipoLibro = lectorS.nextLine();
						if (tipoLibro.equals("1")) {
							System.out.println("Ingrese el codigo de autorizacion:");
							codigoAutorizacion = lectorS.nextLine();
						} else if (tipoLibro.equals("2")) {
							System.out.println("Ingrese el tiempo que se dedicara a la lectura (minutos)");
							tiempoLectura = lectorI.nextInt();
						}
						System.out.println("Libro ingresado exitosamente!!!");
						System.out.println("Desea ingresar un nuevo libro?\nS(si)\nN(no): ");
						menuRegistro = lectorS.nextLine();

					} while (menuRegistro.equals("S"));

				} else if (opBiblio.equals("b")) {
					System.out.println("Ingrese el codigo del libro a ser prestado: ");
					busquedaCodigo = lectorS.nextLine();
					for (int k = 0; k < listaLibros.size(); k++) {
						if (busquedaCodigo.equals(listaLibros.get(k).getCodigo())) {
							if (listaLibros.get(k).getEstado().equals("Reservado")) {
								System.out.println(listaLibros.get(k).toString2());
								System.out.println("'Prestar' o 'No Prestar'");
								decicionPrestamo = lectorS.nextLine();
								if (decicionPrestamo.contains("Prestar")) {
									listaLibros.get(k).setEstado("Prestado");
									System.out.println(listaLibros.get(k).toString2());
								} else {
									System.out.println("El libro no se prestara, disculpe las molestias.");
								}
							}
						}
					}
				}

				else if (opBiblio.equals("c")) {
					System.out.println(
							"Ingrese el codigo del libro y la cedula del estudiante al que se le presto el libro");
					System.out.println("Ingrese el codigo del libro: ");
					busquedaCodigo = lectorS.nextLine();
					System.out.println("Ingrese la cedula del estudiante:");
					busquedaCedula = lectorI.nextInt();
					
					for (int l = 0; l < listaLibros.size(); l++) {
		estadoBusqueda=listaLibros.get(l).getEstado();
						if (busquedaCodigo.equals(listaLibros.get(l).getCodigo()) && busquedaCedula==listaLibros.get(l).getCedula() && estadoBusqueda==listaLibros.get(l).getEstado()) {
							System.out.println(listaLibros.get(l).toString2());
							System.out.println("'Aplazar' o 'No Aplazar'");
							desicionAplazar=lectorS.nextLine();
							if(desicionAplazar.equals("Aplazar")) {
								System.out.println("La fecha de entrega se aplazo!!");
								System.out.println("Nueva fecha de entrega: "+ (fechaAplazada.plusDays(5)));
							}else {
								System.out.println("No se aplazo la fecha de entrega!!");
							}
							

						}else {System.out.println("No se encontro el libro!!");}
					}
				}
				break;
			case 1:
				System.out.println("Digite 'a' si desea consultar un libro.\nDigite 'b' si desea reservar un libro.");
				opEstu = lectorS.nextLine();
				if (opEstu.equals("a")) {
					System.out.println("Para consultar un libro digite el nombre o autor del libro");
					busqueda = lectorS.nextLine();
					for (int i = 0; i < listaLibros.size(); i++) {
						if (busqueda.contains(listaLibros.get(i).getNombre())
								|| busqueda.contains(listaLibros.get(i).getAutor())) {
							System.out.println("Libro consultado: ");
							System.out.println(listaLibros.get(i).toString());
						} else {
							System.out.println("Libro no encontrado");
						}
					}

				} else if (opEstu.equals("b")) {
					System.out.println("Para reservar un libro ingrese su numero de cedula y el codigo del libro");
					System.out.println("Numero de cedula:");
					cedula = lectorI.nextInt();
					System.out.println("Codigo del libro");
					busquedaCodigo = lectorS.nextLine();
					for (int j = 0; j < listaLibros.size(); j++) {
						if (busquedaCodigo.equals(listaLibros.get(j).getCodigo())) {
							listaLibros.get(j).setCedula(cedula);
							if (listaLibros.get(j).getEstado().equals("Disponible")) {
								listaLibros.get(j).setEstado("Reservado");
								System.out.println("Libro reservado exitosamente, pase a retirarlo a la biblioteca.");
								System.out.println("Fecha de entrega: " + (fechaReserva.plusDays(5)));
								System.out.println("");
							} else {
								System.out.println("El libro no esta disponible");
							}

						}
					}

				}
				break;
			case 3:
				System.out.println("Fin del programa, gracias por usar la biblioteca!!");
				break;
			default:
				System.out.println("Opcion ingresada incorrecta, por favor intentelo de nuevo.");
				break;

			}

		} while (menu != 3);

	}

}
