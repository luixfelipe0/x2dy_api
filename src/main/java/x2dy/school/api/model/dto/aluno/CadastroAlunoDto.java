package x2dy.school.api.model.dto.aluno;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import x2dy.school.api.model.dto.endereco.EnderecoDto;

public record CadastroAlunoDto(
        @NotBlank
        String nome,
        @NotBlank
        @Pattern(regexp = "[0-9]{3}[.?][0-9]{3}[.?][0-9]{3}[-?][0-9]{2}")
        String cpf,
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Pattern(regexp = "\\(?\\d{2}\\)?\\d?\\d{4}-?\\d{4}")
        String telefone,
        @Valid
        EnderecoDto endereco) {
}
