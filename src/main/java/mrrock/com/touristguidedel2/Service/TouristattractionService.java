package mrrock.com.touristguidedel2.Service;


import mrrock.com.touristguidedel2.Model.Tags;
import mrrock.com.touristguidedel2.Repository.TouristattractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristattractionService {
    @Autowired
    private TouristattractionRepository touristattractionRepository;

    // GET attraction tags
    public List<Tags> getAttractionsTags(String name) {
        List<Tags> listOfTags = touristattractionRepository.getAttractionsTags(name);
        return listOfTags;
    }
}
