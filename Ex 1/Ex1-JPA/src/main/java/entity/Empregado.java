package entity;

import jakarta.persistence.*;

@Entity
public class Empregado {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idEmpregado")
    private int idEmpregado;
    @Basic
    @Column(name = "Nome")
    private String nome;
    @Basic
    @Column(name = "Sobrenome")
    private String sobrenome;
    @Basic
    @Column(name = "Departamento_Id")
    private String departamentoId;

    public int getIdEmpregado() {
        return idEmpregado;
    }

    public void setIdEmpregado(int idEmpregado) {
        this.idEmpregado = idEmpregado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDepartamentoId() {
        return departamentoId;
    }

    public void setDepartamentoId(String departamentoId) {
        this.departamentoId = departamentoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empregado empregado = (Empregado) o;

        if (idEmpregado != empregado.idEmpregado) return false;
        if (nome != null ? !nome.equals(empregado.nome) : empregado.nome != null) return false;
        if (sobrenome != null ? !sobrenome.equals(empregado.sobrenome) : empregado.sobrenome != null) return false;
        if (departamentoId != null ? !departamentoId.equals(empregado.departamentoId) : empregado.departamentoId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEmpregado;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (sobrenome != null ? sobrenome.hashCode() : 0);
        result = 31 * result + (departamentoId != null ? departamentoId.hashCode() : 0);
        return result;
    }
}
