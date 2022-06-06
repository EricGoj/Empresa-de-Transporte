package TrabajoPractico;



public class Main {

	public static void main(String[] args) {
		
		double volumen,ctoViaje;
		
		Empresa emp=new Empresa(4124,"Mafi",50000);
		
		emp.agregarDestino("Corrientes", 900);
		// distancia a Corrientes = 900Km
		// costo viaje = 900 * 10 + 150 + 500 + 300 = 
		//             = 9000 + 950 = $ 9950
		emp.agregarMegaTrailer("AD161AU", 18000, 12220, false, 10, 150, 500, 300);
		emp.asignarDestino("AD161AU", "Corrientes");
		emp.incorporarPaquete("Corrientes", 1,100, 5, true); // no es compatible con el transprote
		emp.incorporarPaquete("Corrientes", 2,400, 12, true); // no es compatible con el transprote
		emp.incorporarPaquete("Corrientes", 3,50, 2.5, false);
		emp.incorporarPaquete("Corrientes", 4,120, 5, false);
		emp.incorporarPaquete("Corrientes", 5,75, 4, false);
		emp.incorporarPaquete("Corrientes",6, 150, 7.5, false);
		emp.incorporarPaquete("Corrientes", 7,200, 6, false);
		volumen = emp.cargarTransporte("AD161AU");
		emp.iniciarViaje("AD161AU");
		ctoViaje = emp.obtenerCostoViaje("AD161AU");
		
		emp.finalizarViaje("AD161AU");
	
		
		
	}
	

}
