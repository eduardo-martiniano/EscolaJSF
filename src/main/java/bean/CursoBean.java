/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Curso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author EDUARDO
 */
@ManagedBean
@SessionScoped
public class CursoBean {

    Curso c = new Curso();

    public Curso getC() {
        return c;
    }

    public void setC(Curso c) {
        this.c = c;
    }

    public void cadastrar() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.merge(c);
        etx.commit();
        em.close();
        emf.close();

    }

    public String concluir() {
        c = new Curso();
        return "sucesso";
    }

    public List<Curso> getCursos() {
        List<Curso> cursos = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        Query c = em.createQuery("SELECT c FROM Curso c", Curso.class);
        cursos = c.getResultList();
        return cursos;

    }

    public void excluir(Curso c) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        c = em.merge(c);
        em.remove(c);
        etx.commit();
        em.close();
        emf.close();
    }

    public void selecionar(Curso c) {
        this.c = c;
    }

    public void limpar() {
        c = new Curso();
    }

    public List<Curso> getCursoTitulo() {
        List<Curso> cursos = null;
        String consulta = "SELECT c FROM Curso c WHERE c.titulo = :titulo";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Curso> query = em.createQuery(consulta, Curso.class);
        query.setParameter("titulo", c.getTitulo());
        for (Curso c : query.getResultList()) {
            if (c.getTitulo().equals(c.getTitulo())) {
                cursos = query.getResultList();
            }
        }
        return cursos;

    }

    public List<Curso> getCursoID() {
        List<Curso> cursos = null;
        String consulta = "SELECT c FROM Curso c WHERE c.id = :id";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Curso> query = em.createQuery(consulta, Curso.class);
        query.setParameter("id", c.getId());
        for (Curso c : query.getResultList()) {
            if (c.getId().equals(c.getId())) {
                cursos = query.getResultList();
            }
        }
        return cursos;

    }

}
