package publicacion;

import java.util.ArrayList;
import java.util.Calendar;

import inmueble.Inmueble;

public class Publicacion {
	private Inmueble inmueble;
	private Calendar fechaInicio;
	private Calendar fechaFin;
	private int checkIn;
	private int checkOut;
	private ArrayList<Foto> fotos;
	private ArrayList<PrecioPeriodo> precio;
	private ArrayList<Periodo> periodoOcupado;
	private ArrayList<Observer> observadorBajaPrecio;
	
	public Publicacion(Inmueble inmueble, Calendar inicio, Calendar fin, Integer checkIn, Integer checkOut, ArrayList<Foto> fotos, ArrayList<PrecioPeriodo> precio) {
		this.inmueble = inmueble;
		this.fechaInicio = inicio;
		this.fechaFin = fin;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.fotos = fotos;
		this.precio = precio;
		this.periodoOcupado = new ArrayList<Periodo>();
		this.observadorBajaPrecio = new ArrayList<Observer>();
		
	}
	
	public void registrarOcupacion(Calendar inicio, Calendar fin) {
		periodoOcupado.add(new Periodo(inicio, fin));
	}
	public boolean estaDisponibleEntre(Calendar fechaDesde, Calendar fechaHasta) {
		return true;
	}

	public ArrayList<Periodo> getPeriodosOcupados() {
		
		return periodoOcupado;
	}
	

}
