package com.formationkilo.siacdas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.formationkilo.siacdas.dao.ProduitRepository;
import com.formationkilo.siacdas.entities.Produit;
//@Configuration         |
//@ComponentScan         |
//@EnableAutoConfuration |-->are alternatives
import com.formationkilo.siacdas.securite.SecurityConfig;

@SpringBootApplication() //exclude= {SecurityAutoConfiguration.class}
public class SiacdasApplication {
	public static void main(String[] args) {
		ApplicationContext ctx=  SpringApplication.run(SiacdasApplication.class, args);
	//	ProduitRepository produitRepository= ctx.getBean(ProduitRepository.class);
		/*produitRepository.save(new Produit("Adidas", 200,1000));
		produitRepository.save(new Produit("Puma", 250,100));
		produitRepository.save(new Produit("Nike", 299,145));
		produitRepository.save(new Produit("Zara", 204,1900));
		produitRepository.save(new Produit("JCN", 1000,1098));
		produitRepository.save(new Produit("BEBY", 200,1000));*/
//lien template à mettre jour: https://ultraq.github.io/thymeleaf-layout-dialect/
	//produitRepository.findAll().forEach(p->System.out.println(p.getDesignation()));
	}

}
