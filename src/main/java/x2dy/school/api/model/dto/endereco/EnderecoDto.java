package x2dy.school.api.model.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import x2dy.school.api.model.entity.Endereco;

public record EnderecoDto(
        @NotBlank
        String cep,
        @NotBlank
        String logradouro,
        String complemento,
        @NotBlank
        String bairro,
        @NotBlank
        String numero,
        @NotBlank
        String cidade,
        @NotBlank
        String uf) {

        public EnderecoDto(Endereco endereco) {
                this(
                        endereco.getCep(),
                        endereco.getLogradouro(),
                        endereco.getComplemento(),
                        endereco.getBairro(),
                        endereco.getNumero(),
                        endereco.getCidade(),
                        endereco.getUf()
                );
        }

}
