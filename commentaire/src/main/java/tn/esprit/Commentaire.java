package tn.esprit;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentaire implements Serializable{
    private static final long serialVersionUID = 6711457437559348053L;

    @Id
    @GeneratedValue
    private  Long  id;
    private String contenu;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation")
    private Date dateCreation;

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Commentaire(String contenu) {
        super();
        this.contenu = contenu;
        this.dateCreation = new Date(); // Set dateCreation to current date and time
       
    }

    public Commentaire() {
        super();
        this.dateCreation = new Date(); // Set dateCreation to current date and time
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
