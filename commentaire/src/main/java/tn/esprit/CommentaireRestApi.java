package tn.esprit;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/comments") // Base URL for all endpoints in this controller
public class CommentaireRestApi {
    @Autowired
    private CommentaireService commentaireService;

    @PostMapping
    public ResponseEntity<Commentaire> createCommentaire(@RequestBody Commentaire commentaire) {
        return new ResponseEntity<>(commentaireService.addCondidat(commentaire), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Commentaire> updateCommentaire(
        @RequestBody Commentaire commentaire, 
        @PathVariable(value = "id") Long id
    ) {
        return new ResponseEntity<>(commentaireService.updateCondidat(commentaire, id), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Commentaire> displayAllCommentaires() {
        return commentaireService.afficherCommentaires();
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteCommentaire(@PathVariable(value = "id") Long id) {
        return new ResponseEntity<>(commentaireService.deleteCommentaire(id), HttpStatus.OK);
    }
}
