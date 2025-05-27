package io.github.devopMarkz.library_system.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KitItemId implements Serializable {

    private Long kitId;
    private Long produtoId;

    public KitItemId() {
    }

    public KitItemId(Long kitId, Long produtoId) {
        this.kitId = kitId;
        this.produtoId = produtoId;
    }

    public Long getKitId() {
        return kitId;
    }

    public void setKitId(Long kitId) {
        this.kitId = kitId;
    }

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KitItemId kitItemId = (KitItemId) o;
        return Objects.equals(kitId, kitItemId.kitId) && Objects.equals(produtoId, kitItemId.produtoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kitId, produtoId);
    }
}