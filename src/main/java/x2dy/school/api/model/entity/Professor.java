package x2dy.school.api.model.entity;

import jakarta.persistence.*;
import x2dy.school.api.model.dto.professor.AtualizacaoProfessorDto;
import x2dy.school.api.model.dto.professor.CadastroProfessorDto;

@Entity(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    @Embedded
    private Endereco endereco;
    private boolean ativo;

    public Professor() {
    }

    public Professor(CadastroProfessorDto dto) {
        this.nome = dto.nome();
        this.cpf = dto.cpf();
        this.email = dto.email();
        this.telefone = dto.telefone();
        this.especialidade = dto.especialidade();
        this.endereco = new Endereco(dto.endereco());
        this.ativo = true;
    }

    public Long getId() {
        return id;
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

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void atualizarInformacoes(AtualizacaoProfessorDto dto) {

        if(dto.email() != null) {
            this.email = dto.email();
        }
        if(dto.telefone() != null) {
            this.telefone = dto.telefone();
        }
        if(dto.especialidade() != null) {
            this.especialidade = dto.especialidade();
        }
        if(dto.endereco() != null) {
            this.endereco.atualizarEndereco(dto.endereco());
        }


    }

    public void inativar() {
        this.ativo = false;
    }
}
