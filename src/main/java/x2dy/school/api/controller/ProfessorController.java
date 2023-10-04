package x2dy.school.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import x2dy.school.api.exception.ValidacaoException;
import x2dy.school.api.model.dto.professor.AtualizacaoProfessorDto;
import x2dy.school.api.model.dto.professor.CadastroProfessorDto;
import x2dy.school.api.model.dto.professor.DetalharProfessorDto;
import x2dy.school.api.model.dto.professor.ListagemProfessorDto;
import x2dy.school.api.service.ProfessorService;

import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService service;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarProfessor(@Valid @RequestBody CadastroProfessorDto dto) {
        try {
            service.cadastrar(dto);
            return ResponseEntity.ok().build();
        } catch (ValidacaoException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<ListagemProfessorDto>> listarProfessor() {
        List<ListagemProfessorDto> listaProfessor = service.listar();
        return ResponseEntity.ok().body(listaProfessor);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalharProfessorDto> detalharProfessor(@PathVariable Long id) {
        DetalharProfessorDto professor = service.detalhar(id);
        return ResponseEntity.ok().body(professor);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity atualizarProfessor(@Valid @RequestBody AtualizacaoProfessorDto dto, @PathVariable Long id) {
        service.atualizar(dto, id);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity desativarProfessor(@PathVariable Long id) {
        service.desativar(id);
        return ResponseEntity.noContent().build();
    }
}
