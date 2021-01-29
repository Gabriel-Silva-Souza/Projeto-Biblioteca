package br.com.campinas.benfatto.biblioteca.domain;

import java.util.ArrayList;
import java.util.Map;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private ArrayList<Cliente> clientes;
    private ArrayList<Categoria> categorias;

    public Biblioteca() {
        this.livros = new ArrayList<Livro>();
        this.clientes = new ArrayList<Cliente>();
        this.categorias = new ArrayList<Categoria>();
    }

    public Biblioteca(ArrayList<Livro> livros, ArrayList<Cliente> clientes) {
        this.livros = livros;
        this.clientes = clientes;
    }

    public String adicionaCliente (Cliente cliente) {
        if (cliente != null) {
            clientes.add(cliente);
            return "Cliente registrado com sucesso";
        }
        return "Cliente não registrado";
    }

    public void removeCliente(Integer codigo){
        if(codigo != null || codigo > 0) {
            for (Cliente cliente : this.clientes) {
                if (cliente.getCodigo() == codigo) {
                    this.clientes.remove(cliente);
                    System.out.println("Cliente " + cliente + "removido com sucesso");
                }
            }
        }
        else{
            System.out.println("O codigo não pode ser nulo ou menor que 0");
        }
    }

    public String adicionaLivro (Livro livro) {
        if (livro != null) {
            this.livros.add(livro);
            return "Cliente registrado com sucesso";
        }
        return "Cliente não registrado";
    }

    public void removeLivro(Integer codigo){
        if(codigo != null || codigo > 0) {
            for (Livro livro : this.livros) {
                if (livro.getCodigo() == codigo) {
                    this.livros.remove(livro);
                    System.out.println( livro + " removido com sucesso");
                }
            }
        }
        else{
            System.out.println("O codigo não pode ser nulo ou menor que 0");
        }
    }

    public ArrayList<Livro> mostraTodosLivros(){
        return this.livros;
    }

    public ArrayList<Livro> mostraTodosLivrosPorCategoria(String categoria){
        ArrayList<Livro> livroPorCategoria = new ArrayList<Livro>();
        for(Livro livro : this.livros){
            if(livro.getCategoria() == categoria){
                livroPorCategoria.add(livro);
            }
        }
        return livroPorCategoria;
    }

    public ArrayList<Livro> mostraTodosLivrosPorAutor(String autor){
        ArrayList<Livro> livroPorAutor = new ArrayList<Livro>();
        for(Livro livro : this.livros){
            if(livro.getCategoria() == autor){
                livroPorAutor.add(livro);
            }
        }
        return livroPorAutor;
    }

    public String adicionaCategoria(Categoria categoria) {
        if (categoria != null) {
            categorias.add(categoria);
            return "Categoria registrada com sucessso";
        }
        return "Categoria não registrada, o valor não pode ser nulo";
    }

    public void removeCategoria(Integer id){
        if(id != null || id > 0) {
            for (Categoria categoria : this.categorias) {
                if (categoria.getId() == id) {
                    this.livros.remove(categoria);
                    System.out.println( categoria + " removido com sucesso");
                }
            }
        }
        else{
            System.out.println("O codigo não pode ser nulo ou menor que 0");
        }
    }
}
//livros.forEach()