package ar.edu.celulares.runnable

import org.uqbar.arena.Application
import org.uqbar.arena.windows.Window
import org.uqbar.commons.utils.ApplicationContext

import ar.edu.celulares.home.HomeCelulares
import ar.edu.celulares.home.HomeModelos
import ar.edu.celulares.ui.BuscarCelularesWindow

class CelularApplication extends Application {

	public static void main(String[] args) {
		new CelularApplication().start()
	}

	@Override
	protected Window<?> createMainWindow() {
		ApplicationContext.instance.configureSingleton(HomeModelos.class, HomeModelos.instance)
		ApplicationContext.instance.configureSingleton(HomeCelulares.class, HomeCelulares.instance)
		return new BuscarCelularesWindow(this)
	}
	
}
