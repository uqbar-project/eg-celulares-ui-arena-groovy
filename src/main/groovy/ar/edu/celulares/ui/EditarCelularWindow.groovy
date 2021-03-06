package ar.edu.celulares.ui

import javax.swing.Spring.WidthSpring;

import org.uqbar.arena.bindings.ObservableProperty
import org.uqbar.arena.bindings.PropertyAdapter
import org.uqbar.arena.layout.ColumnLayout
import org.uqbar.arena.widgets.Button
import org.uqbar.arena.widgets.CheckBox
import org.uqbar.arena.widgets.Label
import org.uqbar.arena.widgets.Panel
import org.uqbar.arena.widgets.Selector
import org.uqbar.arena.widgets.TextBox
import org.uqbar.arena.windows.Dialog
import org.uqbar.commons.utils.ApplicationContext
import org.uqbar.lacar.ui.model.Action

import ar.edu.celulares.domain.Celular
import ar.edu.celulares.domain.Modelo

class EditarCelularWindow extends Dialog<Celular> {

	public EditarCelularWindow(owner, model) {
		super(owner, model)
		title = "Editar celular"
	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
		Panel form = new Panel(mainPanel)
		form.with {
			layout = new ColumnLayout(2)
			new Label(it).text = "Número"
			new TextBox(it).bindValueToProperty("numero")
			new Label(it).text = "Nombre del cliente"
			new TextBox(it).with {
				bindValueToProperty("nombre")
				width = 200	
			}	
			new Label(it).text = "Modelo del aparato"
			new Selector<Modelo>(it).with {
				allowNull(false)
			    bindValueToProperty("modeloCelular")
				bindItems(new ObservableProperty(homeModelos, "modelos")).with {
					adapter = new PropertyAdapter(Modelo.class, "descripcionEntera")
				}
			}
			new Label(it).text = "Recibe resumen cuenta en domicilio"
			new CheckBox(it).bindValueToProperty("recibeResumenCuenta")
		}

	}

	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick({ -> this.accept() } as Action)
			.setAsDefault()
			.disableOnError()

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick({ -> this.cancel() } as Action)
	}

	def getHomeCelulares() {
		ApplicationContext.instance.getSingleton(Celular.class)
	}

	def getHomeModelos() {
		ApplicationContext.instance.getSingleton(Modelo.class)
	}
}
