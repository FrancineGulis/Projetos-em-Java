/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemaacademicoher;

import java.util.Scanner;

/**
 *
 * @author francine
 */
public class SistemaAcademico {

    static Aluno[] cadastrados;
    static Professor[] pcadastrados;

    public static void main(String args[]) {
        Scanner ler = new Scanner(System.in);

        int opcao, contadorCadastrados = 0, contadorPcadastrados = 0;
        String nomeAluno, nomeProfessor, disciplina;
        Disciplinas disciplinas= new Disciplinas();
        boolean encontrou;

        System.out.println("******************** Sistema Acadêmico ********************");

        System.out.print("Deseja cadastrar: ");
        System.out.println("\n1 - Alunos");
        System.out.println("2 - Professores ");
        int op = ler.nextInt();

        if (op == 1) {
            System.out.print("Informe o numero de alunos que será cadastrado: ");
            cadastrados = new Aluno[ler.nextInt()];

            do {
                System.out.println("\n1 - Cadastrar Aluno");
                System.out.println("2 – Excluir aluno por nome");
                System.out.println("3 – Listar Alunos");
                System.out.println("4 – Matricular Aluno em Disciplina");
                System.out.println("5 – Cancelar Matrícula Aluno");
                System.out.println("6 – Imprimir lista Alunos e Disciplinas Matriculadas");
                System.out.println("7 – Sair");
                System.out.print("\nInforme a opção desejada: ");

                opcao = ler.nextInt();

                switch (opcao) {
                    case 1:

                        if (contadorCadastrados < cadastrados.length) {
                            System.out.print("Nome: ");
                            String nome = ler.next();
                            System.out.print("Matricula: ");
                            String matricula = ler.next();
                            System.out.print("Curso: ");
                            String curso = ler.next();
                            System.out.print("Periodo: ");
                            int periodo = ler.nextInt();
                            System.out.print("Idade: ");
                            int idade = ler.nextInt();
                            System.out.print("Endereço: ");
                            String endereco = ler.next();
                            System.out.print("Qtde Disciplinas Permitidas: ");
                            int qtdaDisciplinasPermitidas = ler.nextInt();

                            Aluno a = new Aluno(nome, matricula, curso, periodo, idade, qtdaDisciplinasPermitidas);

                            a.setEndereco(endereco);

                            a.imprime();
                            cadastrarAluno(a);

                            contadorCadastrados++;
                        } else {
                            System.out.println("Número máximo de alunos cadastrados. Se desejar exclua um aluno (Opção 2)");
                        }

                        break;
                    case 2:
                        System.out.print("Qual o nome do aluno que você deseja excluir: ");
                        nomeAluno = ler.next();
                        encontrou = false;
                        for (int i = 0; i < cadastrados.length; i++) {
                            if (nomeAluno.equals(cadastrados[i].getNome())) {
                                excluirAlunoPorNome(nomeAluno);

                                contadorCadastrados--;
                                System.out.println("Exclusão do aluno " + nomeAluno + " executado com sucesso.");
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Aluno " + nomeAluno + " não encontrado.");
                        }
                        break;

                    case 3:
                        listarAlunos();
                        break;
                    case 4:
                        System.out.print("Qual o nome do aluno que você deseja matricular: ");
                        nomeAluno = ler.next();
                        encontrou = false;
                        int i;
                        for (i = 0; i < cadastrados.length; i++) {
                            if (cadastrados[i] == null) {
                                break;
                            } else if (nomeAluno.equals(cadastrados[i].getNome())) {
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Aluno " + nomeAluno + " não encontrado.");
                            break;
                        }
                        
                        System.out.println(disciplinas.toString());
                        System.out.print("Qual a disciplina que você deseja matricular: ");
                        disciplina = ler.next();

                        System.out.println(matricularAlunoEmDisciplina(cadastrados[i], disciplina));
                        break;
                    case 5:
                        System.out.print("Qual o nome do aluno que você deseja cancelar matricula: ");
                        nomeAluno = ler.next();
                        encontrou = false;
                        int j;
                        for (j = 0; j < cadastrados.length; j++) {
                            if (cadastrados[j] == null) {
                                break;
                            } else if (nomeAluno.equals(cadastrados[j].getNome())) {
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Aluno " + nomeAluno + " não encontrado.");
                            break;
                        }

                        System.out.print("Qual a disciplina que você deseja cancelar: ");
                        disciplina = ler.next();
                        System.out.println(cancelarMatricula(cadastrados[j], disciplina));
                        break;
                    case 6:
                        System.out.println(imprimirListaDeAlunoseDisciplinas());
                        break;
                    case 7:
                        System.out.println("Programa encerrado!!");
                        break;
                    default:
                        System.out.println("Opção Inválida!!");
                        break;
                }
            } while (opcao != 7);

        } else if (op == 2) {
            System.out.print("Inforrme o numero de Professores que será cadastrado: ");
            pcadastrados = new Professor[ler.nextInt()];

            do {
                System.out.println("\n1 - Cadastrar Professor");
                System.out.println("2 – Excluir Professor por nome");
                System.out.println("3 – Listar Professores");
                System.out.println("4 – Matricular Professor em Disciplina");
                System.out.println("5 – Cancelar Disciplina Professor");
                System.out.println("6 – Imprimir lista Professores e Disciplinas Lecionadas");
                System.out.println("7 – Sair");
                System.out.print("\nInforme a opção desejada: ");

                opcao = ler.nextInt();

                switch (opcao) {
                         
                    case 1:

                        if (contadorPcadastrados < pcadastrados.length) {
                            System.out.print("Nome: ");
                            String nome = ler.next();
                            System.out.print("Idade: ");
                            int idade = ler.nextInt();
                            System.out.print("Endereço: ");
                            String endereco = ler.next();
                            System.out.print("Qtde Disciplinas Lecionará: ");
                            int qtdaDisciplinasLecionar = ler.nextInt();

                            Professor p = new Professor(nome, idade, qtdaDisciplinasLecionar);

                            p.setEndereco(endereco);

                            p.imprime();
                            cadastrarProfessor(p);

                            contadorPcadastrados++;
                        } else {
                            System.out.println("Número máximo de professores cadastrados. Se desejar exclua um professor (Opção 8)");
                        }
                        break;

                    case 2:
                        System.out.print("Qual o nome do professor que você deseja excluir: ");
                        nomeProfessor = ler.next();
                        encontrou = false;
                        for (int i = 0; i < pcadastrados.length; i++) {
                            if (nomeProfessor.equals(pcadastrados[i].getNome())) {
                                excluirProfessorPorNome(nomeProfessor);

                                contadorPcadastrados--;
                                System.out.println("Exclusão do professor " + nomeProfessor + " executado com sucesso.");
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Professor " + nomeProfessor + " não encontrado.");
                        }
                        break;

                    case 3:
                        listarProfessores();
                        break;

                    case 4:
                        System.out.print("Qual o nome do professor que você deseja matricular: ");
                        nomeProfessor = ler.next();
                        encontrou = false;
                        
                        int i;
                        for (i = 0; i < pcadastrados.length; i++) {
                            if (pcadastrados[i] == null) {
                                break;
                            } else if (nomeProfessor.equals(pcadastrados[i].getNome())) {
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Professor " + nomeProfessor + " não encontrado.");
                            break;
                        }

                        System.out.println(disciplinas.toString());
                        System.out.print("Qual a disciplina que você deseja matricular: ");
                        disciplina = ler.next();

                        System.out.println(matricularProfessorEmDisciplina(pcadastrados[i], disciplina));
                        break;
                    case 5:
                        System.out.print("Qual o nome do professor que você deseja cancelar disciplina: ");
                        nomeProfessor = ler.next();
                        encontrou = false;
                        
                        int j;
                        for (j = 0; j < pcadastrados.length; j++) {
                            if (pcadastrados[j] == null) {
                                break;
                            } else if (nomeProfessor.equals(pcadastrados[j].getNome())) {
                                encontrou = true;
                                break;
                            }
                        }
                        if (!encontrou) {
                            System.out.println("Professor " + nomeProfessor + " não encontrado.");
                            break;
                        }

                        System.out.print("Qual a disciplina que você deseja cancelar: ");
                        disciplina = ler.next();
                        System.out.println(cancelarMatricula(pcadastrados[j], disciplina));
                        break;
                    case 6:
                        System.out.println(imprimirListaDeProfessoreDisciplinas());
                        break;
                    case 7:
                        System.out.println("Programa encerrado!!");
                        break;
                    default:
                        System.out.println("Opção Inválida!!");
                        break;
                }
            } while (opcao != 7);
        }

    }

    public static void cadastrarAluno(Aluno aluno) {
        for (int i = 0; i < cadastrados.length; i++) {
            if (cadastrados[i] == null) {
                cadastrados[i] = aluno;
                break;
            }
        }
    }

    public static void cadastrarProfessor(Professor professor) {
        for (int i = 0; i < pcadastrados.length; i++) {
            if (pcadastrados[i] == null) {
                pcadastrados[i] = professor;
                break;
            }
        }
    }

    public static void excluirAlunoPorNome(String nomeAluno) {
        for (int i = 0; i < cadastrados.length; i++) {
            if (nomeAluno.equals(cadastrados[i].getNome())) {
                for (; i < (cadastrados.length - 1); i++) {
                    cadastrados[i] = cadastrados[i + 1];
                }
                cadastrados[i] = null;
            }
        }
    }

    public static void excluirProfessorPorNome(String nomeProfessor) {
        for (int i = 0; i < pcadastrados.length; i++) {
            if (nomeProfessor.equals(pcadastrados[i].getNome())) {
                for (; i < (pcadastrados.length - 1); i++) {
                    pcadastrados[i] = pcadastrados[i + 1];
                }
                pcadastrados[i] = null;
            }
        }
    }

    public static Aluno[] listarAlunos() {
        for (int i = 0; i < cadastrados.length; i++) {
            if (cadastrados[i] == null) {
                break;
            } else {
                System.out.println(cadastrados[i].imprime());
            }
        }
        return cadastrados;
    }

    public static Professor[] listarProfessores() {
        for (int i = 0; i < pcadastrados.length; i++) {
            if (pcadastrados[i] == null) {
                break;
            } else {
                System.out.println(pcadastrados[i].imprime());
            }
        }
        return pcadastrados;
    }

    public static String matricularAlunoEmDisciplina(Aluno aluno, String disciplina) {
        String resultado = aluno.fazMatricula(disciplina);
        return resultado;
    }

    public static String matricularProfessorEmDisciplina(Professor professor, String disciplina) {
        String resultado = professor.disciplinasLeciona(disciplina);
        return resultado;
    }

    public static String cancelarMatricula(Aluno a, String disciplina) {
        String resultado = a.cancelarMatricula(disciplina);
        return resultado;
    }

    public static String cancelarMatricula(Professor p, String disciplina) {
        String resultado = p.cancelarMatricula(disciplina);
        return resultado;
    }

    public static String imprimirListaDeAlunoseDisciplinas() {
        String aluDisci = "";
        for (int i = 0; i < cadastrados.length; i++) {
            if (cadastrados[i] == null) {
                break;
            } else {
                aluDisci = "Nome: " + cadastrados[i].getNome() + "\nDisciplinas: ";
                String[] disciplinas = cadastrados[i].getDisciplinas();

                for (int j = 0; j < disciplinas.length; j++) {
                    aluDisci = aluDisci + disciplinas[j] + " ";
                }
            }
        }
        return aluDisci;
    }

    public static String imprimirListaDeProfessoreDisciplinas() {
        String pDisci = "";
        for (int i = 0; i < pcadastrados.length; i++) {
            if (pcadastrados[i] == null) {
                break;
            } else {
                pDisci = "Nome: " + pcadastrados[i].getNome() + "\nDisciplinas: ";
                String[] disciplinas = pcadastrados[i].getDisciplinas();

                for (int j = 0; j < disciplinas.length; j++) {
                    pDisci = pDisci + disciplinas[j] + " ";
                }
            }
        }
        return pDisci;
    }

}

