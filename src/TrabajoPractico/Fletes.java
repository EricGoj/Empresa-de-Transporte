package TrabajoPractico;

public class Fletes extends Transporte {
	
	private int CantidadAcompañantes;
	private double CostoPorAcompaniante;
	private boolean EnViaje;
	

	public Fletes(String numIdentificacion, double pesoMax, double volumenMax, double costoDeKmPorViaje,
			boolean equipoRefrigeracion,int cantidadAcompañantes,String Destino , boolean EnViaje,double Costoporacompañante) {
		super(numIdentificacion, pesoMax, volumenMax, costoDeKmPorViaje, equipoRefrigeracion, Destino, EnViaje);
		this.CantidadAcompañantes=cantidadAcompañantes;	
		this.CostoPorAcompaniante=Costoporacompañante;
	}

	
	@Override
	public String verDatos() {
		return " Matricula:" + this.NumIdentificacion + " PesoMax:" + this.pesoMax + " Volumen:" +this.VolumenMax+" Costo de kilometro por viaje" + this.CostoDeKmPorViaje+
				" Tiene Equipo de refrigeracion:" + this.EquipoRefrigeracion + " Destino:" + this.Destino + " Esta en Viaje:" + this.EnViaje+ " Cantidad de acompañantes:"+ 
				this.CantidadAcompañantes+ " CostoPorAcompañante" + this.CostoPorAcompaniante;
	}

	public boolean isEnViaje() {
		return EnViaje;
	}

	public int getCantidadAcompañantes() {
		return CantidadAcompañantes;
	}


	public double getCostoPorAcompaniante() {
		return CostoPorAcompaniante;
	}


	public void setEnViaje(boolean enViaje) {
		EnViaje = enViaje;
	}
	
	

}
