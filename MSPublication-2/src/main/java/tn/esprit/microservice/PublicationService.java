package tn.esprit.microservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublicationService {

	@Autowired
	private PublicationRepository pubRepository;

    public Publication addPublication(Publication pub){
        return pubRepository.save(pub);
    }
    
    public Publication updatePublication(Publication newPublication,int id)
    {
        if (pubRepository.findById(id).isPresent())
        {
            Publication existingPublication = pubRepository.findById(id).get();
            existingPublication.setContenu(newPublication.getContenu());
            existingPublication.setEditDate(null);
            existingPublication.setPublicationDate(newPublication.getPublicationDate());
            existingPublication.setNbrLikes(newPublication.getNbrLikes());
            existingPublication.setStatus(newPublication.getStatus());
            existingPublication.setVisibility(newPublication.getVisibility());
            return pubRepository.save(existingPublication);
        }
        else
            return null;
    }
    
    public String deletePublication(int id) {
        if (pubRepository.findById(id).isPresent()) {
        	pubRepository.deleteById(id);
            return "Publication deleted !";
        } else {
            return "Publication not found !";
        }
    }
    
    public Publication getPublication(int id){
        return pubRepository.findById(id).get();
    }
    
    public List<Publication> getAllPublication(){
        return pubRepository.findAll();
    }

}
