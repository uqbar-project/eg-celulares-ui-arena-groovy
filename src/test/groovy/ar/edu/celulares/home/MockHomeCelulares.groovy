package ar.edu.celulares.home

import org.uqbar.commons.model.UserException

import ar.edu.celulares.domain.Celular

class MockHomeCelulares extends HomeCelulares {

	def init() {
		this.create(new Celular(nombre: "Ricardo Ruben", numero: 44667816, modeloCelular: getModelo("NOKIA LUMIA 625"), recibeResumenCuenta: false))
	}
	
	def searchById(int id) {
		throw new UserException("Operación no permitida: no debe buscar por id en el test")
	}
}
