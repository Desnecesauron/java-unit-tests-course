package br.com.desnecesauron.javaunittestscourse.mockito.service;

import java.time.LocalDateTime;
import java.util.Objects;

public class Order {

    private String id;
    private String productName;
    private Long amount;
    private LocalDateTime creationDate;

    public Order() {
    }

    public Order(String id, String productName, Long amount, LocalDateTime creationDate) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public Long getAmount() {
        return amount;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "Order{" + "id='" + id + '\'' + ", productName='" + productName + '\'' + ", amount=" + amount + ", " + "creationDate=" + creationDate + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(productName, order.productName) && Objects.equals(amount,
                order.amount) && Objects.equals(creationDate, order.creationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, amount, creationDate);
    }
}
