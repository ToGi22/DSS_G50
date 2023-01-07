package UI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BussinessLayer.SubCampeonato.GestCampeonatoFacade;
import BussinessLayer.SubCampeonato.ICampeonato;
import BussinessLayer.SubCampeonato.Segmentos;
import BussinessLayer.SubCampeonato.Segmentos.SegmentoEstrada;
import BussinessLayer.SubCarro.GestCarroFacade;
import BussinessLayer.SubCarro.ICarros;
import BussinessLayer.SubPiloto.GestPilotoFacade;
import BussinessLayer.SubPiloto.IPiloto;
import BussinessLayer.SubSimulacao.ISimulacao;
import BussinessLayer.SubSimulacao.SimulacaoFacade;
import BussinessLayer.SubUtilizador.GestUtilizadorFacade;
import BussinessLayer.SubUtilizador.IUtilizador;
import BussinessLayer.SubUtilizador.Utilizador;

/**
 * TextUI
 */
public class TextUI {
	private ICampeonato modelCampeonato;
	private ICarros modelCarro;
	private IPiloto modelPiloto;
	private IUtilizador modeUtilizador;
	private ISimulacao modeSimulacao;

	// Scanner para leitura
	private Scanner scin;

	public TextUI() {
		this.modelCampeonato = new GestCampeonatoFacade();
		this.modelCarro = new GestCarroFacade();
		this.modelPiloto = new GestPilotoFacade();
		this.modeUtilizador = new GestUtilizadorFacade();
		this.modeSimulacao = new SimulacaoFacade();
		this.scin = new Scanner(System.in);
	}

	public void run() {
		boolean logged = false;
		Menu menu = new Menu(new String[]{
			"Registar-se",
			"Autenticar-se",
			"Adicionar Circuito",
			"Adicionar Piloto",
			"Adicionar Campeonato",
			"Adicionar Carro",
		});
		menu.setPreCondition(1,()-> !logged);
        menu.setPreCondition(2,()-> !logged);

		menu.setHandler(1,()->{
            int tom = -1;
            for (int i = 0; tom < 0 || tom > 2; i++) {
                if (i > 0)
                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                System.out.println("Selecione o tipo de utilizador que pretende");
                System.out.println("1-> Jogador");
                System.out.println("2-> Administrador");
                System.out.println("0-> Terminar Operação");
                tom = scin.nextInt();
                if (tom!=0) {
                    System.out.println("Insira o seu nome de utilizador!");
                    String username = scin.nextLine();
                    System.out.println("Insira a sua password!");
                    String password = scin.nextLine();
                    if (tom==1) {
                        Utilizador.registaUtil(username, password);
                    }
                    else {
                        Utilizador.addAdministrador(username,password);
                    }
                }
            }
        });

		menu.setHandler(2,()->{
            int tom = -1;
            for (int i = 0; tom < 0 || tom > 2; i++) {
                if (i > 0)
                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                System.out.println("Selecione o tipo de utilizador que pretende");
                System.out.println("1-> Jogador");
                System.out.println("2-> Administrador");
                System.out.println("0-> Terminar Operação");
                tom = scin.nextInt();
                if (tom!=0) {
                    System.out.println("Insira o seu nome de utilizador!");
                    String username = scin.nextLine();
                    System.out.println("Insira a sua password!");
                    String password = scin.nextLine();
                    if (tom==1) {
                        System.out.println(Utilizador.autenticaUtilizador(username, password));
                    }
                    else {
                        System.out.println(f1m.validaAdministrador(username,password));
                    }
                }
            }
        });

		menu.setHandler(3,()->{
            try {
                System.out.println("Insira a nome do circuito:");
                String nomeCir = scin.nextLine();
                System.out.println("Insira a distância do circuito:");
                double distancia = scin.nextDouble();
                int num_curvas=0;
                int num_chicanes=0;
                int opt=-1;
                List<Segmentos> segmentos = new ArrayList<>();
                for (int i = 0; opt !=0; i++) {
                    if (i > 0 && (opt < 0 || opt > 2))
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    else {
                        System.out.println("Selecione o tipo de manobra a adicionar ao circuito:");
                        System.out.println("1-> Curva");
                        System.out.println("2-> Chicane");
                        System.out.println("0-> Terminar Operação");
                        opt = scin.nextInt();
                        if (opt != 0) {
                            System.out.println("Insira o grau de dificuldade de ultrapassagem (Valor entre 0 e 1):");
                            int gdu = scin.nextInt();
							Segmentos s;
                            if (opt == 1)
								s = new Segmentos(SegmentoEstrada.CURVA, gdu);
                            else
                                s = new Segmentos(SegmentoEstrada.CHICANE, gdu);
                            segmentos.add(s);
                        }
                    }
                }
                System.out.println("Insira o número de voltas do circuito:");
                int numeroVoltas = scin.nextInt();
                modelCampeonato.registaCircuito(nomeCir, distancia,numeroVoltas,segmentos);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        });

		menu.setHandler(4,()->{
            try {
                System.out.println("Insira o nome do Piloto a registar");
                String nome = scin.nextLine();
                double chuvaVsSeco= -1;
                for (int i = 0; chuvaVsSeco < 0 || chuvaVsSeco > 1; i++) {
                    if ((i < 0 || i > 1) && i != 0)
                        System.out.println("O valor indicado não é válido!\n");
                    System.out.println("Insira a sua habilidade Chuva vs Tempo Seco (Valor entre 0 e 1)");
                    chuvaVsSeco = scin.nextDouble();
                }
                double SegVSAgre= -1;
                for (int i = 0; SegVSAgre < 0 || SegVSAgre > 1; i++) {
                    if ((i < 0 || i > 1) && i != 0)
                        System.out.println("O valor indicado não é válido!\n");
                    System.out.println("Insira a sua habilidade Segurança vs Agressividade (Valor entre 0 e 1)");
                    SegVSAgre = scin.nextDouble();
                }
                modelPiloto.registaPiloto(nome,chuvaVsSeco,SegVSAgre);
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });

		menu.setHandler(5,()->{
            try {
                System.out.println("Insira o nome do campeonato a registar");
                String nome = scin.nextLine();
                int opt=-1;
                ArrayList<String> circuitos = new ArrayList<>();
                for (int i = 0; opt !=0; i++) {
                    if (i > 0 && (opt < 0 || opt > 2))
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    System.out.println("1-> Adicionar um novo Circuito ao Campeonato");
                    System.out.println("0-> Terminar Operação");
                    opt = scin.nextInt();
                    if (opt==1) {
                        Collection<Circuito> circ= f1m.getCircuitos();
                        for (Circuito m : circ) {
                            System.out.println(circ.toString());
                        }
                        System.out.println("Insira o nome do Circuito a Adicionar:");
                        String nomeCirc = scann.nextLine();
                        if (circ.stream().map(Circuito::getNome_circuito).toList().contains(nomeCirc))
                            circuitos.add(nomeCirc);
                        else {
                            System.out.println("O circuito não é válido");
                        }
                    }
                }
                f1m.addCampeonato(nome,circuitos);
                f1m.getCampeonato(nome);
            }
            catch (Exception e) {
                System.out.println(e);
            }
        });

		menu.setHandler(6,()->{
            try {
                System.out.println("Insira a marca do carro a registar");
                String marca = scin.nextLine();
                System.out.println("Insira o modelo do Carro a registar");
                String modelo = scin.nextLine();
                int opt=-1;
                for (int i = 0; opt<0 || opt>4; i++) {
                    if (i > 0)
                        System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                    else {
                        System.out.println("Selecione a categoria do carro a adicionar:");
                        System.out.println("1-> Classe 1");
                        System.out.println("2-> Classe 2");
                        System.out.println("3-> Classe Grand Turismo");
                        System.out.println("4-> Stock Cars");
                        System.out.println("0-> Terminar Operação");
                        opt = is.nextInt();
                        int cilindrada = 0;
                        if (opt==2 || opt==3) {
                                while (!f1m.validacilindrada(opt,cilindrada)) {
                                    System.out.println("Insira a cilindrada do carro:");
                                    cilindrada = scin.nextInt();
                                }
                        }
                        System.out.println("Insira a potência do motor de combustão do carro:");
                        int potenciaMC = scin.nextInt();
                        double taxa=0;
                        double fiabilidade=0;
                        if (opt == 3) {
                            System.out.println("Insira a taxa de degradação do carro:");
                            taxa = scin.nextDouble();
                            System.out.println("Insira a fiabilidade do carro:");
                            fiabilidade=scin.nextDouble();
                        }
                        if(opt==4){
                            System.out.println("Insira a fiabilidade do carro:");
                            fiabilidade=scin.nextDouble();
                        }
                        if (opt ==1 || opt==2 || opt==3) {

                            int opt1= -1;
                            for (int j = 0; opt1<1 || opt1>2; j++) {
                                if (j > 0)
                                    System.out.println("A opção escolhida não se encontra nas opções disponíveis!\n");
                                else {
                                    System.out.println("Selecione o tipo de veículo a adicionar:");
                                    System.out.println("1-> Combustão");
                                    System.out.println("2-> Híbrido");
                                    opt1 = scin.nextInt();
                                }
                                if (opt1==2) {
                                    System.out.println("Insira a potência do motor elétrico do carro:");
                                    int potenciaME = scin.nextInt();

                                    if (opt == 3) {
                                        modelCarro.addCarroGTHbr(marca,modelo,cilindrada,potenciaMC,taxa,potenciaME);
                                    }
                                    else if (opt==1) {
                                        modelCarro.addCarroC1Hbr(marca,modelo,potenciaMC,potenciaME);
                                    }
                                    else
                                        modelCarro.addCarroC2Hbr(marca,modelo,cilindrada,potenciaMC,potenciaME);
                                }
                                else {

                                    if (opt == 3) {
                                        modelCarro.addCarroGT(marca,modelo,cilindrada,potenciaMC,taxa);
                                    }
                                    else if (opt==1) {
                                        modelCarro.addCarroC1(marca,modelo,potenciaMC);
                                    }
                                    else if (opt==2) {
                                        modelCarro.addCarroC2(marca, modelo, cilindrada, potenciaMC);
                                    }
                                }
                            }
                        }
                        else if (opt==4){
                            modelCarro.addCarroSC(marca,modelo,cilindrada,potenciaMC,fiabilidade);
                        }



                    }
                }
            }
            catch (Exception e) {
                System.out.println("Dados inválidos");
            }
        });
	}

	
}
