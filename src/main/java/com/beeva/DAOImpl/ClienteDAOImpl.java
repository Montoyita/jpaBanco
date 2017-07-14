package com.beeva.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.DAO.ClienteDAO;
import com.beeva.MODEL.LogMongo;
import com.beeva.VO.Cliente;
import com.beeva.VO.Cuenta;

@Repository
public class ClienteDAOImpl extends ClienteDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public void save(Cliente cliente) {
		em.persist(cliente);
		LogMongo log = new LogMongo("base_log_mon","doc_banco");
		log.agregaClienteLog(cliente);
	}
	
	@Transactional
	public void update(Cliente cliente) {
		em.merge(cliente);		
	}

	public Cliente getCliente(int id) {
		Cliente cuen = em.find(Cliente.class, id);
		return cuen;
	}

}
