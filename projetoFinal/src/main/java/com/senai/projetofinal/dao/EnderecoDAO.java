/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

import com.senai.projetofinal.model.CadastroCliente;
import com.senai.projetofinal.model.Endereco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lisandro_bitencourt
 */
@Stateless
public class EnderecoDAO {

    @PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void inserir(CadastroCliente cliente) {
        //System.out.println(endereco.getBairro());
        em.persist(cliente.getEndereco());
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Endereco.class, id));
    }

    public Endereco buscar(Long id) {
        return em.find(Endereco.class, id);
    }

    public void atualizar(Endereco endereco) {
        em.merge(endereco);
    }

    public List<Endereco> listar() {
        TypedQuery<Endereco> q = em.createQuery("SELECT e FROM Endereco e ORDER BY nome ", Endereco.class);
        return q.getResultList();
    }

}
