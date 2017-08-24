package test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.fservice.to.Ingrediente;
import br.com.fservice.to.Lanche;
import static org.junit.Assert.*;

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
		
		
		double expected = bacon1.getPreco() + alface1.getPreco() + hamburguer.getPreco() + queijo.getPreco();
		
		
		
		//X-Bacon
		lanche.addIngrediente(bacon1);
		lanche.addIngrediente(hamburguer);
		lanche.addIngrediente(queijo);
		lanche.addIngrediente(alface1);
		
		double val = lanche.getValorTotal();
		
		assertEquals(Double.valueOf(expected) , Double.valueOf(val));
	
		
	}


}
