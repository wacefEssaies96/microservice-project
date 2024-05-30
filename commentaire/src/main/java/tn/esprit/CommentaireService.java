package tn.esprit;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentaireService {

    @Autowired
    private CommentaireRepository CommentaireRepository;


    public Commentaire addCondidat(Commentaire commentaire){
        return CommentaireRepository.save(commentaire);
    }

    public Commentaire updateCondidat(Commentaire newCommentaire, Long id){
        if(CommentaireRepository.findById(id).isPresent()){
            Commentaire existingCommentaire = CommentaireRepository.findById(id).get();
            existingCommentaire.setContenu(newCommentaire.getContenu());
          
            return CommentaireRepository.save(existingCommentaire);
        }
        else return null;

    }
    public String deleteCommentaire(Long id) {
        if (CommentaireRepository.findById(id).isPresent()) {
            CommentaireRepository.deleteById(id);
            return "Commentaire supprimé";
        } else return "Commentaire non supprimé";

    }
    public List<Commentaire> afficherCommentaires() {
		List<Commentaire> l = this.CommentaireRepository.findAll();
		for(Commentaire p : l) {
			System.out.println("Commentaire : " + p.toString());
		}
		return l;
	}
}
