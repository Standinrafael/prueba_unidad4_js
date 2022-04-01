package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepo;
@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepo pacienteRepo;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub

		this.pacienteRepo.insertarPaciente(paciente);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub

		this.pacienteRepo.actualizarPaciente(paciente);
	}

	@Override
	public Paciente buscarPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPacientePorId(id);
	}

	@Override
	public void eliminarPacientePorId(Integer id) {
		// TODO Auto-generated method stub

		this.pacienteRepo.eliminarPacientePorId(id);
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.pacienteRepo.buscarPacientePorCedula(cedula);
	}

}
