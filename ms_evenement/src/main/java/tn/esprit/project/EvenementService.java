package tn.esprit.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvenementService {

	@Autowired
	private EvenementRepository evenementRepository;

    public Evenement addEvenement(Evenement e){
        return evenementRepository.save(e);
    }
    
    public Evenement updateEvenement(Evenement e,int id)
    {
        if (evenementRepository.findById(id).isPresent()){
            Evenement existingEvenement = evenementRepository.findById(id).get();
            existingEvenement.setNom(e.getNom());
            existingEvenement.setDateDebut(e.getDateDebut());
            existingEvenement.setDateFin(e.getDateFin());
            existingEvenement.setDescription(e.getDescription());
            return evenementRepository.save(existingEvenement);
        }
        else
            return null;
    }
    
    public String deleteEvenement(int id) {
        if (evenementRepository.findById(id).isPresent()) {
        	evenementRepository.deleteById(id);
            return "Event deleted !";
        } else {
            return "Event not found !";
        }
    }
    
    public Evenement getEvenement(int id){
        return evenementRepository.findById(id).get();
    }
    
    public List<Evenement> getAllEvenement(){
        return evenementRepository.findAll();
    }

}
