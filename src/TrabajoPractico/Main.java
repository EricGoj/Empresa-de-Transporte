package TrabajoPractico;



public class Main {

	public static void main(String[] args) {
		
		double volumen,ctoViaje;
		
		Empresa emp=new Empresa(4124,"Mafi",50000);
		
		emp.agregarDestino("Cordoba", 300);
		emp.agregarTrailer("AC314PI", 12000, 60, true, 5, 100);
		emp.asignarDestino("AC314PI", "Cordoba");
		emp.incorporarPaquete("Cordoba",321321, 100, 5, true);
		emp.incorporarPaquete("Cordoba",333 ,250, 10, true);
		emp.incorporarPaquete("Cordoba", 543534,150, 8, true);
		emp.incorporarPaquete("Cordoba", 6565,50, 2.5, false); // no es compatible con el transprote
		emp.incorporarPaquete("Cordoba",4343 ,300, 15, true);
		emp.incorporarPaquete("Cordoba",66666 ,400, 12, true);
		emp.incorporarPaquete("Cordoba",87787 ,125, 5, false); // no es compatible con el transprote
		volumen = emp.cargarTransporte("AC314PI");
		emp.iniciarViaje("AC314PI");
		ctoViaje = emp.obtenerCostoViaje("AC314PI");
		emp.finalizarViaje("AC314PI");
		
		System.out.println("HOLLA");
		System.out.println("fofo");
		
		System.out.println("Volumen:"+ volumen + "Costo Del Viaje:" + ctoViaje);
		
		
		
		
		
		
		
		
		
		
		
		
	}
	

}
