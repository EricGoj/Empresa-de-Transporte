package TrabajoPractico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmpresaTest {
	Empresa emp;
	double volumen, ctoViaje;

	@Before
	public void setUp() throws Exception {
		emp = new Empresa(32223334, "Expreso Libre", 30000);
		emp.agregarDestino("Cordoba", 350);
	}
	
	@Test
	public void testIncorporarPaqueteSinLugar() {
		assertFalse(emp.incorporarPaquete("Cordoba",1254347, 300, 30001, true));
	}

	@Test
	public void testIncorporarPaqueteConLugar() {
		assertTrue(emp.incorporarPaquete("Cordoba",777, 100, 5, true));
	}

	@Test(expected = RuntimeException.class)
	public void testAgregarDestinoDuplicado() {
		emp.agregarDestino("Cordoba", 320);
	}
	
	@Test(expected = RuntimeException.class)
	public void testIniciarViajeDeTransporteNoRegistrado() {
		emp.iniciarViaje("AC314PI");
	}
	
	@Test(expected = RuntimeException.class)
	public void testIniciarViajeSinCarga() {
		emp.agregarTrailer("AC314PI", 12000, 60, true, 5, 100);
		emp.iniciarViaje("AC314PI");
	}
	
	@Test(expected = RuntimeException.class)
	public void testFinalizarViajeNoIniciado() {
		emp.agregarTrailer("AC314PI", 12000, 60, true, 5, 100);
		emp.finalizarViaje("AC314PI");
	}

	@Test
	public void testTrailerFrio() {
		// distancia a cordoba = 350Km
		// costo viaje = 350 * 5 + 100 = 1750+100 = $1850
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
		assertEquals(50.0, volumen, 0.5);
		emp.iniciarViaje("AC314PI");
		ctoViaje = emp.obtenerCostoViaje("AC314PI");
		assertEquals(1850.0, ctoViaje, 0.5);
		emp.finalizarViaje("AC314PI");
	}

	@Test
	public void testMegaTrailer() {
		
		emp.agregarDestino("Corrientes", 900);
		// distancia a Corrientes = 900Km
		// costo viaje = 900 * 10 + 150 + 500 + 300 = 
		//             = 9000 + 950 = $ 9950
		emp.agregarMegaTrailer("AD161AU", 18000, 120, false, 10, 150, 500, 300);
		emp.asignarDestino("AD161AU", "Corrientes");
		emp.incorporarPaquete("Corrientes", 31231231,100, 5, true); // no es compatible con el transprote
		emp.incorporarPaquete("Corrientes", 4334343,400, 12, true); // no es compatible con el transprote
		emp.incorporarPaquete("Corrientes", 654645,50, 2.5, false);
		emp.incorporarPaquete("Corrientes", 867867,125, 5, false);
		emp.incorporarPaquete("Corrientes", 1,75, 4, false);
		emp.incorporarPaquete("Corrientes",2, 150, 7.5, false);
		emp.incorporarPaquete("Corrientes", 3,200, 6, false);
		volumen = emp.cargarTransporte("AD161AU");
		assertEquals(25.0, volumen, 0.5);
		emp.iniciarViaje("AD161AU");
		ctoViaje = emp.obtenerCostoViaje("AD161AU");
		assertEquals(9950.0, ctoViaje, 0.5);
		emp.finalizarViaje("AD161AU");
		
	}

	@Test
	public void testTransIguales() {
		
		emp.agregarDestino("Parana", 30);
		
		emp.agregarFlete("AB271NE", 40, 6000, 3, 2, 200);
		emp.asignarDestino("AB271NE", "Parana");
		emp.incorporarPaquete("Parana",6453645, 100, 5, false);
		emp.incorporarPaquete("Parana", 22222,400, 12, false);
		emp.incorporarPaquete("Parana", 121312,50, 8, false);
		emp.cargarTransporte("AB271NE");

		emp.agregarFlete("AD235NP", 30, 6000, 2, 1, 100);
		emp.asignarDestino("AD235NP", "Parana");
		emp.incorporarPaquete("Parana", 908675490,400, 12, false);
		emp.incorporarPaquete("Parana", 654065,50, 8, false);
		emp.incorporarPaquete("Parana", 549765489,100, 5, false);
		emp.cargarTransporte("AD235NP");

		assertEquals("AD235NP", emp.obtenerTransporteIgual("AB271NE"));
	}

}