package x2dy.school.api.model.entity;

import jakarta.persistence.*;
import x2dy.school.api.model.dto.aluno.AtualizacaoAlunoDto;
import x2dy.school.api.model.dto.aluno.CadastroAlunoDto;

@Entity(name = "aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long matricula;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Aluno() {}

    public Aluno(CadastroAlunoDto dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }

    public Long getMatricula() {
        return matricula;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(AtualizacaoAlunoDto dto) {
        if(dto.email() != null) {
            this.email = dto.email();
        }
        if(dto.telefone() != null) {
            this.telefone = dto.telefone();
        }
        if(dto.endereco() != null) {
            this.endereco.atualizarEndereco(dto.endereco());
        }
    }

    public void desativar() {
        this.ativo = false;
    }
}
