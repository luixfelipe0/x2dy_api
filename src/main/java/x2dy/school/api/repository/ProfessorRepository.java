package x2dy.school.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import x2dy.school.api.model.entity.Professor;

import java.util.Collection;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    boolean existsByCpf(String cpf);

    List<Professor> findAllByAtivoTrue();
}
