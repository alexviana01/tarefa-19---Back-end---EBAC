package dao;

import models.Cliente;
import exceptions.NomeDuplicadoException;
import exceptions.CPFInvalidoException;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private static List<Cliente> clientes = new ArrayList<>();

    public static void adicionarCliente(Cliente cliente) throws NomeDuplicadoException, CPFInvalidoException {
        for (Cliente c : clientes) {
            if (c.getClass().equals(cliente.getClass())) {
                throw new CPFInvalidoException("CPF já existente!");
            }
            if (c.getNome().equals(cliente.getNome())) {
                throw new NomeDuplicadoException("Nome já existente!");
            }
        }
        clientes.add(cliente);
    }

	public static List<Cliente> getClientes() {
		// TODO Auto-generated method stub
		return null;
	}
}