package ec.edu.uce.service;

import ec.edu.uce.modelo.Doctor;

public interface IDoctorService {
	void insertarDoctor(Doctor doctor);
	void actualizarDoctor(Doctor doctor);
	Doctor buscarDoctorPorId(Integer id);
	void eliminarDoctorPorId(Integer id);
	Doctor buscarDoctorPorCedula(String cedula);
}
