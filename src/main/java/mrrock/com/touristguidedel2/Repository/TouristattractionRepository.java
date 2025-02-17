package mrrock.com.touristguidedel2.Repository;


import mrrock.com.touristguidedel2.Model.Tags;
import mrrock.com.touristguidedel2.Model.Touristattraction;
import org.springframework.boot.autoconfigure.web.reactive.TomcatReactiveWebServerFactoryCustomizer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristattractionRepository {
    private List<Touristattraction> touristattractionList = new ArrayList<>();

    // GET All Attractions
    public List<Touristattraction> getAllAttractions(){
        return touristattractionList;
    }

    // POST Save Attraction
    public Touristattraction saveAttraction(Touristattraction touristattraction){
        touristattractionList.add(touristattraction);
        return touristattraction;
    }

    // GET Attraction Tags
    public List<Tags> getAttractionsTags(String name) {
        List<Tags> foundTags = new ArrayList<>();
        for (Touristattraction attractions : touristattractionList) {
            if (attractions.getName().equalsIgnoreCase(name)) {
                for (Tags t : attractions.getTags()) {
                    foundTags.add(t);
                }
            }

        }
        return foundTags;
    }

    // POST Update Attraction
    public Touristattraction updateAttraction(Touristattraction touristattraction) {
        for (Touristattraction attraction : touristattractionList) {
            if (attraction.getId().equals(touristattraction.getId())) {
                attraction.setDescription(touristattraction.getDescription());
                attraction.setName(touristattraction.getName());
                attraction.setTags(touristattraction.getTags());
                return attraction;
            }
        }
        return null;
    }

}
