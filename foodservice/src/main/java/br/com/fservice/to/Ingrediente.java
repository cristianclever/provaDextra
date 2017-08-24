package br.com.fservice.to;

public class Ingrediente extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3326564129599074964L;
	
	
	
	public Ingrediente(){}
	
	
	public Ingrediente(long id, String desc,double preco){
		this.id = id;
		this.descricao=desc;
		this.preco = preco;
	}
	
	private Double preco;
	
	private Ingrediente ingrediente;

	
	public int getQuantidadeItens(Long ingredienteID){
		
		int total = 0;
		
		
		if(this.id == ingredienteID){
			total = 1;
		}
		
		
		return ingrediente.getQuantidadeItens(ingredienteID);
	}
	
	public double getValorTotalItens(){
		
		System.out.println(descricao + ":"+ preco);
		double vlr = preco;
		
		
		
		
		
		if(ingrediente!=null){
			vlr += ingrediente.getValorTotalItens();	
		}

		
		
		return vlr ;	

		
		
		
			
	}	
	

	
	
	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}
	
	
	
	

}
