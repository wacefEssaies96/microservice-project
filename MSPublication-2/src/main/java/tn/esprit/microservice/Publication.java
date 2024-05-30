package tn.esprit.microservice;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publication implements Serializable {

	private static final long serialVersionUID = 6711457437559348053L;
    @Id
    @GeneratedValue
    private int id;
    private Date publicationDate;
    private Date editDate;
    private TypeVisibility visibility;
    private String contenu;
    private int nbrLikes;
    private TypeStatus status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	public TypeVisibility getVisibility() {
		return visibility;
	}
	public void setVisibility(TypeVisibility visibility) {
		this.visibility = visibility;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public int getNbrLikes() {
		return nbrLikes;
	}
	public void setNbrLikes(int nbrLikes) {
		this.nbrLikes = nbrLikes;
	}
	public TypeStatus getStatus() {
		return status;
	}
	public void setStatus(TypeStatus status) {
		this.status = status;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Publication [id=" + id + ", publicationDate=" + publicationDate + ", editDate=" + editDate
				+ ", visibility=" + visibility + ", contenu=" + contenu + ", nbrLikes=" + nbrLikes + ", status="
				+ status + "]";
	}
	public Publication() {
		super();
	}
	public Publication(int id, Date publicationDate, Date editDate, TypeVisibility visibility, String contenu,
			int nbrLikes, TypeStatus status) {
		super();
		this.id = id;
		this.publicationDate = publicationDate;
		this.editDate = editDate;
		this.visibility = visibility;
		this.contenu = contenu;
		this.nbrLikes = nbrLikes;
		this.status = status;
	}
    
}
