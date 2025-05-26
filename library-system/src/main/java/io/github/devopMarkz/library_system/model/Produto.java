package io.github.devopMarkz.library_system.model;

import io.github.devopMarkz.library_system.model.enums.Status;
import io.github.devopMarkz.library_system.model.enums.TipoProduto;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_produtos")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false, columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "codigo_barra", nullable = false, unique = true)
    private String codigoBarra;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_produto")
    private TipoProduto tipoProduto;

    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Produto() {
    }

    public Produto(String nome, String descricao, String codigoBarra, TipoProduto tipoProduto, BigDecimal preco, Status status) {
        this.nome = nome;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.tipoProduto = tipoProduto;
        this.preco = preco;
        this.status = status;
    }

    public Produto(Long id, String nome, String descricao, String codigoBarra, TipoProduto tipoProduto, BigDecimal preco, Status status) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.tipoProduto = tipoProduto;
        this.preco = preco;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) && Objects.equals(codigoBarra, produto.codigoBarra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigoBarra);
    }
}
