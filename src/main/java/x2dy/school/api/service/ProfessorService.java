package x2dy.school.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import x2dy.school.api.exception.ValidacaoException;
import x2dy.school.api.model.dto.professor.AtualizacaoProfessorDto;
import x2dy.school.api.model.dto.professor.CadastroProfessorDto;
import x2dy.school.api.model.dto.professor.DetalharProfessorDto;
import x2dy.school.api.model.dto.professor.ListagemProfessorDto;
import x2dy.school.api.model.entity.Professor;
import x2dy.school.api.repository.ProfessorRepository;

import java.util.List;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public void cadastrar(CadastroProfessorDto dto) {
        boolean jaCadastrado = repository.existsByCpf(dto.cpf());
        if(jaCadastrado) {
            throw new ValidacaoException("Professor já cadastrado!");
        }

        repository.save(new Professor(dto));
    }

    public List<ListagemProfessorDto> listar() {
        return repository
                .findAllByAtivoTrue()
                .stream()
                .map(ListagemProfessorDto::new)
                .toList();
    }

    public DetalharProfessorDto detalhar(Long id) {
        Professor professor = repository.getReferenceById(id);

        return new DetalharProfessorDto(professor);
    }

    public void atualizar(AtualizacaoProfessorDto dto, Long id) {
        Professor professor = repository.getReferenceById(id);
        professor.atualizarInformacoes(dto);
    }

    public void desativar(Long id) {
        Professor professor = repository.getReferenceById(id);
        professor.inativar();
    }

}
