package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.CitaMedica;

public interface ICitaMedicaService {

	//Metodos CRUD
	void insertarCitaMedica(CitaMedica cita);
	void actualizarCitaMedica(CitaMedica cita);
	CitaMedica buscarCitaPorId(Integer id);
	void eliminarCitaPorId(Integer id);
	
	CitaMedica buscarPorNumero(String numero);
	List<CitaMedica> buscarTodos();
}
