package br.com.fservice.to;

public class Lanche extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9052706487099999812L;
	
	public Ingrediente ingredienteDecorator;
	
	
	public Double getValorTotal(){
		return ingredienteDecorator.getValorTotalItens();
	}
	
	
	public void addIngrediente(Ingrediente in){
		
		
		if(ingredienteDecorator!=null){
			
			in.setIngrediente(ingredienteDecorator);
			ingredienteDecorator = in;
			
		}
		else{
			ingredienteDecorator = in;
		}
		
		
	
		
	}
}
