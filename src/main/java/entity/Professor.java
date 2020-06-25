/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author EDUARDO
 */
@Entity
@Table(name = "professor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p"),
    @NamedQuery(name = "Professor.findById", query = "SELECT p FROM Professor p WHERE p.id = :id"),
    @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome"),
    @NamedQuery(name = "Professor.findBySalario", query = "SELECT p FROM Professor p WHERE p.salario = :salario"),
    @NamedQuery(name = "Professor.findByRg", query = "SELECT p FROM Professor p WHERE p.rg = :rg"),
    @NamedQuery(name = "Professor.findByCpf", query = "SELECT p FROM Professor p WHERE p.cpf = :cpf"),
    @NamedQuery(name = "Professor.findByCargo", query = "SELECT p FROM Professor p WHERE p.cargo = :cargo"),
    @NamedQuery(name = "Professor.findByDisciplinas", query = "SELECT p FROM Professor p WHERE p.disciplinas = :disciplinas"),
    @NamedQuery(name = "Professor.findByInteresses", query = "SELECT p FROM Professor p WHERE p.interesses = :interesses")})
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "salario")
    private Float salario;
    @Size(max = 12)
    @Column(name = "rg")
    private String rg;
    @Size(max = 12)
    @Column(name = "cpf")
    private String cpf;
    @Size(max = 20)
    @Column(name = "cargo")
    private String cargo;
    @Size(max = 20)
    @Column(name = "disciplinas")
    private String disciplinas;
    @Size(max = 30)
    @Column(name = "interesses")
    private String interesses;

    public Professor() {
    }

    public Professor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getSalario() {
        return salario;
    }

    public void setSalario(Float salario) {
        this.salario = salario;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(String disciplinas) {
        this.disciplinas = disciplinas;
    }

    public String getInteresses() {
        return interesses;
    }

    public void setInteresses(String interesses) {
        this.interesses = interesses;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Professor[ id=" + id + " ]";
    }
    
}
