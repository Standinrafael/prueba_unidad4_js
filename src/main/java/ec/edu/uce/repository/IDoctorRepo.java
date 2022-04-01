package ec.edu.uce.repository;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorRepo {

	void insertarDoctor(Doctor doctor);
	void actualizarDoctor(Doctor doctor);
	Doctor buscarDoctorPorId(Integer id);
	void eliminarDoctorPorId(Integer id);
	
	Doctor buscarDoctorPorCedula(String cedula);
}
