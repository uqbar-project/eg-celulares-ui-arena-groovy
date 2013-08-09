package ar.edu.celulares.domain

import org.uqbar.commons.model.ObservableUtils
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.Observable;

@Observable
class Celular {

	public final int MAX_NUMERO = 100000

	Integer id
	Integer numero
	String nombre
	Modelo modeloCelular
	Boolean recibeResumenCuenta = false

	// ********************************************************
	// ** Validacion
	// ********************************************************

	/**
	 * Valida que el celular esté correctamente cargado
	 */
	public void validar() {
		if (!numero) {
			throw new UserException("Debe ingresar número")
		}
		if (numero.intValue() <= this.MAX_NUMERO) {
			throw new UserException("El número debe ser mayor a " + this.MAX_NUMERO)
		}
		if (!this.ingresoNombre()) {
			throw new UserException("Debe ingresar nombre")
		}
		if (!modeloCelular) {
			throw new UserException("Debe ingresar un modelo de celular")
		}
	}

	public boolean ingresoNombre() {
		return !nombre?.trim().equals("")
	}

	// ********************************************************
	// ** Getters y setters
	// ********************************************************
//	def setModeloCelular(unModeloCelular) {
//		modeloCelular = unModeloCelular
//		recibeResumenCuenta = unModeloCelular.requiereResumenCuenta
//	}

//	def setRecibeResumenCuenta(siRecibeResumenCuenta) {
//		recibeResumenCuenta = siRecibeResumenCuenta
//		ObservableUtils.forceFirePropertyChanged(this, "habilitaResumenCuenta", !habilitaResumenCuenta)
//	}

	def getHabilitaResumenCuenta() {
		return !modeloCelular.requiereResumenCuenta
	}

	// ********************************************************
	// ** Misceláneos
	// ********************************************************

	@Override
	public String toString() {
		def result = new StringBuffer()
		result.append(nombre ?: "Celular sin nombre")
		result.append(modeloCelular ? " - " + modeloCelular : "")
		result.append(numero ? " - " + numero : "")
		result.append(recibeResumenCuenta ? " - recibe resumen" : " - no recibe resumen")
		return result.toString()
	}

}
