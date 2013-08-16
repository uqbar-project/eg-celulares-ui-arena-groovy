package ar.edu.celulares.domain

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.uqbar.commons.model.UserException

class TestCelular {
	
	Celular celularNoResumen
	Celular celularSiResumen
	
	@Before
	def void init() {
		celularNoResumen = new Celular(numero: 17256124, nombre: 'Juan Carlos Perez', modeloCelular: new Modelo(costo: 150, descripcion: 'NOKIA', requiereResumenCuenta: false))
		celularSiResumen = new Celular(numero: 23563269, nombre: 'Mariana Moretti', modeloCelular: new Modelo(costo: 350, descripcion: 'NOKIA 11', requiereResumenCuenta: true))
	}
	
	@Test
	def void celularNoRecibeResumenCuenta() {
		Assert.assertFalse(celularNoResumen.recibeResumenCuenta)
	}
	
	@Test
	def void celularSiRecibeResumenCuenta() {
		Assert.assertTrue(celularSiResumen.recibeResumenCuenta)
	}
	
	@Test
	def void celularCambiaRecibeResumenCuenta() {
		celularNoResumen.modeloCelular = new Modelo(requiereResumenCuenta: true)
		Assert.assertTrue(celularNoResumen.recibeResumenCuenta)
	}
	
	@Test(expected=UserException.class)
	def void celularNumeroGrande() {
		new Celular(numero: 891724861235623).validar()
	}

	@Test(expected=UserException.class)
	def void celularNoIngresoNumero() {
		new Celular(nombre: "Pepe").validar()
	}

	@Test(expected=UserException.class)
	def void celularNoIngresoNombre() {
		new Celular(numero: 19246218).validar()
	}

	@Test(expected=UserException.class)
	def void celularNoIngresoModelo() {
		new Celular(numero: 19246218, nombre: "Pepe").validar()
	}
	
	@Test
	def void celularValidacionOk() {
		celularNoResumen.validar()
	}

}