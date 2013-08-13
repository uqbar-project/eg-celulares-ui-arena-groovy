package ar.edu.celulares.home

import org.apache.commons.collections15.Predicate
import org.uqbar.commons.model.CollectionBasedHome
import org.uqbar.commons.model.UserException
import org.uqbar.commons.utils.ApplicationContext

import ar.edu.celulares.domain.Celular

@org.uqbar.commons.utils.Observable
class HomeCelulares extends CollectionBasedHome<Celular> {

	static def instance

	def static synchronized getInstance() {
		if (!instance) {
			instance = new HomeCelulares()
		}
		instance
	}

	def HomeCelulares() {
		this.create(new Celular(nombre: "Laura Iturbe", numero: 88022202, modeloCelular: getModelo("NOKIA LUMIA 625"), recibeResumenCuenta: false))
		this.create(new Celular(nombre: "Julieta Passerini", numero: 45636453, modeloCelular: getModelo("NOKIA ASHA 501"), recibeResumenCuenta: false))
		this.create(new Celular(nombre: "Debora Fortini", numero: 45610892, modeloCelular: getModelo("NOKIA ASHA 501"), recibeResumenCuenta: true))
		this.create(new Celular(nombre: "Chiara Dodino", numero: 68026976, modeloCelular: getModelo("NOKIA ASHA 501"), recibeResumenCuenta: false))
		this.create(new Celular(nombre: "Melina Dodino", numero: 40989911, modeloCelular: getModelo("LG OPTIMUS L3 II"), recibeResumenCuenta: true))
	}

	def getModelo(modeloDescripcion) {
		ApplicationContext.instance.getSingleton(HomeModelos.class).get(modeloDescripcion)
	}

	// ********************************************************
	// ** Altas y bajas
	// ********************************************************
	public void validateCreate(Celular celular) {
		celular.validar()
		validarClientesDuplicados(celular)
	}

	protected void validarClientesDuplicados(celular) {
		def numero = celular.numero
		if (this.search(numero)) {
			throw new UserException("Ya existe un celular con el número: " + numero)
		}
	}

	// ********************************************************
	// ** Búsquedas
	// ********************************************************
	def search(numero) {
		this.search(numero, null)
	}

	/**
	 * Busca los celulares que coincidan con los datos recibidos. Tanto número como nombre pueden ser nulos,
	 * en ese caso no se filtra por ese atributo.
	 *
	 * Soporta búsquedas por substring, por ejemplo el celular (12345, "Juan Gonzalez") será contemplado por
	 * la búsqueda (23, "Gonza")
	 */
	def search(numero, nombre) {
		allInstances().findAll { celular -> 
			this.match(numero, celular.numero) && this.match(nombre, celular.nombre)
		}
	}

	def match(expectedValue, realValue) {
		if (!expectedValue) {
			return true
		}
		if (!realValue) {
			return false
		}
		realValue.toString().toLowerCase().contains(expectedValue.toString().toLowerCase())
	}

	@Override
	public Class<Celular> getEntityType() {
		Celular.class
	}

	@Override
	public Celular createExample() {
		new Celular()
	}

	@Override
	protected Predicate getCriterio(Celular example) {
		null
	}

	/**
	 * Para el proyecto web - se mantiene la busqueda por Identificador
	 */
	def searchById(int id) {
		allInstances.find { celular -> celular.id?.equals(id) }
	}

}
