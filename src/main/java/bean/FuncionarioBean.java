/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entity.Funcionario;
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
public class FuncionarioBean {

    Funcionario f = new Funcionario();
    List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    FolhaPagamento fp = new FolhaPagamento();
    

    public FolhaPagamento getFp() {
        return fp;
    }

    public void setFp(FolhaPagamento fp) {
        this.fp = fp;
    }

    public Funcionario getF() {
        return f;
    }

    public void setF(Funcionario f) {
        this.f = f;
    }

    public void cadastrar() {
        fp.setSalario(f.getSalario());
        f.setSalario(fp.getSalarioliquido());
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        em.merge(f);
        etx.commit();
        em.close();
        emf.close();
        
        

    }

    public List<Funcionario> getFuncionarios() {
        List<Funcionario> funcionarios = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
        funcionarios = q.getResultList();
        return funcionarios;

    }

    public void excluir(Funcionario f) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        EntityTransaction etx = em.getTransaction();
        etx.begin();
        f = em.merge(f);
        em.remove(f);
        etx.commit();
        em.close();
        emf.close();
    }

    public void selecionar(Funcionario fu){
        this.f = fu;
    }

    public List<Funcionario> getFuncionarioNome() {
        List<Funcionario> funcionarios = null;
        String consulta = "SELECT f FROM Funcionario f WHERE f.nome = :nome";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
        query.setParameter("nome", f.getNome());
        for (Funcionario f : query.getResultList()) {
            if (f.getNome().equals(f.getNome())) {
                funcionarios = query.getResultList();
            }
        }
        return funcionarios;

    }

    public List<Funcionario> getFuncionarioID() {
        List<Funcionario> funcionarios = null;
        String consulta = "SELECT f FROM Funcionario f WHERE f.id = :id";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("puc");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Funcionario> query = em.createQuery(consulta, Funcionario.class);
        query.setParameter("id", f.getId());
        for (Funcionario f : query.getResultList()) {
            if (f.getId().equals(f.getId())) {
                funcionarios = query.getResultList();
            }
        }
        return funcionarios;

    }
    public String concluir(){
        f = new Funcionario();
        return "sucesso";
    }
    public void limpar(){
        f = new Funcionario();
    }

}