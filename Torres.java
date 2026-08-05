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

/**
 * ## Classe Torre
 * O objetivo da classe torre é a organização de como serão feitas o empilhamento
 * e o despilhamento da torre.
 * 
 * ### Métodos
 * - @param Torre(construtor) --> Constrtutor da classe
 * - @param TorreVazia() --> Método booleana que Valida se a Torre tem elementos ou não.
 * - @param TorreCheia() --> Método booleana que Valida se a Torre está cheia ou não.
 * - @param push_init() --> Método para empilhar a Torre default, torre mais a esquerda
 * - @param pushDisc() --> Método padrão de empilhamento.
 * - @param pop() --> Método de despilhamento padrão. 
 * - @param toString() --> Método para printar a Torre
 * - @param estaOrdenado() --> Método para verificar se a torre está ordenada
 */
public class Torres{

    private int topo;
    private Discos[] Torre;
    private int capacidade;
    private int sizeDiscos;
    private boolean principal;
    private int ID;
   


    /**
     * 
     */
    public Torres(int capacidade, boolean principal, int ID) throws Exception {
        this.topo = -1;
        this.capacidade = capacidade;
        this.Torre = new Discos[capacidade];
        this.principal = principal; 
        this.ID = ID;

        if (this.principal) { 
            for (int i = capacidade; i >= 1; i--) {
                this.push_init(new Discos(i));
            }
        }
    }

    public boolean TorreVazia() {
        return this.topo == -1;
    }   

    public boolean TorreCheia(){
        return this.topo == capacidade;
    }

   

    private void push_init(Discos disco) throws Exception{
        if(!TorreCheia()){
            if(topo > 0 && disco.getTamanho() > this.Torre[topo].getTamanho()){
                throw new Exception("O disco é maior que a origem");
            }
            this.Torre[++topo] = disco;
            this.sizeDiscos++;
        }
    }

    public void pushDisc(Discos disco){
        if(TorreVazia()){
            this.Torre[++topo] = disco;
            this.sizeDiscos++;
            
        }
        else if(disco.getTamanho() > Torre[topo].getTamanho()){
            IO.print("O topo da torre de destino é Menor que o disco \n");
            
        }
        else{
            this.Torre[++topo] = disco;
            this.sizeDiscos++;
          
        }
    }

    public Discos pop()throws Exception{
        if(!TorreVazia()){
            sizeDiscos--;
            return Torre[topo--];
        }
        else{
            throw new Exception("A Torre está vazia");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------\n");
        if (TorreVazia()) {
            sb.append("(vazia)\n");
        } else {
            
            for (int i = topo; i >= 0; i--) {
                sb.append("");
                int valorDoDisco = Torre[i].getTamanho();
                sb.append(" ".repeat(capacidade - valorDoDisco)); 
                sb.append("#".repeat(valorDoDisco * 2)); 
                sb.append("\n");
            }
            
        }
        sb.append("\n");
        return sb.toString();
    }

    public boolean estaOrdenado(){
        if(topo == capacidade - 1){return true;}
        else{return false;}
    }


    
   






    


}