package x2dy.school.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import x2dy.school.api.exception.ValidacaoException;
import x2dy.school.api.model.dto.aluno.AtualizacaoAlunoDto;
import x2dy.school.api.model.dto.aluno.CadastroAlunoDto;
import x2dy.school.api.model.dto.aluno.DetalharAlunoDto;
import x2dy.school.api.model.dto.aluno.ListagemAlunoDto;
import x2dy.school.api.model.entity.Aluno;
import x2dy.school.api.repository.AlunoRepository;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public void cadastrar(CadastroAlunoDto dto) {
        boolean jaCadastrado = alunoRepository.existsByCpf(dto.cpf());
        if(jaCadastrado) {
            throw new ValidacaoException("Aluno já cadastrado");
        }
        alunoRepository.save(new Aluno(dto));
    }

    public List<ListagemAlunoDto> listar() {
        return alunoRepository
                .findAllByAtivoTrue()
                .stream()
                .map(ListagemAlunoDto::new)
                .toList();
    }

    public void atualizar(AtualizacaoAlunoDto dto, Long matricula) {
        Aluno aluno = alunoRepository.getReferenceById(matricula);

        aluno.atualizarInformacoes(dto);
    }

    public void desmatricular(Long matricula) {
        Aluno aluno = alunoRepository.getReferenceById(matricula);
        if (!aluno.isAtivo()) {
            throw new ValidacaoException("Aluno já está desmatriculado!");
        }

        aluno.desativar();
    }

    public DetalharAlunoDto detalhar(Long matricula) {
        Aluno aluno = alunoRepository.getReferenceById(matricula);

        return new DetalharAlunoDto(aluno);
    }
}
