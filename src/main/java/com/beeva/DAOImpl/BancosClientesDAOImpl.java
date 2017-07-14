package com.beeva.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.VO.BancosClientes;
import com.beeva.DAO.BancosClientesDAO;
import com.beeva.MODEL.LogMongo;

@Repository
public class BancosClientesDAOImpl extends BancosClientesDAO{
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public void save(BancosClientes bancoscliente) {
		em.persist(bancoscliente);
		//LogMongo log = new LogMongo("base_log_mon","doc_banco");
		//log.agregarBancoLog(bancoscliente);
	}
	
	@Transactional
	public void update(BancosClientes bancoscliente) {
		em.merge(bancoscliente);		
	}

	public BancosClientes getRelacion(int id) {
		BancosClientes banclien = em.find(BancosClientes.class, id);
		return banclien;
	}
}
