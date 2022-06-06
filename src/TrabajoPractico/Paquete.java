package TrabajoPractico;

public class Paquete  {
	
	

	private Integer CodigoPaquete;
	private double Peso;
	private double Volumen;
	private String Destino;
	private boolean Refrigeracion;
	private boolean EnViaje;

	public Paquete(Integer codigoPaquete, double peso, double volumen, String destino, boolean refrigeracion,boolean enViaje) {
		super();
		this.CodigoPaquete = codigoPaquete;
		this.Peso=peso;
		this.Volumen = volumen;
		this.Destino = destino;
		this.Refrigeracion = refrigeracion;
		this.EnViaje = enViaje;
	}
	
	
	
	@Override
	public String toString() {
		return "Paquete [CodigoPaquete=" + CodigoPaquete + ", Peso=" + Peso + ", Volumen=" + Volumen + ", Destino="
				+ Destino + ", Refrigeracion=" + Refrigeracion + ", EnViaje=" + EnViaje + "]";
	}



	public double getPeso() {
		return Peso;
	}

	public double getVolumen() {
		return Volumen;
	}
	
	public Integer getCodigoPaquete() {
		return CodigoPaquete;
	}


	public void setCodigoPaquete(Integer codigoPaquete) {
		CodigoPaquete = codigoPaquete;
	}

	public String getDestino() {
		return Destino;
	}



	public void setDestino(String destino) {
		Destino = destino;
	}

	public boolean isRefrigeracion() {
		return Refrigeracion;
	}

	public void setRefrigeracion(boolean refrigeracion) {
		Refrigeracion = refrigeracion;
	}

	public boolean isEnViaje() {
		return EnViaje;
	}

	public void setEnViaje(boolean enViaje) {
		EnViaje = enViaje;
	}



	public void setPeso(double peso) {
		Peso = peso;
	}

		
}
