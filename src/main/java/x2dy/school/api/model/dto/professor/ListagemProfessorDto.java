package x2dy.school.api.model.dto.professor;

import x2dy.school.api.model.entity.Especialidade;
import x2dy.school.api.model.entity.Professor;

public record ListagemProfessorDto(Long id, String nome, String email, Especialidade especialidade) {

    public ListagemProfessorDto(Professor prof) {
        this(prof.getId(), prof.getNome(), prof.getEmail(), prof.getEspecialidade());
    }

}
