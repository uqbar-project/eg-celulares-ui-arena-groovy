package ar.edu.celulares.applicationModel

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.uqbar.commons.utils.ApplicationContext

import ar.edu.celulares.domain.Celular
import ar.edu.celulares.home.MockHomeCelulares

class TestBuscadorCelularHomeMockeado extends AbstractTestBuscadorCelular {

	@Before
	def void init() {
		super.init()
		ApplicationContext.instance.configureSingleton(Celular.class, new MockHomeCelulares())
	}

	@Test
	def void buscarDodinosEnMockHome() {
		searcher.search()
		Assert.assertEquals(0, searcher.resultados.size())
	}

	@Test
	def void buscarRicardoRubenEnMockHome() {
		def buscadorRicardoRuben = new BuscadorCelular(nombre: "Ricardo", numero: null)
		buscadorRicardoRuben.search()
		Assert.assertEquals(1, buscadorRicardoRuben.resultados.size())
	}

}
