package aplicacao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Pessoa;

public class Programa {

	public static void main(String[] args) {
		
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager en = enf.createEntityManager();
		
		Pessoa p = en.find(Pessoa.class, 2);
		en.getTransaction().begin();
		en.remove(p);
		en.getTransaction().commit();
		
		System.out.println(p);
		System.out.println("Pronto!");
		en.close();
		enf.close();
	}

}
