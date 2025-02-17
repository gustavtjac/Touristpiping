package mrrock.com.touristguidedel2.Repository;


import mrrock.com.touristguidedel2.Model.Touristattraction;
import org.springframework.boot.autoconfigure.web.reactive.TomcatReactiveWebServerFactoryCustomizer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristattractionRepository {
    private List<Touristattraction> touristattractionList = new ArrayList<>();



    /** Method to find attraction from name requests **/
    public Touristattraction getAttraction(String name){
        for (Touristattraction t :touristattractionList){
            if (name.equalsIgnoreCase(t.getName())){
                return t;
            }
        }
        return null;
    }





}
