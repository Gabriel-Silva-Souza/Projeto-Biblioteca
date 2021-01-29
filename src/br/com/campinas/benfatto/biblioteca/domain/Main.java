package br.com.campinas.benfatto.biblioteca.domain;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Integer escolha = 0;
        Biblioteca bibliotecaBenfatto = new Biblioteca();
        Scanner scan = new Scanner(System.in);
        System.out.println("---------------------------------------------------");
        System.out.println("Bem vindo ao sistema de gerenciamento de biblioteca");
        System.out.println("---------------------------------------------------");
        System.out.println("--------------------Menu---------------------------");
        do {
            System.out.println("0 - Encerrar Programa");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Remover Livro");
            System.out.println("3 - Visualizar todos os livros Cadastrados");
            System.out.println("4 - Visualizar todos os livros por Categoria");
            System.out.println("5 - Visualizar todos os livros por Autor");
            System.out.println("6 - Cadastrar Categoria");
            System.out.println("7 - Visualizar todas as categorias");
            System.out.println("8 - Remover Categoria");
            System.out.println("9 - Cadastrar Usuario");
            System.out.println("10 - Remover Usuario");
            System.out.println("11 - Visualizar todos os usuarios");
            System.out.println("12 - Emprestar Livro");
            System.out.println("13 - Devolver Livro");
            System.out.println("14 - Pesquisa de livro específico");
            System.out.println("Qual opção voce deseja: ");

            escolha = scan.nextInt();
            switch (escolha){

                case 0:
                    break;

                case 1:
                    System.out.println("Voce escolheu a opção 1");
                    adicionarLivroBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 2:
                    System.out.println("Voce escolheu a opção 2");
                    removeLivroBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 3:
                    System.out.println("Voce escolheu a opção 3");
                    mostraTodosLivroBiblioteca(bibliotecaBenfatto);
                    break;

                case 4 :
                    System.out.println("Voce escolheu a opção 4");
                    mostraTodosLivroPorCategoriaBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 5 :
                    System.out.println("Voce escolheu a opção 5");
                    mostraTodosLivroPorAutorBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 6:
                    System.out.println("Voce escolheu a opção 6");
                    adicionarCategoriaBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 7:
                    System.out.println("Voce escolheu a opção 7");
                    visualizarCategoriaBiblioteca(bibliotecaBenfatto);
                    break;

                case 8:
                    System.out.println("Voce escolheu a opção 8");
                    removerCategoriaBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 9 :
                    System.out.println("Voce escolheu a opção 9");
                    adicionaClienteBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 10 :
                    System.out.println("Voce escolheu a opção 10");
                    removerClienteBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 11:
                    System.out.println("Voce escolheu a opção 11");
                    mostraTodosClientesBiblioteca(bibliotecaBenfatto);
                    break;

                case 12 :
                    System.out.println("Voce escolheu a opção 12");
                    emprestaLivroBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 13 :
                    System.out.println("Voce escolheu a opção 13");
                    devolveLivroBiblioteca(scan, bibliotecaBenfatto);
                    break;

                case 14:
                    System.out.println("Voce escolheu a opção 14");
                    pesquisaLivro(scan, bibliotecaBenfatto);
                    break;

                default:
                    System.out.println("Digite uma opção valida");
                    break;

            }

        }while (escolha > 0);
        System.out.println("Obrigado por utilizar nosso serviços, tenha um otimo dia");
    }

    public static void adicionarLivroBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo do livro: ");
        Integer codigo = scan.nextInt();
        System.out.println("Digite o nome do titulo do livro: ");
        String titulo = scan.next();
        System.out.println("Digite o nome do autor do livro");
        String autor = scan.next();
        System.out.println("Digite a categoria do curso");
        String categoria = scan.next();
        Livro livro = new Livro(codigo, titulo, autor, categoria);
        biblioteca.adicionaLivro(livro);
    }

    public static void removeLivroBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo do livro a ser removido: ");
        Integer codigoLivro = scan.nextInt();
        biblioteca.removeLivro(codigoLivro);
    }

    public static void mostraTodosLivroBiblioteca(Biblioteca biblioteca){
        for (Livro livro : biblioteca.mostraTodosLivros()){
            System.out.println(livro);
        }
    }

    public static void mostraTodosLivroPorCategoriaBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o nome da categoria da qual deseja visualizar: ");
        String categoriaLivro = scan.next();
        for (Livro livro : biblioteca.mostraTodosLivrosPorCategoria(categoriaLivro)){
            System.out.println(livro);
        }
    }

    public static void mostraTodosLivroPorAutorBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o nome do autor do qual deseja visualizar: ");
        String autorLivro = scan.next();
        for (Livro livro : biblioteca.mostraTodosLivrosPorAutor(autorLivro)){
            System.out.println(livro);
        }
    }

    public static void adicionarCategoriaBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo da categoria: ");
        Integer codigo = scan.nextInt();
        System.out.println("Digite o nome da categoria: ");
        String nome = scan.next();
        Categoria categoria = new Categoria(codigo, nome);
        biblioteca.adicionaCategoria(categoria);
    }

    public static void visualizarCategoriaBiblioteca(Biblioteca biblioteca){
        ArrayList<Categoria> categorias = biblioteca.mostraTodasCategorias();
        for (Categoria categoria : categorias){
            System.out.println(categoria);
        }
    }

    public static void removerCategoriaBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo da categoria: ");
        Integer codigo = scan.nextInt();
        biblioteca.removeCategoria(codigo);
    }

    public static void adicionaClienteBiblioteca(Scanner scan, Biblioteca biblioteca){
        //Cliente(Integer codigo, String nome, String email, String telefone, String CPF)
        System.out.println("Digite o codigo da cliente: ");
        Integer codigo = scan.nextInt();
        System.out.println("Digite o nome do cliente: ");
        String nome = scan.next();
        System.out.println("Digite o email do cliente: ");
        String email = scan.next();
        System.out.println("Digite o telefone do cliente: ");
        String telefone = scan.next();
        System.out.println("Digite o CPF do cliente: ");
        String CPF = scan.next();
        Cliente cliente = new Cliente(codigo, nome, email, telefone, CPF);
        biblioteca.adicionaCliente(cliente);
    }

    public static void removerClienteBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo do cliente do qual deseje remover: ");
        Integer codigoCliente = scan.nextInt();
        biblioteca.removeCliente(codigoCliente);
    }

    public static void mostraTodosClientesBiblioteca(Biblioteca biblioteca){
        ArrayList<Cliente> clientes = biblioteca.mostraTodosClientes();
        for(Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }

    public static void emprestaLivroBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo do cliente: ");
        Integer codigoCliente = scan.nextInt();
        System.out.println("Digite o codigo do livro: ");
        Integer codigoLivro = scan.nextInt();
        biblioteca.emprestaLivro(codigoCliente, codigoLivro);
    }

    public static void devolveLivroBiblioteca(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo do cliente: ");
        Integer codigoCliente = scan.nextInt();
        System.out.println("Digite o codigo do livro: ");
        Integer codigoLivro = scan.nextInt();
        biblioteca.devolveLivro(codigoCliente, codigoLivro);
    }

    public static void pesquisaLivro(Scanner scan, Biblioteca biblioteca){
        System.out.println("Digite o codigo do livro: ");
        Integer codigoLivro = scan.nextInt();
        biblioteca.buscaLivro(codigoLivro);
    }
    
}
