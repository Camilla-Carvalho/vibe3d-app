package br.com.vibe3d.api.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Acabamento extends PanacheEntity {
    public String nome;
    public String descricao;
    public String categoria;
    public double preco;

    public static List<Acabamento> findByListId(List<Long> ids) {
        return find("from Acabamento where id IN ?1", ids).list();
    }
}