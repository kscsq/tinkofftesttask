package ru.kscsq.tinkofftest.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @Column(name = "application_id")
    private int id;

    @Column(name = "dt_created")
    private LocalDate dateCreated;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "contact_id")
    private int contactId;

    public Application() {
    }

    public Application(int id, LocalDate dateCreated, String productName, int contactId) {
        super();
        this.id = id;
        this.dateCreated = dateCreated;
        this.productName = productName;
        this.contactId = contactId;
    }

    public Application(LocalDate dateCreated, String productName, int contactId) {
        super();
        this.dateCreated = dateCreated;
        this.productName = productName;
        this.contactId = contactId;
    }

    public int getId() {
        return id;
    }

    public void setApplicationId(int id) {
        this.id = id;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contact_id) {
        this.contactId = contactId;
    }
}
