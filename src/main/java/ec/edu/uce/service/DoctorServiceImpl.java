package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Doctor;
import ec.edu.uce.repository.IDoctorRepo;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	private IDoctorRepo doctorRepo;
	
	@Override
	public void insertarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub

		this.doctorRepo.insertarDoctor(doctor);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.doctorRepo.actualizarDoctor(doctor);
	}

	@Override
	public Doctor buscarDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarDoctorPorId(id);
	}

	@Override
	public void eliminarDoctorPorId(Integer id) {
		// TODO Auto-generated method stub

		this.doctorRepo.eliminarDoctorPorId(id);
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		// TODO Auto-generated method stub
		return this.doctorRepo.buscarDoctorPorCedula(cedula);
	}

}
