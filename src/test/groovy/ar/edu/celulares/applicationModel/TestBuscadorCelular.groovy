package ar.edu.celulares.applicationModel

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.uqbar.commons.utils.ApplicationContext

import ar.edu.celulares.domain.Celular
import ar.edu.celulares.domain.Modelo
import ar.edu.celulares.home.HomeCelulares
import ar.edu.celulares.home.HomeModelos
import ar.edu.celulares.home.MockHomeCelulares

class TestBuscadorCelular extends AbstractTestBuscadorCelular {

	BuscadorCelular buscadorFallido
	
	@Before
	def void init() {
		super.init()
		buscadorFallido = new BuscadorCelular(nombre: "XXXX", numero: null)
		ApplicationContext.instance.configureSingleton(Celular.class, HomeCelulares.instance)
	}

	@Test
	def void buscarSinResultados() {
		buscadorFallido.search()
		Assert.assertEquals(0, buscadorFallido.resultados.size())
	}
	
	@Test
	def void buscarDodinos() {
		searcher.search()
		Assert.assertEquals(2, searcher.resultados.size())
	}

	@Test
	def void buscarDodinosConNumeroErroneo() {
		searcher.numero = 17715274
		searcher.search()
		Assert.assertEquals(0, searcher.resultados.size())
	}

}
