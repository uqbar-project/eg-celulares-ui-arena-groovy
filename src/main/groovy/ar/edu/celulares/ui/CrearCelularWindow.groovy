package ar.edu.celulares.ui

import org.uqbar.arena.windows.WindowOwner

import ar.edu.celulares.domain.Celular

class CrearCelularWindow extends EditarCelularWindow {

	public CrearCelularWindow(WindowOwner owner) {
		super(owner, new Celular())
	}

	@Override
	protected void executeTask() {
		homeCelulares.create(modelObject)
		super.executeTask()
	}

}
