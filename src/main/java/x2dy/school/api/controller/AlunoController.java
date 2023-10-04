package x2dy.school.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import x2dy.school.api.exception.ValidacaoException;
import x2dy.school.api.model.dto.aluno.AtualizacaoAlunoDto;
import x2dy.school.api.model.dto.aluno.CadastroAlunoDto;
import x2dy.school.api.model.dto.aluno.DetalharAlunoDto;
import x2dy.school.api.model.dto.aluno.ListagemAlunoDto;
import x2dy.school.api.service.AlunoService;

import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarAluno(@Valid @RequestBody CadastroAlunoDto dto) {
        try {
            alunoService.cadastrar(dto);
            return ResponseEntity.ok().build();
        } catch(ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemAlunoDto>> listarAluno() {
        List<ListagemAlunoDto> listaDeAlunos = alunoService.listar();
        return ResponseEntity.ok().body(listaDeAlunos);
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<DetalharAlunoDto> detalharAluno(@PathVariable Long matricula) {
        DetalharAlunoDto alunoDto = alunoService.detalhar(matricula);
        return ResponseEntity.ok().body(alunoDto);
    }

    @PutMapping("/{matricula}")
    @Transactional
    public ResponseEntity AtualizarAluno(@Valid @RequestBody AtualizacaoAlunoDto dto, @PathVariable Long matricula) {
        alunoService.atualizar(dto, matricula);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{matricula}")
    @Transactional
    public ResponseEntity desativarAluno(@PathVariable Long matricula) {
        try {
            alunoService.desmatricular(matricula);
            return ResponseEntity.noContent().build();
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
