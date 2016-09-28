package com.ciandt.appdodono.model;

import java.util.ArrayList;
import java.util.List;

public class LivrosResponse {

    private String kind;
    private Long totalItems;
    private List<Livro> items = new ArrayList<Livro>();

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public List<Livro> getLivros() {
        return items;
    }

    public void setLivros(List<Livro> livros) {
        this.items = livros;
    }
}