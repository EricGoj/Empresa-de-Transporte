package TrabajoPractico;

import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {

	private Integer CUIT;
	private String Nombre;
	private int capacidadDeCadaDeposito;
	private HashMap<String, Transporte> TransportesLista;
	private HashMap <Integer,Paquete> DepositoComun;
	private HashMap <Integer,Paquete> DepositoRefrigeracion;
	private HashMap <String,Integer> Destinos;

	public Empresa(){}

	public Empresa(Integer CUIT,String Nombre,int capacidadDeCadaDeposito) {
		this.CUIT=CUIT;
		this.Nombre=Nombre;
		this.capacidadDeCadaDeposito=capacidadDeCadaDeposito;
		
		DepositoComun=new HashMap<Integer, Paquete>();
		DepositoRefrigeracion=new HashMap<Integer, Paquete>();
		TransportesLista=new HashMap <String,Transporte>();  
		Destinos=new HashMap<String,Integer>();
	}
	
	public String VerDaTranpos(String Matricula) {
		return TransportesLista.get(Matricula).verDatos();	
	}
	
	
	@Override
	public String toString() {
		return "Empresa [CUIT=" + CUIT + ", Nombre=" + Nombre + ", Capacidad="+ capacidadDeCadaDeposito + "]";
	}

	public void agregarDestino(String Destino,Integer KM) {
		if (Destinos.containsKey(Destino)) {
			throw new RuntimeException("El Destino ya fue Agregado");
		}
		         Destinos.put(Destino, KM);	
	}

	public boolean incorporarPaquete (String Destino,Integer Codigo, double Volumen ,double peso,
			boolean frio) {
		
		if(DepositoComun.containsKey(Codigo) || DepositoRefrigeracion.containsKey(Codigo)) {
			throw new RuntimeException("El paquete ya fue incorporado");
		}
		
		if (this.capacidadDeCadaDeposito == 0) {
			throw new RuntimeException("El deposito no tiene mas espacio");
		}
		
		if (peso > 500) {
			return false;
		}
		
		else if  (DepositoComun.size() > this.capacidadDeCadaDeposito ||DepositoRefrigeracion.size()  > this.capacidadDeCadaDeposito) {
			throw new RuntimeException("La Capacidad del Deposito fue excedida!");
		}
		Paquete paque=new Paquete(Codigo,peso,Volumen,Destino,frio,false);
		if (paque.isRefrigeracion()) {
			DepositoRefrigeracion.put(Codigo,paque);
			this.capacidadDeCadaDeposito=(int) (this.capacidadDeCadaDeposito-paque.getVolumen());
			return true;
		}
		else 
			DepositoComun.put(Codigo,paque);
		    this.capacidadDeCadaDeposito=(int) (this.capacidadDeCadaDeposito-paque.getVolumen());
		    return true;
	}
	
	public String sizeDeposto() {
		return DepositoComun.size() + " " + DepositoRefrigeracion.size();
	}
	
	
	public void agregarTrailer (String Identificacion,double pesoMax,double VolumenMax,boolean Refrigeracion,
			double CostoPorKm,double SeguroDeCarga) {
		
		Transporte TComun= new TrailerComun(Identificacion,pesoMax,VolumenMax,CostoPorKm,Refrigeracion,false,"El Transporte no tiene destino aun", SeguroDeCarga);	
		TransportesLista.put(Identificacion, TComun);	
	}
	
	public void agregarMegaTrailer (String Identificacion,double pesoMax,double VolumenMax,boolean Refrigeracion,double CostoPorKm,double SeguroDeCarga
			,double CostoFijo,double costoComida) {
		
		Transporte MegaTrailer= new MegaTrailer(Identificacion, pesoMax, VolumenMax, CostoPorKm, Refrigeracion,costoComida,false,"El Transporte no tiene destino aun", SeguroDeCarga, CostoFijo);	
		TransportesLista.put(Identificacion, MegaTrailer);
	}
	
	public void agregarFlete(String Identificacion,double pesoMax,double VolumenMax,double CostoPorKm,Integer CantidadAcompañantes , double CostoPorAcompaniante ) {
		
		Transporte Flete=new Fletes(Identificacion, pesoMax,VolumenMax,CostoPorKm,false ,CantidadAcompañantes,"El Transporte no tiene destino aun",false,CostoPorAcompaniante);	
		TransportesLista.put(Identificacion, Flete);
	}
	
	public void asignarDestino(String identificacion, String Destino) {	
		if(!TransportesLista.containsKey(identificacion)) throw new RuntimeException("La Matricula no existe");
		if(!Destinos.containsKey(Destino)) throw new RuntimeException("El destino no existe! , Agrega el destino antes de asignarlo");	
		//Tengo que sacar de la lista de tranporte , el tranporte que dice la id.
		TransportesLista.get(identificacion).setDestino(Destino);	
	}
	
	public double cargarTransporte(String matricula) { // falta pensar
		
		if (TransportesLista.get(matricula).isEnViaje() || TransportesLista.get(matricula).getDestino() == "El Transporte no tiene destino aun" ) {	
			throw new RuntimeException("El transporte ya estan en viaje o no tiene destino");		
		}	
		if (!TransportesLista.containsKey(matricula)) throw new RuntimeException("La matricula no existe");
		double volumen=0;
		double peso=0;
		ArrayList<Integer> PaquetesEliminados=new ArrayList<Integer>();	
		if (!TransportesLista.get(matricula).isEquipoRefrigeracion())
			for (Paquete paquete: DepositoComun.values() ) { // Recorre todos los paquetes del deposito de la empresa		
				if ( paquete.getDestino() == TransportesLista.get(matricula).getDestino()) { // Una vez que encuentre un paquete 
					if (volumen >= TransportesLista.get(matricula).getVolumenMax() || peso >= TransportesLista.get(matricula).getPesoMax()) {
						return volumen;
					}
					else  {  // Si el paquete no necesita refrigeracion y el tranporte no tiene ref
						TransportesLista.get(matricula).AgregarPaqueteTranporte(paquete.getCodigoPaquete(), paquete); //Agrega el pack al deposito del Transporte
						PaquetesEliminados.add(paquete.getCodigoPaquete());//Remueve el Pack del deposito de la empresa.
						this.capacidadDeCadaDeposito=(int) (this.capacidadDeCadaDeposito+paquete.getVolumen());
						volumen=volumen+paquete.getVolumen();
						peso=peso+paquete.getPeso();
					}
				}
			}
		else if (TransportesLista.get(matricula).isEquipoRefrigeracion())
			for (Paquete paquete: DepositoRefrigeracion.values() ) { // Recorre todos los paquetes del deposito de la empresa	
				if ( paquete.getDestino() == TransportesLista.get(matricula).getDestino()) { // Una vez que encuentre un paquete 
					if (volumen >= TransportesLista.get(matricula).getVolumenMax() || peso >= TransportesLista.get(matricula).getPesoMax()) {
						return volumen;
					}
					else  {  // Si el paquete no necesita refrigeracion y el tranporte no tiene ref
						TransportesLista.get(matricula).AgregarPaqueteTranporte(paquete.getCodigoPaquete(), paquete);//Agrega el pack al deposito del Transporte
						PaquetesEliminados.add(paquete.getCodigoPaquete());//Remueve el Pack del deposito de la empresa.
						this.capacidadDeCadaDeposito=(int) (this.capacidadDeCadaDeposito+paquete.getVolumen());
						volumen=volumen+paquete.getVolumen();
						peso=peso+paquete.getPeso();
					}
				}
			}
		for (Integer codigoPaquete: PaquetesEliminados) {
			DepositoComun.remove(codigoPaquete);
			DepositoRefrigeracion.remove(codigoPaquete);		
		}
		return volumen;
	}

	public void iniciarViaje(String matricula) {	
		if (!TransportesLista.containsKey(matricula)) {
			throw new RuntimeException("El Transporte no existe");
		}
		if (TransportesLista.get(matricula).isEnViaje()) {
			throw new RuntimeException("El transporte ya se encuentra viaje");	
		}
		if (TransportesLista.get(matricula).getDestino()=="El Transporte no tiene destino aun") throw new RuntimeException ("El transporte no tiene destino");
		if(!TransportesLista.get(matricula).ContienePaquetes())	throw new RuntimeException("El Transporte esta vacio");			
		TransportesLista.get(matricula).setEnViaje(true);
		TransportesLista.get(matricula).CambiarEstadoPaquetes();
		
	}
	
	
	public void finalizarViaje(String matricula) {
		if (!TransportesLista.get(matricula).isEnViaje()) {
			throw new RuntimeException("El viaje del transporte ya finalizo");	
		}
		TransportesLista.get(matricula).setEnViaje(false);
		TransportesLista.get(matricula).setDestino("El Transporte no tiene destino aun");
		TransportesLista.get(matricula).VaciarDepositoTransporte();
	}
	
	
	public double obtenerCostoViaje(String matricula) {
		
		if(!TransportesLista.containsKey(matricula)) {
			return  0;
		}
		Transporte Transporte=TransportesLista.get(matricula);
		if ( Transporte instanceof TrailerComun) {
			TrailerComun trailer=(TrailerComun)Transporte;
			return trailer.getSegCarga()+trailer.getCostoDeKmPorViaje()*Destinos.get(trailer.getDestino()).doubleValue();
			//SegCarga + CostoKm * KM
		}
		else if (Transporte instanceof MegaTrailer) {
			MegaTrailer MegaT=(MegaTrailer)Transporte;
			return MegaT.getCostoComida()+MegaT.getCostoFijo()+MegaT.getSegCarga()+MegaT.getCostoDeKmPorViaje()*Destinos.get(MegaT.getDestino()).doubleValue();
			//CostoFijo+CostoDeComida+SegCarga+CostoKM*KM	
		}
		else if (Transporte instanceof Fletes) {
			Fletes fletes=(Fletes)Transporte;
			return fletes.getCostoPorAcompaniante()*fletes.getCostoPorAcompaniante()+fletes.getCostoDeKmPorViaje()*Destinos.get(fletes.getDestino()).doubleValue();
			//CantidadAcompañantes*CostoPorAcompañante + CostoKM * KM
		}
		return 0;		
	}
	
	public String TipoDeTransporte(String Matricula) {

		Transporte Transporte=TransportesLista.get(Matricula);

		if ( Transporte instanceof TrailerComun) {
			return "Trailer Comun";		
		}
		else if (Transporte instanceof MegaTrailer) {
			return "Mega Trailer";
		}
		else if (Transporte instanceof Fletes) {
			return "Fletes";		
		}
		return null;
	}


	public String obtenerTransporteIgual(String matricula) {		
		Transporte Transporte=TransportesLista.get(matricula);	
		for (Transporte ListaTrans: TransportesLista.values()) {	
			if (Transporte.equals(ListaTrans)){
				return ListaTrans.getNumIdentificacion();
			}	
		}
		return "No existe Transporte Igual";
	}

}
