package com.fag.lucasmartins.arquitetura_software.core.domain.bo;

import com.fag.lucasmartins.arquitetura_software.core.domain.exceptions.DomainException;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class PessoaBO {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public PessoaBO() {
    }

    public PessoaBO(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    public void validarMaioridade() {
        if (dataNascimento == null) {
            throw new DomainException("Data de nascimento é obrigatória.");
        }
        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("A pessoa deve ter no mínimo 18 anos de idade.");
        }
    }

    public void validarCpf() {
        if (cpf == null || cpf.trim().isEmpty()) {
            throw new DomainException("CPF é obrigatório.");
        }
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11) {
            throw new DomainException("CPF deve conter exatamente 11 caracteres numéricos.");
        }
    }

    public void validarEmail() {
        if (email == null || email.trim().isEmpty()) {
            throw new DomainException("Email é obrigatório.");
        }
        if (!email.contains("@")) {
            throw new DomainException("Email deve conter o caractere '@'.");
        }
    }

    public void validarTelefone() {
        if (telefone == null || telefone.trim().isEmpty()) {
            throw new DomainException("Telefone é obrigatório.");
        }
        String telefoneLimpo = telefone.replaceAll("[^0-9]", "");
        if (telefoneLimpo.length() != 11) {
            throw new DomainException("Telefone deve conter exatamente 11 caracteres numéricos.");
        }
    }

    public void validar() {
        validarCpf();
        validarEmail();
        validarTelefone();
        validarMaioridade();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}

