package com.beeva.DAO;

import com.beeva.VO.BancosClientes;

abstract public class BancosClientesDAO {
	abstract public void save(BancosClientes bancoscliente);
	abstract public void update(BancosClientes bancoscliente);
	abstract public BancosClientes getRelacion(int id);
}