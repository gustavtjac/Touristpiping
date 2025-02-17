package mrrock.com.touristguidedel2.Repository;


import mrrock.com.touristguidedel2.Model.Touristattraction;
import org.springframework.boot.autoconfigure.web.reactive.TomcatReactiveWebServerFactoryCustomizer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristattractionRepository {
    private List<Touristattraction> touristattractionList = new ArrayList<>();

    public List<Touristattraction> getAllAttractions(){
        return touristattractionList;
    }

    public Touristattraction saveAttraction(Touristattraction touristattraction){
        touristattractionList.add(touristattraction);
        return touristattraction;
    }


}
