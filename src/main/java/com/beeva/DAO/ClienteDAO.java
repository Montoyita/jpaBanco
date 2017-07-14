package com.beeva.DAO;

import com.beeva.VO.Banco;
import com.beeva.VO.Cliente;

abstract public class ClienteDAO {
	abstract public void save(Cliente cliente);
	abstract public void update(Cliente cliente);
	abstract public Cliente getCliente(int id);
}
