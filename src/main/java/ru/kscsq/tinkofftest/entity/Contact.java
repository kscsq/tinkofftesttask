package ru.kscsq.tinkofftest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @Column(name = "contact_id")
    private int contactId;

    public Contact() {
    }

    public Contact(int contactId) {
        super();
        this.contactId = contactId;
    }

    public int getContactId() {
        return contactId;
    }

    public void setContact_id(int contactId) {
        this.contactId = contactId;
    }
}
