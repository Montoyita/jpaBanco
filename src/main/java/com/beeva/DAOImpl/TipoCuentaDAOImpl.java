package com.beeva.DAOImpl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.beeva.DAO.BancoDAO;
import com.beeva.DAO.TipoCuentaDAO;
import com.beeva.MODEL.LogMongo;
import com.beeva.VO.Banco;
import com.beeva.VO.Cuenta;
import com.beeva.VO.TipoCuenta;

@Repository
public class TipoCuentaDAOImpl extends TipoCuentaDAO {
	@PersistenceContext
	EntityManager em;
	@Override
	@Transactional
	public void save(TipoCuenta tc) {
		em.persist(tc);
	}
}
