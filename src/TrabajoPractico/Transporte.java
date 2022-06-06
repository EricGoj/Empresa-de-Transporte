package TrabajoPractico;

import java.util.HashMap;


public abstract class Transporte {
	
	protected String NumIdentificacion;
	protected double pesoMax;
	protected double VolumenMax;
	protected double CostoDeKmPorViaje;
	protected boolean EquipoRefrigeracion;
	protected String Destino;
	protected boolean EnViaje;
	private HashMap<Integer,Paquete> DepositoTransporte;
	
	
	public Transporte() {  // !
	}
	
	public Transporte(String numIdentificacion, double pesoMax, double volumenMax, double costoDeKmPorViaje,	boolean equipoRefrigeracion,String Destino,boolean EnViaje) {
		super();
		this.NumIdentificacion = numIdentificacion;
		this.pesoMax = pesoMax;
		this.VolumenMax = volumenMax;
		this.CostoDeKmPorViaje = costoDeKmPorViaje;
		this.EquipoRefrigeracion = equipoRefrigeracion;
		this.Destino=Destino;
		this.EnViaje=EnViaje;
		DepositoTransporte=new HashMap<Integer,Paquete>();
	}
	
	public abstract String verDatos() ;
	
	public int sizedepot() {
		return DepositoTransporte.size();
	}
	
	
	public void CambiarEstadoPaquetes() {
		for (Paquete p: DepositoTransporte.values()) {
			p.setEnViaje(true);
		}
	}
	
	
	public String getNumIdentificacion() {
		return NumIdentificacion;
	}

	public void VaciarDepositoTransporte() {
			DepositoTransporte.clear();
	}
	
	public double getPesoMax() {
		return pesoMax;
	}

	
	public double getVolumenMax() {
		return VolumenMax;
	}


	public double getCostoDeKmPorViaje() {
		return CostoDeKmPorViaje;
	}

	public boolean ContienePaquetes() {
		if (DepositoTransporte.isEmpty()) return false;	
		return true;
	}
	
	
	public void AgregarPaqueteTranporte(Integer codigo, Paquete pack) {	
		DepositoTransporte.put(codigo, pack);		
	}
	
	
	public void AgregarPaqueteRefriTransporte(Integer codigo,Paquete pack) {
		if (this.EquipoRefrigeracion) DepositoTransporte.put(codigo, pack);
			
		throw new RuntimeException("El tranporte no tiene refrigeracion!");
		
	}
	
	
	public boolean isEquipoRefrigeracion() {
		return EquipoRefrigeracion;
	}

	public void setEquipoRefrigeracion(boolean equipoRefrigeracion) {
		EquipoRefrigeracion = equipoRefrigeracion;
	}

	public boolean isEnViaje() {
		return EnViaje;
	}


	public void setEnViaje(boolean enViaje) {
		EnViaje = enViaje;
	}


	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	
	


	

}
