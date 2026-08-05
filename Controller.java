/**
 * # Integrante 1 
 *      - Leonardo Aquino Cruz
 *      - Ra: 10445016
 * 
 * # Integrante 2
 *      - João pedro Pereira monteiro 
 *      - RA: 10727509
 * 
 * # integrante 3
 *      - Lucas Chohfi Nigro
 *      - RA: 10437138
 *      
 */

import java.util.Scanner;

public class Controller{

    static Torres t1, t2, t3;
    static Scanner read, choicNumberTower;
    static int quantidadeDeDiscos;
    static int contMoves = 0;

    public static void main(String[] args) throws Exception {

        choicNumberTower = new Scanner(System.in);
        IO.print("Quantidade de Discos: ");
        quantidadeDeDiscos = choicNumberTower.nextInt();

        t1 = new Torres(quantidadeDeDiscos, true, 1);
        t2 = new Torres(quantidadeDeDiscos, false, 2);
        t3 = new Torres(quantidadeDeDiscos, false, 3);
        
        read = new Scanner(System.in);
        IO.println("[1] - Iniciar jogo");
        IO.println("[2] - Sair do jogo");
        IO.print("--> ");
        int resp = read.nextInt();

        Scanner GameAgain = new Scanner(System.in);
        if(resp == 1){
            hanoiLooping();
            while(true){

                IO.print("Deseja Jogar novamente? [S/N]");
                String newInput = GameAgain.nextLine();

                if(newInput.equalsIgnoreCase("S")){
                    contMoves = 0;
                    IO.print("Quantidade de Discos: ");
                    int numberDiscBackup = choicNumberTower.nextInt();

                    t1 = new Torres(numberDiscBackup, true,1);
                    t2 = new Torres(numberDiscBackup, false, 2);
                    t3 = new Torres(numberDiscBackup, false, 3);
                    hanoiLooping();
                }
                else{
                    IO.print("JOGO ENCERRADO!!!");
                    break;
                }

            }
        }
        else if(resp == 2) {
            return;
        }
        else{
            throw new Exception("Valor inválido");
        }
    }

    /**
     *  - Controle de looping do jogo
     *  - Exibição de Menu 
     *  - Utiliza um Switch case para chamar funcionalidades do menu.
     */
    public static void hanoiLooping() throws Exception{
        while(true){

            if(t2.estaOrdenado() || t3.estaOrdenado()){
                IO.print(t1.toString());
                IO.print(t2.toString());
                IO.print(t3.toString());
                IO.print("=-=-=-=-=- A torre está ordenada -=-=-=-=-=\n");
                IO.print("Quantidade de movimentos: "+ contMoves + "\n");
                break;
            }

            IO.println("[1] - Mover disco");
            IO.println("[2] - Mostrar Torres");
            IO.println("[3] - Reiniciar jogo");
            IO.println("[4] - Sair");
            IO.print("--> ");

            Scanner readGame = new Scanner(System.in);
            int inputUser = readGame.nextInt();

            switch (inputUser) {
                case 1:
                    choiceTower();
                    break;
                case 2:
                    IO.print(t1.toString());
                    IO.print(t2.toString());
                    IO.print(t3.toString());
                    break;
                case 3: 
                    t1 = new Torres(quantidadeDeDiscos, true, 1);
                    t2 = new Torres(quantidadeDeDiscos, false, 2);
                    t3 = new Torres(quantidadeDeDiscos, false, 3);
                    break;
                case 4:
                    return;
                default:
                    throw new AssertionError();
            }
        
        }
    }


    /**
     * - Solicita a torre de origem e destino para distribuir o disco.
     * - Validação de escolha de torre através do while.
     * - Chama a função de mudanças de discos com parametro (origem, destino)
     */
    public static void choiceTower() throws Exception{

        Scanner read = new Scanner(System.in);
        IO.print(t1.toString());
        IO.print(t2.toString());
        IO.print(t3.toString());

        IO.print("Escolha a torre de origem: ");
        int origem = read.nextInt();

        IO.print("Escolha a torre de destino: ");
        int destino = read.nextInt();

        while(origem < 1 || origem > 3 || destino < 1 || destino > 3 || destino == origem) {
            IO.println("Movimentação inválida! Tente novamente.");
    
            IO.print("Escolha a torre de origem: ");
            origem = read.nextInt();

            IO.print("Escolha a torre de destino: ");
            destino = read.nextInt();
        }

        MudarDisco(origem, destino);

    }


    /**
     * 
     * @param ID_origem --> parametro de escolhas de torre (origem)
     * @param ID_destino --> parametro de escolhas de torre (destino)
     * 
     * Nesse método é onde usamos os métodos de estrtura de dados push() e pop() 
     * para tirar de uma torre e adicionar a outra Torre.
     */
    public static void MudarDisco(int ID_origem, int ID_destino) throws Exception {
        switch (ID_origem) {
            case 1: 
                if (ID_destino == 2) {
                    t2.pushDisc(t1.pop()); 
                    contMoves++;
                } else if (ID_destino == 3) {
                    t3.pushDisc(t1.pop());
                    contMoves++; 
                }
                break; 

            case 2:
                if (ID_destino == 1) {
                    t1.pushDisc(t2.pop()); 
                    contMoves++;
                } else if (ID_destino == 3) {
                    t3.pushDisc(t2.pop());
                    contMoves++;
                }
                break; 

            case 3:
                if (ID_destino == 1) {
                    t1.pushDisc(t3.pop()); 
                    contMoves++;
                } else if (ID_destino == 2) {
                    t2.pushDisc(t3.pop());
                    contMoves++;
                }
                break;

            default:
                System.out.println("Torre de origem inválida!");
                break;
        }
    }


     
}




