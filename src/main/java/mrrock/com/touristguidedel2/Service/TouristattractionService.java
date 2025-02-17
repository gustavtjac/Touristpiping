package mrrock.com.touristguidedel2.Service;


import mrrock.com.touristguidedel2.Repository.TouristattractionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TouristattractionService {
    @Autowired
    private TouristattractionRepository touristattractionRepository;

}
