package br.com.vibe3d.api.repositories;

import br.com.vibe3d.api.entities.HomePage;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HomePageRepository implements PanacheRepository<HomePage> {
    public HomePage findLastHomePage() {
        return this.find("select hp.id, hp.titulo from homepage hp order by hp.id desc").firstResult();
    }
}