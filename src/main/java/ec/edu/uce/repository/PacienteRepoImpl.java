package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Paciente;

@Repository
@Transactional
public class PacienteRepoImpl implements IPacienteRepo {

	final static Logger LOGGER = Logger.getLogger(PacienteRepoImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.persist(paciente);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.entityManager.merge(paciente);
	}

	@Override
	public Paciente buscarPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Paciente.class, id);
	}

	@Override
	public void eliminarPacientePorId(Integer id) {
		// TODO Auto-generated method stub
		Paciente pacienteEliminar = this.buscarPacientePorId(id);
		this.entityManager.remove(pacienteEliminar);
	}

	@Override
	public Paciente buscarPacientePorCedula(String cedula) {
		// TODO Auto-generated method stub

		try {
			TypedQuery<Paciente> miQuery = this.entityManager
					.createQuery("select p from Paciente p where p.cedula=:cedula", Paciente.class);
			miQuery.setParameter("cedula", cedula);
			return miQuery.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}

	}

}
