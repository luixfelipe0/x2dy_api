package x2dy.school.api.model.dto.professor;

import x2dy.school.api.model.dto.endereco.EnderecoDto;
import x2dy.school.api.model.entity.Especialidade;
import x2dy.school.api.model.entity.Professor;

public record DetalharProfessorDto(Long id, String nome, String cpf, String email, String telefone, Especialidade especialidade, EnderecoDto endereco, boolean ativo) {

    public DetalharProfessorDto(Professor prof) {
        this(
                prof.getId(),
                prof.getNome(),
                prof.getCpf(),
                prof.getEmail(),
                prof.getTelefone(),
                prof.getEspecialidade(),
                new EnderecoDto(prof.getEndereco()),
                prof.isAtivo()
        );
    }

}
