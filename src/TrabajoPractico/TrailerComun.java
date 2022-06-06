package TrabajoPractico;

public class TrailerComun extends Transporte {
	
	private double SegCarga;
	
	
	public TrailerComun(String numIdentificacion, double pesoMax, double volumenMax, double costoDeKmPorViaje,
			boolean equipoRefrigeracion , boolean Enviaje,String Destino,double SegCarga) {
		super(numIdentificacion, pesoMax, volumenMax, costoDeKmPorViaje, equipoRefrigeracion, Destino, Enviaje);
		this.SegCarga=SegCarga;
	}
	

	public double getSegCarga() {
		return SegCarga;
	}

	@Override
	public String verDatos() {
	
		return " Matricula:" + this.NumIdentificacion + " PesoMax:" + this.pesoMax + " Volumen:" +this.VolumenMax+" Costo de kilometro por viaje" + this.CostoDeKmPorViaje+
				" Tiene Equipo de refrigeracion:" + this.EquipoRefrigeracion + " Destino:" + this.Destino + " Esta en Viaje:" + this.EnViaje + " Valor del Seguro de Carga:"+this.SegCarga;
	}
	
	
	

}
