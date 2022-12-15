package com.orchardSim.orchard;

import java.util.ArrayList;

import com.orchardSim.client.Client;
import com.orchardSim.farmer.Farmer;
import com.orchardSim.vegetables.Vegetable;

public class Orchard {
	
	private String name;
	private ArrayList<Vegetable> vegetablesCollection;
	private int maxSize;
	
	public Orchard(String name, int maxSize) {
		this.maxSize = maxSize;
		vegetablesCollection = new ArrayList<Vegetable>();	
	}
	
	synchronized public void create(Farmer farmer, int quantity, Vegetable vegetable) {
		String message = "";
		for (int idx = 0; idx < quantity; idx++) {
			message = farmer.getName() + " ha iniciado el proceso de creación de " + vegetable.getName() + " ...";
			if (this.vegetablesCollection.size() < this.maxSize) {
				message += "Añadiendo " + vegetable.getName() + "\n";
				vegetablesCollection.add(vegetable);
			} else message = "El huerto está lleno !!";
		}
		System.out.println(message);
	}
	
	synchronized public void tear(Client client, int quantity) {
		String message = "";
		for (int idx = 0; idx < quantity; idx++) {
			message = "Se ha iniciado el proceso de extracción para " + client.getName();
			if (this.vegetablesCollection.size() > 0) {
				message += "Extrayendo " + vegetablesCollection.get(idx).getName() + "\n";
				vegetablesCollection.remove(0);
			} else message = "El huerto está vacío";
		}
		System.out.println(message);
	}
	
	synchronized public void showVegetablesAvailable(Client client, Vegetable vegetable) {
		String message = client.getName() + " pregunta por cuantos " + vegetable.getName() + " hay... \n";
		int count = 0;
		for (int i = 0; i < vegetablesCollection.size(); i++) {
			if (vegetablesCollection.get(i).getName().equals(vegetable.getName())) {
				count ++;
			}
		}
		System.out.println(message + "- Pues hay " + count + " " + vegetable.getName());
	}
	
	
	
}
