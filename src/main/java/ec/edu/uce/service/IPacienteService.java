package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {

	//Metodos CRUD
	void insertarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPacientePorId(Integer id);
	void eliminarPacientePorId(Integer id);
	
	Paciente buscarPacientePorCedula(String cedula);
}
