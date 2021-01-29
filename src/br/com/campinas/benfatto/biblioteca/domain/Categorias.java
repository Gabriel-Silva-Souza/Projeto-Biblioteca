package br.com.campinas.benfatto.biblioteca.domain;

public enum Categorias {
    ACAO("Acão"),
    TECNOLOGIA("Tecnologia"),
    MECANICA("Mecanica"),
    ELETRICA("Eletrica");

    private String descricao;

    Categorias(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
