package jpaMapeamentos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tid;

    private String tnome;

    @Column(nullable = true)
    private String Assunto;

    @ManyToMany
    @JoinTable(
            name = "professor_classe",
            joinColumns = @JoinColumn(name = "professor_id", referencedColumnName = "tid"),
            inverseJoinColumns = @JoinColumn(name = "classe_id", referencedColumnName = "cid"))
    private List<Classe> classe;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTnome() {
        return tnome;
    }

    public void setTnome(String tnome) {
        this.tnome = tnome;
    }

    public String getAssunto() {
        return Assunto;
    }

    public void setAssunto(String assunto) {
        Assunto = assunto;
    }

    public List<Classe> getClasse() {
        return classe;
    }

    public void setClasse(List<Classe> classe) {
        this.classe = classe;
    }


}
