package com.servicios5estrellas.repository;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import com.servicios5estrellas.model.Cliente;
import com.servicios5estrellas.model.Servicio;

public class Test {
	
	public static final String ODB_NAME = "testODB";
	
	public String prueba() {
		System.out.println("Test.prueba");
		saveServicio();
		getServicios();
		return "fin Test.prueba";
	}
	
	public void saveServicio() {
		System.out.println("Test.saveServicios");
		ODB odb = null;
		try{
			// Create instance
			Servicio servicio = new Servicio(1, "Lavado de Alfombras");
			// Open the database
			odb = ODBFactory.open(ODB_NAME);
			// Store the object
			odb.store(servicio);
		} finally{
			if(odb!=null){
				// Close the database
				odb.close();
			}
		}
	}
	
	public void getServicios() {
		System.out.println("Test.getServicios");
		
		ODB odb = null;
		try{
			// Open the database
			odb = ODBFactory.open(ODB_NAME);
			// Get all object of type clazz
			Objects<Servicio> objects = odb.getObjects(Servicio.class);
			System.out.println(objects.size() + " servicios");
			// display each object
			while(objects.hasNext()){
				System.out.println("1 " + "\t: " + objects.next());
			}
		}finally{
			// Closes the database
			if(odb != null){
				odb.close();
			}
		}
	}
	
//	Ejemplo para simular un DAO para la ODB Neodatis
	public void save(Cliente cli) {
		System.out.println("Test.crearcliente");
		ODB odb = null;

		try{
			// Open the database
			odb = ODBFactory.open(ODB_NAME);
			// Store the object
			odb.store(cli);
		} finally{
			if(odb!=null){
				// Close the database
				odb.close();
			}
		}

	}

}
