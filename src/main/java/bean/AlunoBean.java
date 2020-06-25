/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Aluno;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import util.SituacaoNotas;

/**
 *
 * @author EDUARDO
 */
@ManagedBean
@SessionScoped
public class AlunoBean {

    SituacaoNotas sn = new SituacaoNotas();
    Aluno a = new Aluno();

    public Aluno getA() {
        return a;
    }

    public void setA(Aluno a) {
        this.a = a;
    }

    public SituacaoNotas getSn() {
        return sn;
    }

    public void setSn(SituacaoNotas sn) {
        this.sn = sn;
    }

    public void cadastrar() {
        a.setNotaFinal(sn.getMedia());
        a.setStatus(sn.situacao());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.merge(a);
        etx.commit();
        em.close();
        emf.close();

    }

    public String concluir() {
        a = new Aluno();
        sn = new SituacaoNotas();
        return "sucesso";
    }

    public List<Aluno> getAlunos() {
        List<Aluno> alunos = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT a FROM Aluno a", Aluno.class);
        alunos = q.getResultList();
        return alunos;

    }

    public void excluir(Aluno a) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        a = em.merge(a);
        em.remove(a);
        etx.commit();
        em.close();
        emf.close();
    }

    public void selecionar(Aluno a) {
        this.a = a;
    }

    public void limpar() {
        a = new Aluno();
    }

    public List<Aluno> getAlunoNome() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.nome = :nome";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("nome", a.getNome());
        for (Aluno a : query.getResultList()) {
            if (a.getNome().equals(a.getNome())) {
                alunos = query.getResultList();
            }
        }
        return alunos;

    }

    public List<Aluno> getAlunoCpf() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.cpf = :cpf";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("cpf", a.getCpf());
        for (Aluno a : query.getResultList()) {
            if (a.getCpf().equals(a.getCpf())) {
                alunos = query.getResultList();
            }
        }
        return alunos;

    }

    public List<Aluno> getAlunoStatus() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.status = :status";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("status", a.getStatus());
        for (Aluno a : query.getResultList()) {
            if (a.getStatus().equals(a.getStatus())) {
                alunos = query.getResultList();
            }
        }
        return alunos;

    }

    public List<Aluno> getAlunoNascimento() {
        List<Aluno> alunos = null;
        String consulta = "SELECT a FROM Aluno a WHERE a.dataNascimento = :dataNascimento";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Aluno> query = em.createQuery(consulta, Aluno.class);
        query.setParameter("dataNascimento", a.getDataNascimento());
        for (Aluno a : query.getResultList()) {
            if (a.getDataNascimento().equals(a.getDataNascimento())) {
                alunos = query.getResultList();
            }
        }
        return alunos;

    }

}
