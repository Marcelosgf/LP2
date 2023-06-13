package aplicacao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

import dao.JogosDAO;
import dao.clientesDAO;
import dao.vendasDAO;
import db.DB;
import implementacaoDao.ClienteDaoJDBC;
import implementacaoDao.DaoFactory;
import Entidades.Clientes;
import Entidades.Jogos;
import Entidades.Vendas;

public class programa {

	public static void main(String[] args) {
			
			clientesDAO clientesdao = DaoFactory.createClientesDao();
			JogosDAO jogosdao = DaoFactory.createJogosDao();
			vendasDAO vendasdao = DaoFactory.createVendasDao();
			Scanner scanner = new Scanner(System.in);
	        int opcao;
		
		do {
            System.out.println("===== MENU CLIENTE =====");
            System.out.println("1. Inserir Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. DELETAR Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Consulta Clientes");
            System.out.println("===== MENU JOGO =====");
            System.out.println("6. Inserir Jogo");
            System.out.println("7. Atualizar Jogo");
            System.out.println("8. DELETAR Jogo");
            System.out.println("9. Listar Jogos");
            System.out.println("10. Consultar Jogos");
            System.out.println("===== COMPRA =====");
            System.out.println("11. Comprar Jogo");
            System.out.println("===== SAIR =====");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            
			switch (opcao) {
                case 1:
                    Scanner sc2 = new Scanner(System.in);
        			System.out.println("Digite o nome do cliente que deseja adicionar: ");
        			String nome = sc2.nextLine();
        			System.out.println("Digite o telefone do cliente que deseja adicionar: ");
        			String telefone = sc2.nextLine();
        			System.out.println("Digite o email do cliente que deseja adicionar: ");
        			String email = sc2.nextLine();       			
        			Clientes newCliente = new Clientes(null, nome, telefone, email);      					
        			clientesdao.insert(newCliente);
        			System.out.println("Inserção efetuada, o ID do cliente inserido é: " + newCliente.getId_cliente());
                    break;
                case 2:
                	Clientes clientes = new Clientes();
                	Scanner sc4 = new Scanner(System.in);
                	System.out.println("Digite o ID do cliente que você quer alterar: ");
                	int id_update = sc4.nextInt();
                	clientes = clientesdao.findById(id_update);

                	boolean op;
                	boolean y = true;
                	boolean n = false;

                	System.out.println("Deseja alterar o nome? (y/n)");
                	op = sc4.next().equalsIgnoreCase("y");
                	sc4.nextLine(); 

                	if (op) {
                	    System.out.println("Digite o novo nome do cliente: ");
                	    String nome_u = sc4.nextLine();
                	    clientes.setNome(nome_u);
                	    clientesdao.update(clientes);
                	} else {
                	    System.out.println("Vamos para o próximo dado");
                	}

                	System.out.println("Deseja alterar o telefone? (y/n)");
                	op = sc4.next().equalsIgnoreCase("y");
                	sc4.nextLine(); 

                	if (op) {
                	    System.out.println("Digite o novo telefone: ");
                	    String telefone_u = sc4.nextLine();
                	    clientes.setTelefone(telefone_u);
                	    clientesdao.update(clientes);
                	} else {
                	    System.out.println("Vamos para o próximo dado");
                	}

                	System.out.println("Deseja alterar o email? (y/n)");
                	op = sc4.next().equalsIgnoreCase("y");
                	sc4.nextLine(); 

                	if (op) {
                	    System.out.println("Digite o novo email: ");
                	    String email_u = sc4.nextLine();
                	    clientes.setEmail(email_u);
                	    clientesdao.update(clientes);
                	} else {
                	    System.out.println("Vamos para o próximo dado");
                	}

                    break;
                case 3:
        			Scanner sc = new Scanner(System.in);
        			System.out.println("Digite o ID do cliente que deseja excluir");
            			int id = sc.nextInt();
            			clientesdao.deleteById(id);
            			System.out.println("Exclusão executada");          			
                    break;
                case 4:
            		List<Clientes> cliente1 = clientesdao.findAll();
            		System.out.println(cliente1);
                    break;
                case 5:
                	Scanner sc3 = new Scanner(System.in);
        			System.out.println("Digite o ID do cliente que deseja consultar os dados");
        			int id2 = sc3.nextInt();
                	Clientes cliente = clientesdao.findById(id2);
            		System.out.println(cliente); 
                    break;
                case 6:
                	Scanner sc5 = new Scanner(System.in);
        			System.out.println("Digite o nome do jogo que deseja adicionar: ");
        			String nome_jogo = sc5.nextLine();
        			System.out.println("Digite a plataforma(PS4/PC/XBOX ONE) que o jogo será jogado(Exclusivo 1): ");
        			String plataforma = sc5.nextLine();
        			System.out.println("Digite o genero do jogo adicionado(Exclusivo 1): ");
        			String genero = sc5.nextLine();
        			System.out.println("Digite o preco do novo jogo adicionado: ");
        			int preco = sc5.nextInt(); 
        			Jogos newJogo = new Jogos(null, nome_jogo, plataforma, genero, preco);    					
        			jogosdao.insert(newJogo);
        			System.out.println("Inserção efetuada, o ID do j inserido é: " + newJogo.getId_jogos());
                    break;
                case 7:
                	Jogos jogos = new Jogos();
                	Scanner sc6 = new Scanner(System.in);
                	System.out.println("Digite o ID do jogo que você quer alterar: ");
                	int id_update_jogos = sc6.nextInt();
                	jogos = jogosdao.findById(id_update_jogos);

                	System.out.println("Deseja alterar o nome do jogo? (y/n)");
                	op = sc6.next().equalsIgnoreCase("y");
                	sc6.nextLine(); 

                	if (op) {
                	    System.out.println("Digite nome do novo jogo: ");
                	    String nome_u = sc6.nextLine();
                	    jogos.setNome(nome_u);
                	    jogosdao.update(jogos);
                	} else {
                	    System.out.println("Vamos para o próximo dado");
                	}

                	System.out.println("Deseja alterar a plataforma em que jogo é jogado? (y/n)");
                	op = sc6.next().equalsIgnoreCase("y");
                	sc6.nextLine(); 

                	if (op) {
                	    System.out.println("Digite a nova plataforma(Máximo 1): ");
                	    String plataforma_u = sc6.nextLine();
                	    jogos.setPlataforma(plataforma_u);
                	    jogosdao.update(jogos);
                	} else {
                	    System.out.println("Vamos para o próximo dado");
                	}

                	System.out.println("Deseja alterar o genero? (Máximo 1) (y/n)");
                	op = sc6.next().equalsIgnoreCase("y");
                	sc6.nextLine(); 

                	if (op) {
                	    System.out.println("Digite o novo genero: ");
                	    String genero_u = sc6.nextLine();
                	    jogos.setGenero(genero_u);
                	    jogosdao.update(jogos);
                	} else {
                	    System.out.println("Vamos para o próximo dado");
                	}
                	
                	System.out.println("Deseja alterar o preco? (y/n)");
                	op = sc6.next().equalsIgnoreCase("y");
                	if (op) {
                	    System.out.println("Digite o novo preco: ");
                	    int preco_u = sc6.nextInt();
                	    jogos.setPreco(preco_u);
                	    jogosdao.update(jogos);
                	} else {
                	    System.out.println("Fim das atualizações");
                	}

                    break;
                case 8:
                	Scanner sc8 = new Scanner(System.in);
        			System.out.println("Digite o ID do jogo que deseja excluir");
            			int id_jogo_e = sc8.nextInt();
            			jogosdao.deleteById(id_jogo_e);
            			System.out.println("Exclusão executada"); 
                    break;
                case 9:
                	List<Jogos> jogos_list = jogosdao.findAll();
            		System.out.println(jogos_list);
                    break;
                case 10:
                	Scanner sc9 = new Scanner(System.in);
        			System.out.println("Digite o ID do jogo que deseja consultar os dados");
        			int id3 = sc9.nextInt();
                	Jogos jogo = jogosdao.findById(id3);
            		System.out.println(jogo); 
                    break;
                case 11:
                	
                	Scanner sc10 = new Scanner(System.in);
        			System.out.println("Digite o ID do cliente que deseja comprar um jogo! ");
        			int id_comprar = sc10.nextInt();
        			System.out.println("Digite o ID do jogo a ser comprado. ");
        			int id_jogo_comprado = sc10.nextInt();
        			Vendas venda = new Vendas(null, id_comprar, id_jogo_comprado);
        			vendasdao.insert(venda);
        			System.out.println("Compra efetuada! Aproveite! ");
                	break;
                case 0:
                    System.out.println("Saindo do menu...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        } while (opcao != 0);

        System.out.println("Programa encerrado.");
        scanner.close();
			

	}
}