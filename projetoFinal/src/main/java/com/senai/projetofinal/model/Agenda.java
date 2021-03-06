/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duda
 */
@Entity
@Table(name = "agendamentos")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = true)
    private Date data;
    @Temporal(TemporalType.TIME)
    @Column(name = "horario", nullable = true)

    private Date horario;

    @Column(name = "status")
    private Integer status = 0;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinTable(
               name = "agendamentos_servicos", joinColumns = {
                   @JoinColumn(name = "id_agendamento")
               }, inverseJoinColumns = {
                   @JoinColumn(name = "id_servico")
               }
    )
    private List<Servico> listaServico = new ArrayList<>();

    @Column(name = "valorTotal")
    private Double valorTotal;
    /* @ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "id_usuario")
     private Usuario usuario;*/
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    public Agenda(Long id, Date data, Date horario, Double valorTotal, Cliente cliente) {
        this.id = id;
        this.data = data;
        this.horario = horario;
        this.valorTotal = valorTotal;
        this.cliente = cliente;
    }

    public Agenda() {
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
     this.id = id;
     }*/
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
