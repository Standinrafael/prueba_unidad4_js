package ec.edu.uce.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.CitaMedica;

@Repository
@Transactional
public class CitaMedicaRepoImpl implements ICitaMedicaRepo {

	final static Logger LOGGER = Logger.getLogger(CitaMedicaRepoImpl.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cita);
	}

	@Override
	public void actualizarCitaMedica(CitaMedica cita) {
		// TODO Auto-generated method stub

		this.entityManager.merge(cita);
	}

	@Override
	public CitaMedica buscarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(CitaMedica.class, id);
	}

	@Override
	public void eliminarCitaPorId(Integer id) {
		// TODO Auto-generated method stub
		CitaMedica citaEliminar=this.buscarCitaPorId(id);
		this.entityManager.remove(citaEliminar);
	}

	@Override
	public CitaMedica buscarPorNumero(String numero) {
		// TODO Auto-generated method stub

		try {
			TypedQuery<CitaMedica> miQuery = this.entityManager
					.createQuery("select c from CitaMedica c where c.numero=:numero", CitaMedica.class);
			miQuery.setParameter("numero", numero);
			return miQuery.getSingleResult();
		}catch(NoResultException e) {
			return null;
		}
		
	}

	@Override
	public List<CitaMedica> buscarTodos() {
		// TODO Auto-generated method stub
		 TypedQuery<CitaMedica> miQuery=this.entityManager.createQuery("select c from CitaMedica c",CitaMedica.class);
		 return miQuery.getResultList();
	}

}
