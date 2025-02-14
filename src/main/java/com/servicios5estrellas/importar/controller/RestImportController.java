package com.servicios5estrellas.importar.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.servicios5estrellas.model.Cliente;
import com.servicios5estrellas.model.Orden_De_Trabajo;
import com.servicios5estrellas.model.ServicioOT;
import com.servicios5estrellas.repository.IClienteRepository;

@RestController
public class RestImportController {
	
	@Autowired
	private IClienteRepository repocliente;
	
	@PostMapping("/importDatos")
	public void save(@RequestBody List<Cliente> clientes, HttpServletRequest req) {
		System.out.println("RestImportController.save ");
		System.out.println("usuarios size  "+clientes.size());
		
		for (Cliente cliente : clientes) {
			
//			System.out.println("cliente  "+cliente);
			
			for (Orden_De_Trabajo ot : cliente.getOrdenes_de_trabajo()) {
				ot.setCliente(cliente);
				for (ServicioOT servicio : ot.getServicios()) {
					servicio.setOt(ot);
				}
			}
			repocliente.save(cliente);
		}
		
		System.out.println("Importación terminada ...  ");
		
	}

}
