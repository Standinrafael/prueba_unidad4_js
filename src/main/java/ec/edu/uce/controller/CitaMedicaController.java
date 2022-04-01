package ec.edu.uce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ec.edu.uce.modelo.CitaMedica;

import ec.edu.uce.service.ICitaMedicaService;
import ec.edu.uce.service.IGestorCitaService;

@Controller
@RequestMapping("/citasmedicas/")
public class CitaMedicaController {

	@Autowired
	private IGestorCitaService gestorService;

	@Autowired
	private ICitaMedicaService citaService;

	// Muestre todas las citas

	@GetMapping("todos")
	public String buscarCitasTodos(Model modelo) {
		List<CitaMedica> listaCitas = this.citaService.buscarTodos();

		modelo.addAttribute("citas", listaCitas);

		return "lista";
	}

	// Agendar Cita Medica

	@GetMapping("citaNueva")
	public String obtenerPaginaIngresoDatos(CitaMedica citaMedica) {

		return "citaMedicaNueva";
	}

	@PostMapping("insertar")
	public String insertarCitaMedica(CitaMedica citaMedica, BindingResult result, Model modelo,
			RedirectAttributes redirectAttrs) {
		this.gestorService.agendarCita(citaMedica.getNumero(), citaMedica.getFechaCita(), citaMedica.getValorCita(),
				citaMedica.getLugarCita(), citaMedica.getDoctor().getCedula(),citaMedica.getPaciente().getCedula());
		return "redirect:todos";
	}

	// Actualizar Cita Medica
	@GetMapping("citaActualiza/{numeroCita}")
	public String obtenerPaginaActualizarDatos(@PathVariable("numeroCita") String numeroCita, CitaMedica citaMedica,
			Model modelo) {
		CitaMedica cita = this.citaService.buscarPorNumero(numeroCita);
		modelo.addAttribute("cita", cita);

		return "citaActualiza";
	}

	@PutMapping("actualizar/{numeroCita}")
	public String actualizarCita(@PathVariable("numeroCita") String numeroCita, CitaMedica citaMedica) {

		citaMedica.setNumero(numeroCita);
		this.gestorService.resultadoCita(numeroCita, citaMedica.getDiagnostico(), citaMedica.getReceta(), null);

		return "lista";
	}
}
