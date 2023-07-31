package com.servicios5estrellas.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Orden_De_Trabajo {
	
	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="OT_GEN")
	@Column(name = "OT_ID")
	private int idOT;
	
	@Column(name = "total")
	private Integer total;
	
	@Column(name = "fecha")
	private LocalDate fecha;
	
	@Column(name = "observacion")
	private String observacion;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CLIENT_ID")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "ot", cascade = CascadeType.ALL)
	private List<ServicioOT> servicios = new ArrayList<>();

	public Orden_De_Trabajo() {
//		super();
	}

	public Orden_De_Trabajo(int idOT, Integer total, LocalDate fecha, String observacion, Cliente cliente) {
		this.idOT = idOT;
		this.total = total;
		this.fecha = fecha;
		this.observacion = observacion;
		this.cliente = cliente;
	}

	public Orden_De_Trabajo(Integer total, LocalDate fecha, String observacion, Cliente cliente) {
		this.total = total;
		this.fecha = fecha;
		this.observacion = observacion;
		this.cliente = cliente;
	}

	public int getIdOT() {
		return idOT;
	}

	public void setIdOT(int idOT) {
		this.idOT = idOT;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ServicioOT> getServicios() {
		return servicios;
	}

	public void setServicios(List<ServicioOT> servicios) {
		this.servicios = servicios;
	}
	
	public void addServicioOT(ServicioOT servicioOT) {
		servicioOT.setOt(this);
		servicios.add(servicioOT);
	}

	@Override
	public String toString() {
		return "Orden_De_Trabajo [idOT=" + idOT + ", total=" + total + ", fecha=" + fecha + ", observacion="
				+ observacion + ", cliente=" + cliente.getIdCliente() + "]";
	}

}
