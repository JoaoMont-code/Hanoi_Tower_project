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
 * # Classe de discos
 * ## Atributos
 * Tamano do disco
 * - Construtor que passa co parametro o tamanho do disco\n
 * - getTamanho() -->
 *      Retorna o tamanho do disco sugerido.
 * 
 */
public class Discos {

    private int tamanho;

    /**
     * Construtor onde pode-se passar o tamanho personalizado do disco
     */
    public Discos(int tamanho) {
        this.tamanho = tamanho;
    }

    /**
     * Retorna o tamanho do disco instânciado
     */
    public int getTamanho() {
        return tamanho;
    }
}