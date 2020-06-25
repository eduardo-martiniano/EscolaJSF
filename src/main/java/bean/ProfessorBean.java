/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Professor;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import util.FolhaPagamento;

/**
 *
 * @author EDUARDO
 */
@ManagedBean
@SessionScoped
public class ProfessorBean {

    FolhaPagamento fp = new FolhaPagamento();
    Professor p = new Professor();
    List<Professor> professores = new ArrayList<Professor>();

    public FolhaPagamento getFp() {
        return fp;
    }

    public void setFp(FolhaPagamento fp) {
        this.fp = fp;
    }

    public Professor getP() {
        return p;
    }

    public void setP(Professor p) {
        this.p = p;
    }

    public void cadastrar() {
        fp.setSalario(p.getSalario());
        p.setSalario(fp.getSalarioliquido());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.merge(p);
        etx.commit();
        em.close();
        emf.close();

    }

    public String concluir() {
        p = new Professor();
        return "sucesso";
    }

    public List<Professor> getProfessores() {
        List<Professor> professores = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT p FROM Professor p", Professor.class);
        professores = q.getResultList();
        return professores;

    }

    public void excluir(Professor p) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        p = em.merge(p);
        em.remove(p);
        etx.commit();
        em.close();
        emf.close();
    }

    public void selecionar(Professor p) {
        this.p = p;
    }

    public void limpar() {
        p = new Professor();
    }

    public List<Professor> getProfessorNome() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.nome = :nome";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("nome", p.getNome());
        for (Professor p : query.getResultList()) {
            if (p.getNome().equals(p.getNome())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }

    public List<Professor> getProfessorID() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.id = :id";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("id", p.getId());
        for (Professor p : query.getResultList()) {
            if (p.getId().equals(p.getId())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }

    public List<Professor> getProfessorInteresse() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.interesses = :interesses";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("interesses", p.getInteresses());
        for (Professor p : query.getResultList()) {
            if (p.getInteresses().equals(p.getInteresses())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }

    public List<Professor> getProfessorDisciplina() {
        List<Professor> professores = null;
        String consulta = "SELECT p FROM Professor p WHERE p.disciplinas = :disciplinas";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Professor> query = em.createQuery(consulta, Professor.class);
        query.setParameter("disciplinas", p.getDisciplinas());
        for (Professor p : query.getResultList()) {
            if (p.getDisciplinas().equals(p.getDisciplinas())) {
                professores = query.getResultList();
            }
        }
        return professores;

    }

}
