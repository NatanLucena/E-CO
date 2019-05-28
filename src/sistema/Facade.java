package sistema;

import controladores.ControladorDePessoasEDeputados;

public class Facade {
	ControladorDePessoasEDeputados cpd = new ControladorDePessoasEDeputados();
	
	// Metodos da US1
	/**
	 * Cadastra uma pessoa sem um partido.
	 * @author lucas-lucena
	 * 
	 * @param nome
	 * @param dni
	 * @param estado
	 * @param interesses
	 */
	
    public void cadastrarPessoa(String nome, String dni, String estado, String interesses) {
//    	cpd.cadastraPessoa(nome, dni, estado, interesses);
    }
    
    /**
     * Cadastra uma pessoa com partido.
     * @author lucas-lucena
     * 
     * @param nome
     * @param dni
     * @param estado
     * @param interesses
     * @param partido
     */
    void cadastrarPessoa(String nome, String dni, String estado, String interesses, String partido) {
//    	cpd.cadastraPessoa(nome, dni, estado, interesses, partido);
    }
    
    
	// Metodos da US2
    
    /**
     * Cadastra deputado.
     * @author lucas-lucena
     * 
     * @param DNI
     * @param dataDeInicio
     */
    public void cadastrarDeputado(String DNI, String dataDeInicio) {
 //   	cpd.cadastraDeputado(DNI, dataDeInicio);
    }
	
	// Metodos da US3
    
    /**
     * Exibe a representacao em String de uma pessoa.
     * @author lucas-lucena
     * 
     * @param DNI
     * @return
     */
    public String exibirPessoa(String DNI) {
    	return ""; //cpd.exibePessoa(DNI);
    }
    
    // Metodos da US4
    
    /**
     * Cria um controlador fictício, para manipular os partidos.
     * @author lucas-lucena
     */
 //   FakeController fc = new FakeController(); // A ser decidido como sera feito, uso de controlers, nomes, etc.
    
    /**
     * Cadastra um partido.
     * @author lucas-lucena
     * 
     * @param partido
     */
    public void cadastrarPartido(String partido) {
 //   	fc.cadastrarPartido(partido);
    }
    
    /**
     * Exibe todos os partidos da base.
     * @author lucas-lucena
     * 
     * @return
     */
    public String exibirBase() {
    	return "";//fc.exibirBase();
    }
}