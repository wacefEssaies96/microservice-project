package tn.esprit.microservice;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/publication")
public class PublicationRestApi {

	@Autowired
    private PublicationService pubService;
	
	@GetMapping
	public ResponseEntity<List<Publication>> getAllPublications() {
	    List<Publication> publications = pubService.getAllPublication();
	    return new ResponseEntity<>(publications, HttpStatus.OK);
	}
	
	@GetMapping("/pub/{publicationId}")
	public ResponseEntity<Publication> getPublicationById(@PathVariable int publicationId) {
	    Publication publication = pubService.getPublication(publicationId);

	    if (publication != null) {
	        return new ResponseEntity<>(publication, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

    @PostMapping(value="/addPub")
    public ResponseEntity<Publication> createPublication(@RequestBody Publication pub) {
    	return new ResponseEntity<Publication>(pubService.addPublication(pub), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Publication> updatePublication(@RequestBody Publication Publication, @PathVariable (value = "id") int id) {
        return new ResponseEntity<Publication>(pubService.updatePublication(Publication,id), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deletePublication(@PathVariable (value = "id") int id) {
        return new ResponseEntity<String>(pubService.deletePublication(id), HttpStatus.CREATED);
    }
}
