package mrrock.com.touristguidedel2.Service;


import mrrock.com.touristguidedel2.Model.Touristattraction;
import mrrock.com.touristguidedel2.Repository.TouristattractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class TouristattractionService {
    @Autowired
    private TouristattractionRepository touristattractionRepository;


    public List<Touristattraction> getAllAttractions(){
       return touristattractionRepository.getAllAttractions();
    }

    public Touristattraction saveAttraction(Touristattraction touristattraction){
        touristattractionRepository.saveAttraction(touristattraction);
        return touristattraction;
    }


}
