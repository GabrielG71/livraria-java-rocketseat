import java.time.LocalDate;
import java.util.Scanner;

import model.Autor;
import model.Livro;
import model.Emprestimo;
import repository.Biblioteca;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        Autor autor1 = new Autor("Manoel Carlos", LocalDate.of(2007, 8, 21));
        Autor autor2 = new Autor("Gerônimo Meire", LocalDate.of(1821, 8, 4));

        biblioteca.adicionarAutor(autor1);
        biblioteca.adicionarAutor(autor2);

        biblioteca.adicionarLivro(new Livro("Dom Casmurro", autor1));
        biblioteca.adicionarLivro(new Livro("Harry Potter e a Pedra Filosofal", autor2));
        biblioteca.adicionarLivro(new Livro("O Senhor dos Anéis", autor2));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Deseja ver a lista de livros disponíveis? (S/N)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("S")) {
            System.out.println("\nLivros disponíveis:\n");

            for (Livro livro : biblioteca.getLivros()) {
                if (livro.getDisponivel()) {
                    System.out.println("ID: " + livro.getId());
                    System.out.println("Título: " + livro.getTitulo());
                    System.out.println("Autor: " + livro.getAutor().getNome());
                    System.out.println("---");
                }
            }

            System.out.println("\nDigite o ID do livro que deseja emprestar:");
            String idLivro = scanner.nextLine();

            System.out.println("Digite seu nome:");
            String nomeCliente = scanner.nextLine();

            Livro livroEscolhido = null;
            for (Livro livro : biblioteca.getLivros()) {
                if (livro.getId().equals(idLivro)) {
                    livroEscolhido = livro;
                    break;
                }
            }

            if (livroEscolhido != null && livroEscolhido.getDisponivel()) {
                Emprestimo emprestimo = new Emprestimo(livroEscolhido, nomeCliente, LocalDate.now(), null);
                biblioteca.getEmprestimos().add(emprestimo);
                livroEscolhido.setDisponivel(false);
                System.out.println("\nEmpréstimo realizado com sucesso! Boa leitura, " + nomeCliente + ".");
            } else {
                System.out.println("\nLivro não encontrado ou indisponível.");
            }

        } else {
            System.out.println("\nAté logo!");
        }

        scanner.close();
    }
}