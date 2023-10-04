package x2dy.school.api.model.dto.aluno;

import x2dy.school.api.model.dto.endereco.EnderecoDto;
import x2dy.school.api.model.entity.Aluno;

public record DetalharAlunoDto(Long matricula, String nome, String cpf, String email, String telefone, EnderecoDto endereco, boolean ativo) {

    public DetalharAlunoDto(Aluno aluno) {
        this(aluno.getMatricula(), aluno.getNome(), aluno.getCpf(), aluno.getEmail(), aluno.getTelefone(), new EnderecoDto(aluno.getEndereco()), aluno.isAtivo());
    }

}
