package model;

import java.time.LocalDate;
import java.util.UUID;

public class Livro {
    private final String id;
    private String titulo;
    private Autor autor;
    private Boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(String titulo, Autor autor) {
        this.id = UUID.randomUUID().toString();
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = LocalDate.now();
        this.dataAtualizacao = LocalDate.now();
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }
}
