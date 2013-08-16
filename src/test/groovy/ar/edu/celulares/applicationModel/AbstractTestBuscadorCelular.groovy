package ar.edu.celulares.applicationModel

import org.junit.Before
import org.uqbar.commons.utils.ApplicationContext

import ar.edu.celulares.domain.Celular
import ar.edu.celulares.domain.Modelo
import ar.edu.celulares.home.HomeCelulares
import ar.edu.celulares.home.HomeModelos

class AbstractTestBuscadorCelular {
	
	BuscadorCelular searcher
	
	@Before
	def void init() {
		searcher = new BuscadorCelular(nombre: "Dodi", numero: null)
		ApplicationContext.instance.configureSingleton(Modelo.class, new HomeModelos())
	}

}
