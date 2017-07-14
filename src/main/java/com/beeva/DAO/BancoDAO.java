package com.beeva.DAO;

import com.beeva.VO.Banco;

abstract public class BancoDAO {
	abstract public void save(Banco banco);
	abstract public void update(Banco banco);
	abstract public Banco getBanco(int id);
}
