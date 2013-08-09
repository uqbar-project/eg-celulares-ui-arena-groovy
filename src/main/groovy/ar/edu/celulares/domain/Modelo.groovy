package ar.edu.celulares.domain

import org.uqbar.commons.utils.Observable;

@Observable
class Modelo {
	static final DESCRIPCION = "descripcion"
	
	String descripcion
	BigDecimal costo
	Boolean requiereResumenCuenta  // FED: boolean tiene problemas
	
	def getDescripcionEntera() {
		 descripcion + " (\$ " + costo + ")"
	}
	
	@Override
	public String toString() {
		descripcionEntera
	}

}
