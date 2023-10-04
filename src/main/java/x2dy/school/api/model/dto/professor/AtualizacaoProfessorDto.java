package x2dy.school.api.model.dto.professor;

import x2dy.school.api.model.dto.endereco.EnderecoDto;
import x2dy.school.api.model.entity.Especialidade;

public record AtualizacaoProfessorDto(String email, String telefone, Especialidade especialidade, EnderecoDto endereco) {
}
