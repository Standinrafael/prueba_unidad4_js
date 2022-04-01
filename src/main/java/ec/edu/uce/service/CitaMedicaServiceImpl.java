package ec.edu.uce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.CitaMedica;
import ec.edu.uce.repository.ICitaMedicaRepo;

@Service
public class CitaMedicaServiceImpl implements ICitaMedicaService {

	@Autowired
	private ICitaMedicaRepo citaRepo; 
	
	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub

		this.citaRepo.insertarCitaMedica(cita);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub

		this.citaRepo.actualizarCitaMedica(cita);
	}

	@Override
	public CitaMedica buscarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.citaRepo.buscarCitaPorId(id);
	}

	@Override
	public void eliminarCitaPorId(Integer id) {
		// TODO Auto-generated method stub

		this.citaRepo.eliminarCitaPorId(id);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub
		return this.citaRepo.buscarPorNumero(numero);
	}

	@Override
	public List<CitaMedica> buscarTodos() {
		// TODO Auto-generated method stub
		return this.citaRepo.buscarTodos();
	}

}
