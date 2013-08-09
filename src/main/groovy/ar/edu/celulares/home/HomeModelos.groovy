package ar.edu.celulares.home

import org.apache.commons.collections15.Predicate;
import org.uqbar.commons.model.CollectionBasedHome

import ar.edu.celulares.domain.Modelo

@org.uqbar.commons.utils.Observable
class HomeModelos extends CollectionBasedHome<Modelo> {

	static def instance = new HomeModelos()
	def modelos = []

	def static HomeModelos getInstance() {
		if (instance == null) {
			instance = new HomeModelos()
		}
		return instance
	}

	HomeModelos() {
		this.create(new Modelo(descripcion: "NOKIA ASHA 501", costo: 700, requiereResumenCuenta: true))
		this.create(new Modelo(descripcion: "LG OPTIMUS L5 II", costo: 920, requiereResumenCuenta: false))
		this.create(new Modelo(descripcion: "LG OPTIMUS L3 II", costo: 450, requiereResumenCuenta: true))
		this.create(new Modelo(descripcion: "NOKIA LUMIA 625", costo: 350, requiereResumenCuenta: true))
		this.create(new Modelo(descripcion: "MOTOROLA RAZR V3", costo: 350, requiereResumenCuenta: false))
	}

	public void create(modelo) {
		this.modelos.add(modelo)
	}

	public Modelo get(descripcion) {
		modelos.find { modelo -> modelo.descripcion.equals(descripcion) }
	}

	@Override
	public Class<Modelo> getEntityType() {
		Modelo.class
	}

	@Override
	public Modelo createExample() {
		new Modelo()
	}

	@Override
	protected Predicate getCriterio(Modelo example) {
		null
	}

}
