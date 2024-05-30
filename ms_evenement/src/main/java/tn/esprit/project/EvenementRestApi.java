package tn.esprit.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/evenement")
public class EvenementRestApi {

	@Autowired
    private EvenementService evenementService;
	
	@GetMapping
	public ResponseEntity<List<Evenement>> getAllPublications() {
	    List<Evenement> e = evenementService.getAllEvenement();
	    return new ResponseEntity<>(e, HttpStatus.OK);
	}
	
	@GetMapping("/get/{evenementId}")
	public ResponseEntity<Evenement> getPublicationById(@PathVariable int evenementId) {
		Evenement e = evenementService.getEvenement(evenementId);
	    if (e != null) {
	        return new ResponseEntity<>(e, HttpStatus.OK);
	    }else {
		    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

    @PostMapping(value="/add-evenement")
    public ResponseEntity<Evenement> createPublication(@RequestBody Evenement e) {
        return new ResponseEntity<Evenement>(evenementService.addEvenement(e), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/update/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Evenement> updatePublication(@RequestBody Evenement e, @PathVariable (value = "id") int id) {
        return new ResponseEntity<Evenement>(evenementService.updateEvenement(e,id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePublication(@PathVariable (value = "id") int id) {
        return new ResponseEntity<String>(evenementService.deleteEvenement(id), HttpStatus.OK);
    }
}
