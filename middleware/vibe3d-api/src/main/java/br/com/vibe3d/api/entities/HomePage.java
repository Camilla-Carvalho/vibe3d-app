package br.com.vibe3d.api.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class HomePage extends PanacheEntity {
    //@Id
    @Column(name = "id")
    public long id;
    @Column(name = "titulo")
    public String titulo;

    public HomePage() { }

    @Override
    public String toString() {
        return "{" + "id=" + id + ", titulo=" + titulo + '}';
    }
}