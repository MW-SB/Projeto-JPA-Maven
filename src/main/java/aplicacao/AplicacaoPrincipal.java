package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Individuo;

public class AplicacaoPrincipal {

	public static void main(String[] args) {
		//Os elementos s�o criados
		//O valor do id ser� criado automaticamente
		Individuo i1 = new Individuo(null, "Jo�o Figueredo", "figueredo@gmail.com", "987654321");
		Individuo i2 = new Individuo(null, "Maria Julia", "maria@gmail.com", "876503945");
		Individuo i3 = new Individuo(null, "Joana Dantas", "dantas@gmail.com", "975318624");
		Individuo i4 = new Individuo(null, "Milton Nascar", "nascar@gmail.com", "956748326");
		
		//As classes para conex�o e opera��es com o banco de dados s�o instanciadas
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-maven");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(i1);
		em.persist(i2);
		em.persist(i3);
		em.persist(i4);
		em.getTransaction().commit();
		/**
		 * CASO SEJA NECESS�RIO BUSACRA ALGUM ELEMENTO DA TABELA
		 * Indidviduo in = em.find(Indidviduo.class, 3);
		 * System.out.println(in);
		 * CASO SEJA NECESS�RIO REMOVER ALGUM ELEMENTO DO BANCO DE DADOS, ACRESCENTE, LOGO AP�S A BUSCA, O SEGUINTE C�DIGO:
		 * em.remove(in);
		 * NO CASO DO REMOVE � NECESS�RIO INICIAR UMA TRANSA��O
		 */
		System.out.println("Transa��o conclu�da");
		em.close();
		emf.close();
	}

}
