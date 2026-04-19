package model;

import java.time.LocalDate;
import java.util.UUID;

public class Autor {
    private final String id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String nome, LocalDate dataNascimento) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
