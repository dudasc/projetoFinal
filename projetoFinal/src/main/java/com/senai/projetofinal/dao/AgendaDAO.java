/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

import com.senai.projetofinal.model.Agenda;
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
public class AgendaDAO {

    @PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void inserir(Agenda agenda) {
        em.persist(agenda);
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Agenda.class, id));
    }

    public Agenda buscar(Long id) {
        return em.find(Agenda.class, id);
    }

    public Agenda atualizar(Agenda agenda) {
        return em.merge(agenda);
    }

    public List<Agenda> listar() {
        TypedQuery<Agenda> q = em.createQuery("SELECT ag FROM Agenda ag ", Agenda.class);
        return q.getResultList();
    }

}
