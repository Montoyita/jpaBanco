package com.beeva.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.DAO.CuentaDAO;
import com.beeva.VO.Cuenta;
import com.beeva.MODEL.LogMongo;;


@Repository
public class CuentaDAOImpl extends CuentaDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public void save(Cuenta cuenta) {
		em.persist(cuenta);
		LogMongo log = new LogMongo("base_log_mon","doc_banco");
		log.agregaCuentaLog(cuenta);
	}
	
	@Transactional
	public void update(Cuenta cuenta) {
		em.merge(cuenta);		
	}

	public Cuenta getCuenta(int id) {
		Cuenta cuen = em.find(Cuenta.class, id);
		return cuen;
	}

}
