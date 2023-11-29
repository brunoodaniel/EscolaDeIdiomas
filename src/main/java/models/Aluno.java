package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Aluno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer matricula;
	
	@Column(name="nomeAluno")
    private String nome;
	
	
	@Column(name="cpfAluno")
	private Integer cpf;
	
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

    public Aluno() {
    	
    }

    public Aluno(Integer matricula, String nome, Integer cpf, Curso curso) {
    	this.matricula = matricula;
    	this.nome = nome;
        this.cpf = cpf;
        this.curso = curso;
    }

    public Integer getCpf() {
        return cpf;
    }

	public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }
    
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "\nMatrícula: " + matricula + "\nNome: " + nome + "\nCPF: " + cpf + "\nCurso: " + curso + "\n";
	}    
	    
}
