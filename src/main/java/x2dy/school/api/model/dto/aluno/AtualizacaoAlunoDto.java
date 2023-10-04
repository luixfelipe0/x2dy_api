package x2dy.school.api.model.dto.aluno;

import x2dy.school.api.model.dto.endereco.EnderecoDto;

public record AtualizacaoAlunoDto(String email, String telefone, EnderecoDto endereco) {
}
