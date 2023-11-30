package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codigo;
	
	@Column(name="nomeCurso")
    private String nome;
	
	@Column(name="descricaoCurso")
    private String descricao;
	
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "curso_aluno",
    	joinColumns = @JoinColumn(name = "curso_id"),
    	inverseJoinColumns = @JoinColumn(name = "aluno_id"))
	private List<Aluno> alunos;
	
	public void adicionarAluno(Aluno a) {
		alunos.add(a);
	}
	
    public List<Aluno> getAlunos() {
		return alunos;
	}

	public Curso() {
		
    }

    public Curso(Integer codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	@Override
	public String toString() {
		return "\nCódigo: " + codigo + "\nNome: " + nome + "\nDescrição: " + descricao + "\n";
	}
	    
	    
}
