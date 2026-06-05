package br.com.ifba.curso.prg03edinaizemr;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import br.com.ifba.curso.view.CursoListar;

@SpringBootApplication
@ComponentScan(basePackages = {"br.com.ifba.curso.prg03edinaizemr", "br.com.ifba.curso"})
@EntityScan(basePackages = {"br.com.ifba.curso.entity"})
@EnableJpaRepositories(basePackages = {"br.com.ifba.curso.repository"})
public class CursoApplication {

    public static void main(String[] args) {
        
        ApplicationContext context = new SpringApplicationBuilder(CursoApplication.class)
                .headless(false)
                .run(args);
 
        java.awt.EventQueue.invokeLater(() -> {
            CursoListar tela = context.getBean(CursoListar.class);
            tela.setVisible(true);
        });
    }
}