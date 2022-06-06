package TrabajoPractico;

public class Fletes extends Transporte {
	
	private int CantidadAcompa�antes;
	private double CostoPorAcompaniante;
	private boolean EnViaje;
	

	public Fletes(String numIdentificacion, double pesoMax, double volumenMax, double costoDeKmPorViaje,
			boolean equipoRefrigeracion,int cantidadAcompa�antes,String Destino , boolean EnViaje,double Costoporacompa�ante) {
		super(numIdentificacion, pesoMax, volumenMax, costoDeKmPorViaje, equipoRefrigeracion, Destino, EnViaje);
		this.CantidadAcompa�antes=cantidadAcompa�antes;	
		this.CostoPorAcompaniante=Costoporacompa�ante;
	}

	
	@Override
	public String verDatos() {
		return " Matricula:" + this.NumIdentificacion + " PesoMax:" + this.pesoMax + " Volumen:" +this.VolumenMax+" Costo de kilometro por viaje" + this.CostoDeKmPorViaje+
				" Tiene Equipo de refrigeracion:" + this.EquipoRefrigeracion + " Destino:" + this.Destino + " Esta en Viaje:" + this.EnViaje+ " Cantidad de acompa�antes:"+ 
				this.CantidadAcompa�antes+ " CostoPorAcompa�ante" + this.CostoPorAcompaniante;
	}

	public boolean isEnViaje() {
		return EnViaje;
	}

	public int getCantidadAcompa�antes() {
		return CantidadAcompa�antes;
	}


	public double getCostoPorAcompaniante() {
		return CostoPorAcompaniante;
	}


	public void setEnViaje(boolean enViaje) {
		EnViaje = enViaje;
	}
	
	

}
