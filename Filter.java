package Filter;

import java.util.Arrays;
import java.util.List;

import java.util.function.*;

public class Filter {
	
	public static void main(String[] args) {
		Produto p1 = new Produto("Lápis", 1.99, 0.12, 0);
		Produto p2 = new Produto("Notebook", 199, 0.2, 0);
		Produto p3 = new Produto("Caderno", 39, 0.25, 0);
		Produto p4 = new Produto("Impressora", 1699, 0.42, 0);
		Produto p5 = new Produto("iPad", 1999, 0.72, 0);
		Produto p6 = new Produto("Relogio", 1099, 0.92, 0);
		Produto p7 = new Produto("Tv", 1299, 0.2, 0);
		
		List<Produto> produtos = Arrays.asList(p1, p1, p2, p3, p4, p5, p6, p7);
		
		Predicate<Produto> SuperPromocao = p -> p.desconto >= 0.30;
		Predicate<Produto> freteGratis = p -> p.desconto == 0;
		Predicate<Produto> ProdutoRelevante = p -> p.desconto >= 500;
		
		Function<Produto, String> chamdaPromocional =
				p -> "Aproveite! " + p.nome + "por R$" + p.preco;
		
		
		produtos.stream()
			.filter(SuperPromocao)
			.filter(freteGratis)
			.filter(ProdutoRelevante)
			.map(chamdaPromocional)
			.forEach(System.out::println);
	}

}
