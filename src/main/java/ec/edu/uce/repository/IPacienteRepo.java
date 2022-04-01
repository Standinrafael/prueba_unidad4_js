package ec.edu.uce.repository;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteRepo {

	//Metodos CRUD
	void insertarPaciente(Paciente paciente);
	void actualizarPaciente(Paciente paciente);
	Paciente buscarPacientePorId(Integer id);
	void eliminarPacientePorId(Integer id);
	Paciente buscarPacientePorCedula(String cedula);
}
