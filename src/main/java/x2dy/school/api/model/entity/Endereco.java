package x2dy.school.api.model.entity;

import jakarta.persistence.Embeddable;
import x2dy.school.api.model.dto.endereco.EnderecoDto;

@Embeddable
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String numero;
    private String cidade;
    private String uf;

    public Endereco() {
    }

    public Endereco(EnderecoDto dto) {
        this.cep = dto.cep();
        this.logradouro = dto.logradouro();
        this.complemento = dto.complemento();
        this.bairro = dto.bairro();
        this.numero = dto.numero();
        this.cidade = dto.cidade();
        this.uf = dto.uf();
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getNumero() {
        return numero;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public void atualizarEndereco(EnderecoDto dto) {
        if(dto.cep() != null) {
            this.cep = dto.cep();
        }
        if(dto.logradouro() != null) {
            this.logradouro = dto.logradouro();
        }
        if(dto.complemento() != null) {
            this.complemento = dto.complemento();
        }
        if(dto.bairro() != null) {
            this.bairro = dto.bairro();
        }
        if(dto.numero() != null) {
            this.numero = dto.numero();
        }
        if(dto.cidade() != null) {
            this.cidade = dto.cidade();
        }
        if(dto.uf() != null) {
            this.uf = dto.uf();
        }
    }
}
