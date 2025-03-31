package dao;

import models.Carro;
import exceptions.PlacaInvalidaException;

import java.util.ArrayList;
import java.util.List;

public class CarroDAO {
    private static List<Carro> carros = new ArrayList<>();

    public static void adicionarCarro(Carro carro) throws PlacaInvalidaException {
        if (carro.getPlaca() == null || carro.getPlaca().length() > 6) {
            throw new PlacaInvalidaException("Placa não existente!");
        }
        carros.add(carro);
    }

	public static List<Carro> getCarros() {
		// TODO Auto-generated method stub
		return null;
	}
}