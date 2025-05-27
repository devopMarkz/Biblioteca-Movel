package io.github.devopMarkz.library_system.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_kit_itens")
public class KitItem {

    @EmbeddedId
    private KitItemId id = new KitItemId();

    @ManyToOne
    @MapsId("kitId")
    private Kit kit;

    @ManyToOne
    @MapsId("produtoId")
    private Produto produto;

    @Column(nullable = false)
    private BigDecimal quantidade;

    public KitItem() {
    }

    public KitItem(Kit kit, Produto produto, BigDecimal quantidade) {
        this.kit = kit;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public KitItemId getId() {
        return id;
    }

    public void setId(KitItemId id) {
        this.id = id;
    }

    public Kit getKit() {
        return kit;
    }

    public void setKit(Kit kit) {
        this.kit = kit;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        KitItem kitItem = (KitItem) o;
        return Objects.equals(id, kitItem.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}