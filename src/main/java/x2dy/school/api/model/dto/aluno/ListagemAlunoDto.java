package x2dy.school.api.model.dto.aluno;

import x2dy.school.api.model.entity.Aluno;

public record ListagemAlunoDto(Long matricula, String nome, String email) {

    public ListagemAlunoDto(Aluno aluno) { this(aluno.getMatricula(), aluno.getNome(), aluno.getEmail()); }

}
