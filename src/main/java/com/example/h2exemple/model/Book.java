package com.example.h2exemple.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name= "book")
public class Book {

    /*
     * ATTRIBUTS
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "titre", unique = true, nullable = false)
    private String titre;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "datePublication", nullable = false)
    private Date datePublication;

    /*
     * CONSTRUCTORS
     */

    public Book() {}

    public Book(String titre, String description, Date datePublication) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
    }

    /*
     * GETTERS AND SETTERS
     */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(Date datePublication) {
        this.datePublication = datePublication;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", datePublication=" + datePublication +
                '}';
    }
}
