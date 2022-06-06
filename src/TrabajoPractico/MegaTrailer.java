package TrabajoPractico;

public class MegaTrailer extends Transporte {
	
	double CostoComida;
	private boolean EnViaje;
	private double CostoFijo;
	private double segCarga;
	
	public MegaTrailer(String numIdentificacion, double pesoMax, double volumenMax, double costoDeKmPorViaje,
			boolean equipoRefrigeracion,double costoComida,boolean EnViaje,String Destino,double CostoFijo ,double segCarga) {
		super(numIdentificacion, pesoMax, volumenMax, costoDeKmPorViaje, equipoRefrigeracion, Destino, EnViaje);
		this.CostoComida=costoComida;	
		this.CostoFijo=CostoFijo;
		this.segCarga=segCarga;
		
	}
	
	
	@Override
	public String verDatos() {
		return " Matricula:" + this.NumIdentificacion + " PesoMax:" + this.pesoMax + " Volumen:" +this.VolumenMax+" Costo de kilometro por viaje" + this.CostoDeKmPorViaje+
				" Tiene Equipo de refrigeracion:" + this.EquipoRefrigeracion + " Destino:" + this.Destino + " Esta en Viaje:" + this.EnViaje+ " Valor Seguro De carga:"+ this.segCarga+
				" Costo de la comida:"+ this.CostoComida + " Costo fijo:"+this.CostoFijo;
	}
	
	
	public double getSegCarga() {
		return segCarga;
	}


	public double getCostoComida() {
		return CostoComida;
	}

	public double getCostoFijo() {
		return CostoFijo;
	}



	public boolean isEnViaje() {
		return EnViaje;
	}

	public void setEnViaje(boolean enViaje) {
		EnViaje = enViaje;
	}






	

}
