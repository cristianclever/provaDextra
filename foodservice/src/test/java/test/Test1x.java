package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fservice.to.Ingrediente;
import br.com.fservice.to.Lanche;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Test1x {

	@Test
	public void testDecorator() {
		
		
		
		
		Lanche lanche = new Lanche();
		lanche.setDescricao("X-Bacon");
		
		
		Ingrediente bacon1 = new Ingrediente(1,"Bacon",2D);
		Ingrediente alface1 = new Ingrediente(1,"Alface",0.40);
		Ingrediente hamburguer = new Ingrediente(1,"Hambúrguer de carne",3D);
		Ingrediente queijo = new Ingrediente(1,"Queijo",1.50);
		
		//X-Bacon
		lanche.addIngrediente(bacon1);
		lanche.addIngrediente(hamburguer);
		lanche.addIngrediente(queijo);
		
		
		double var = lanche.getValorTotal();
		
		int x = 1;
		
		
	}


}
