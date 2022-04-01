package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import ec.edu.uce.modelo.Paciente;

import ec.edu.uce.service.IPacienteService;

@SpringBootTest
class PruebaUnidad4JsApplicationTests {

	@Autowired
	private IPacienteService pacienteService;
	
	@Test
	void insertarUno() {
		Paciente paciente= new Paciente();
		paciente.setCedula("1105166290");
		paciente.setNombre("Juan");
		paciente.setApellido("Perez");
		paciente.setFechaNacimiento(LocalDateTime.of(1990, Month.APRIL, 10, 20, 15));
		paciente.setCodigoIess("12345");
		paciente.setEstatura(1.60);
		paciente.setPeso(55.30);
		paciente.setEdad(32);
		
		this.pacienteService.insertarPaciente(paciente);
		assertNotNull(this.pacienteService.buscarPacientePorId(1));
		
	}
	
	@Test
	void insertarDos() {
		Paciente paciente= new Paciente();
		paciente.setCedula("0123456789");
		paciente.setNombre("Luz");
		paciente.setApellido("Acosta");
		paciente.setFechaNacimiento(LocalDateTime.of(1972, Month.JUNE, 15, 20, 15));
		paciente.setCodigoIess("67890");
		paciente.setEstatura(1.50);
		paciente.setPeso(50.00);
		paciente.setEdad(50);
		
		this.pacienteService.insertarPaciente(paciente);
		assertNotNull(this.pacienteService.buscarPacientePorId(1));
	}

}
