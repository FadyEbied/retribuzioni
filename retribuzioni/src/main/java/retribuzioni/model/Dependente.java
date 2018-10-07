package retribuzioni.model;

public abstract class Dependente implements Stipendio{
	
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public abstract double calcoloStipendioMensile();

}
