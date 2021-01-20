package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Individuo;

public class AplicacaoPrincipal {

	public static void main(String[] args) {
		//Os elementos são criados
		//O valor do id será criado automaticamente
		Individuo i1 = new Individuo(null, "João Figueredo", "figueredo@gmail.com", "987654321");
		Individuo i2 = new Individuo(null, "Maria Julia", "maria@gmail.com", "876503945");
		Individuo i3 = new Individuo(null, "Joana Dantas", "dantas@gmail.com", "975318624");
		Individuo i4 = new Individuo(null, "Milton Nascar", "nascar@gmail.com", "956748326");
		
		//As classes para conexão e operações com o banco de dados são instanciadas
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-maven");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(i1);
		em.persist(i2);
		em.persist(i3);
		em.persist(i4);
		em.getTransaction().commit();
		/**
		 * CASO SEJA NECESSÁRIO BUSACRA ALGUM ELEMENTO DA TABELA
		 * Indidviduo in = em.find(Indidviduo.class, 3);
		 * System.out.println(in);
		 * CASO SEJA NECESSÁRIO REMOVER ALGUM ELEMENTO DO BANCO DE DADOS, ACRESCENTE, LOGO APÓS A BUSCA, O SEGUINTE CÓDIGO:
		 * em.remove(in);
		 * NO CASO DO REMOVE É NECESSÁRIO INICIAR UMA TRANSAÇÃO
		 */
		System.out.println("Transação concluída");
		em.close();
		emf.close();
	}

}
