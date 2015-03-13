package ar.edu.celulares.home

import org.uqbar.commons.model.UserException

import ar.edu.celulares.domain.Celular

class MockHomeCelulares extends HomeCelulares {

	def init() {
		this.create(new Celular(nombre: "Ricardo Ruben", numero: 44667816, modeloCelular: getModelo("NOKIA LUMIA 625"), recibeResumenCuenta: false))
	}

}
