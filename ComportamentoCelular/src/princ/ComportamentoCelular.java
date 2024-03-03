package princ;

import java.util.Scanner;

public class ComportamentoCelular {
    public static void main(String[] args) {
        boolean programaAtivo = true;
        Celular celularEscolhido = null;
        Estados estado = Estados.MENU_PRINCIPAL;
        Estados[] estados = { Estados.DEFINIR_MODELO, Estados.USAR_RECURSOS, Estados.SAIR };
        Scanner scanner = new Scanner(System.in);
        int opcao;
        while (programaAtivo) {
            ComportamentoCelular.clearConsole();
            switch (estado) {
                case MENU_PRINCIPAL:
                    ComportamentoCelular.header();
                    System.out.println("O que você deseja fazer?");
                    System.out.println("1 - Definir Modelo");
                    if (celularEscolhido != null)
                        System.out.println("2 - Usar modelo selecionado");
                    else
                        System.out.println("2 - BLOQUEADO, DEFINA UM MODELO ANTES");
                    System.out.println("3 - Sair");
                    System.out.print("Sua opção: ");
                    opcao = Integer.parseInt(scanner.nextLine());
                    estado = estados[opcao - 1];
                    break;
                case DEFINIR_MODELO:
                    ComportamentoCelular.header();
                    System.out.println("Qual modelo deseja usar?");
                    System.out.println("1 - Modelo Básico");
                    System.out.println("2 - Modelo Avançado");
                    System.out.print("Sua opção: ");
                    opcao = Integer.parseInt(scanner.nextLine());
                    if (opcao == 1) {
                        celularEscolhido = (Celular) new ModeloBasico();
                        estado = Estados.MENU_PRINCIPAL;
                    }
                    if (opcao == 2) {
                        celularEscolhido = (Celular) new ModeloAvancado();
                        estado = Estados.MENU_PRINCIPAL;
                    }
                    break;
                case SAIR:
                    programaAtivo = false;
                    break;
                case USAR_RECURSOS:
                    if (celularEscolhido == null) {
                        System.out.println("Defina um modelo antes!!");
                        estado = Estados.MENU_PRINCIPAL;
                        continue;
                    }
                    AcoesCelular escolha = AcoesCelular.MENU_PRINCIPAL;
                    String numero;

                    if (celularEscolhido.getClass() == ModeloBasico.class) {
                        ModeloBasico celularBasico = (ModeloBasico) celularEscolhido;
                        escolha = AcoesCelular.MENU_PRINCIPAL;
                        AcoesCelular[] acoes = {
                                AcoesCelular.FAZER_LIGACAO,
                                AcoesCelular.MANDAR_MENSAGEM,
                                AcoesCelular.LIGAR,
                                AcoesCelular.DESLIGAR,
                                AcoesCelular.IR_PARA_MENU_PRINCIPAL,
                        };
                        while (escolha != AcoesCelular.IR_PARA_MENU_PRINCIPAL) {
                            ComportamentoCelular.clearConsole();
                            ComportamentoCelular.header();
                            switch (escolha) {
                                case MENU_PRINCIPAL:
                                    System.out.println("Qual função você deseja executar?");
                                    System.out.println("1 - Fazer uma ligação");
                                    System.out.println("2 - Enviar uma mensagem");
                                    System.out.println("3 - Ligar Celular");
                                    System.out.println("4 - Desligar Celular");
                                    System.out.println("5 - Sair");
                                    System.out.print("Sua opção: ");
                                    int index = Integer.parseInt(scanner.nextLine());
                                    escolha = acoes[index - 1];
                                    break;
                                case FAZER_LIGACAO:
                                    System.out.print("Para qual telefone deseja discar? ");
                                    numero = scanner.nextLine();
                                    celularBasico.fazerLigacao(numero);
                                    ComportamentoCelular.waitUser(scanner);
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case MANDAR_MENSAGEM:
                                    System.out.printf("Para qual telefone deseja mandar mensagem? ");
                                    numero = scanner.nextLine();
                                    System.out.printf("Escreva a mensagem(Vai ser enviada assim que apertar ENTER): ");
                                    String mensagem = scanner.nextLine();
                                    celularBasico.enviarMensagem(numero, mensagem);
                                    ComportamentoCelular.waitUser(scanner);
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case LIGAR:
                                    celularBasico.ligar();
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case DESLIGAR:
                                    celularBasico.desligar();
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case IR_PARA_MENU_PRINCIPAL:
                                    escolha = AcoesCelular.IR_PARA_MENU_PRINCIPAL;
                                    break;
                            }
                        }
                    }
                    if (celularEscolhido.getClass() == ModeloAvancado.class) {
                        ModeloAvancado celularAvancado = (ModeloAvancado) celularEscolhido;
                        escolha = AcoesCelular.MENU_PRINCIPAL;
                        AcoesCelular[] acoes = {
                                AcoesCelular.FAZER_LIGACAO,
                                AcoesCelular.MANDAR_MENSAGEM,
                                AcoesCelular.VER_HISTORICO_CHAMADAS,
                                AcoesCelular.VER_HISTORICO_MENSAGENS,
                                AcoesCelular.LIGAR,
                                AcoesCelular.DESLIGAR,
                                AcoesCelular.IR_PARA_MENU_PRINCIPAL,
                        };
                        while (escolha != AcoesCelular.IR_PARA_MENU_PRINCIPAL) {
                            ComportamentoCelular.clearConsole();
                            ComportamentoCelular.header();
                            switch (escolha) {
                                case MENU_PRINCIPAL:
                                    System.out.println("Qual função você deseja executar?");
                                    System.out.println("1 - Fazer uma ligação");
                                    System.out.println("2 - Enviar uma mensagem");
                                    System.out.println("3 - Ver histórico de ligações");
                                    System.out.println("4 - Ver histórico de mensagens");
                                    System.out.println("5 - Ligar Celular");
                                    System.out.println("6 - Desligar Celular");
                                    System.out.println("7 - Sair");
                                    System.out.print("Sua opção: ");
                                    int index = Integer.parseInt(scanner.nextLine());
                                    escolha = acoes[index - 1];
                                    break;
                                case FAZER_LIGACAO:
                                    System.out.print("Para qual telefone deseja discar? ");
                                    numero = scanner.nextLine();
                                    celularAvancado.fazerLigacao(numero);
                                    ComportamentoCelular.waitUser(scanner);
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case MANDAR_MENSAGEM:
                                    System.out.printf("Para qual telefone deseja mandar mensagem? ");
                                    numero = scanner.nextLine();
                                    System.out.printf("Escreva a mensagem(Vai ser enviada assim que apertar ENTER): ");
                                    String mensagem = scanner.nextLine();
                                    celularAvancado.enviarMensagem(numero, mensagem);
                                    ComportamentoCelular.waitUser(scanner);
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case VER_HISTORICO_CHAMADAS:
                                    System.out.println(celularAvancado.obterHistoricoLigacoes());
                                    ComportamentoCelular.waitUser(scanner);
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case VER_HISTORICO_MENSAGENS:
                                    System.out.println(celularAvancado.obterHistoricoMensagens());
                                    ComportamentoCelular.waitUser(scanner);
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case LIGAR:
                                    celularAvancado.ligar();
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case DESLIGAR:
                                    celularAvancado.desligar();
                                    escolha = AcoesCelular.MENU_PRINCIPAL;
                                    break;
                                case IR_PARA_MENU_PRINCIPAL:
                                    escolha = AcoesCelular.IR_PARA_MENU_PRINCIPAL;
                                    break;
                            }
                        }

                    }
                    estado = Estados.MENU_PRINCIPAL;
                    break;
            }
        }
        scanner.close();
    }

    public static void header() {
        System.out.println("---------------------------------------------------");
        System.out.println("-------------------Teste-de-Celulares--------------");
        System.out.println("---------------------------------------------------");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void waitUser(Scanner scanner) {
        System.out.println("--------PRESSIONE ENTER PARA IR AO MENU PRINCIPAL--------");
        scanner.nextLine();
    }

}