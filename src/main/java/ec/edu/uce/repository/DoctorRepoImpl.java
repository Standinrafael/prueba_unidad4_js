package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Doctor;

@Repository
@Transactional
public class DoctorRepoImpl implements IDoctorRepo {

	final static Logger LOGGER = Logger.getLogger(DoctorRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.persist(doctor);
	}

	@Override
	public void actualizarDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		this.entityManager.merge(doctor);
	}

	@Override
	public Doctor buscarDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Doctor.class, id);
	}

	@Override
	public void eliminarDoctorPorId(Integer id) {
		// TODO Auto-generated method stub
		Doctor doctorEliminar = this.buscarDoctorPorId(id);
		this.entityManager.remove(doctorEliminar);
	}

	@Override
	public Doctor buscarDoctorPorCedula(String cedula) {
		// TODO Auto-generated method stub
		
		try {
			TypedQuery<Doctor> miQuery = this.entityManager.createQuery("select d from Doctor d where d.cedula=:cedula",
					Doctor.class);
			miQuery.setParameter("cedula", cedula);
			return miQuery.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		
		
	}

}
