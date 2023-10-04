package x2dy.school.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import x2dy.school.api.model.entity.Aluno;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    boolean existsByCpf(String cpf);
    List<Aluno> findAllByAtivoTrue();

}
