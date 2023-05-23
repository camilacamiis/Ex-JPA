package jpaMapeamentos;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cid;
    private String cnome;

    @ManyToMany(mappedBy = "classe")
    private List<Professor> professor;

    public Long getCid() {
        return cid;
    }
    public void setCid(Long cid) {
        this.cid = cid;
    }
    public String getCnome() {
        return cnome;
    }
    public void setCnome(String cnome) {
        this.cnome = cnome;
    }
    public List<Professor> getProfessor() {
        return professor;
    }
    public void setProfessor(List<Professor> professor) {
        this.professor = professor;
    }
}
