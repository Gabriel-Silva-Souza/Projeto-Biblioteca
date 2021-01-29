package br.com.campinas.benfatto.biblioteca.domain;

public class Main {
    public static void main(String[] args){
        //Integer codigo, String titulo, String autor, String categoria, Boolean status
        Livro livroTest1 = new Livro(11, "A ida dos que nao foram", "Juquinha","Filosofia", true);
        Livro livroTest2 = new Livro(12, "A volta dos que nao foram", "Juquinha","Psicologia", true);

        Biblioteca diadema = new Biblioteca();
        diadema.adicionaLivro(livroTest1);
        System.out.println(diadema.mostraTodosLivros());
        diadema.adicionaLivro(livroTest2);
        System.out.println(diadema.mostraTodosLivros());
        diadema.removeLivro(11);
        System.out.println(diadema.mostraTodosLivros());
    }
}
