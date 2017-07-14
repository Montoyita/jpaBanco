package com.beeva.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.DAO.BancoDAO;
import com.beeva.MODEL.LogMongo;
import com.beeva.VO.Banco;
import com.beeva.VO.Cuenta;

@Repository
public class BancoDAOImpl extends BancoDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public void save(Banco banco) {
		em.persist(banco);
		LogMongo log = new LogMongo("base_log_mon","doc_banco");
		log.agregarBancoLog(banco);
	}
	
	@Transactional
	public void update(Banco banco) {
		em.merge(banco);		
	}

	public Banco getBanco(int id) {
		Banco ban = em.find(Banco.class, id);
		return ban;
	}

}
