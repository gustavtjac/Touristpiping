package mrrock.com.touristguidedel2.Controller;

import mrrock.com.touristguidedel2.Model.Tags;
import mrrock.com.touristguidedel2.Model.Touristattraction;
import mrrock.com.touristguidedel2.Service.TouristattractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller()
@RequestMapping("")
public class TouristattractionController {
    @Autowired
    private TouristattractionService  touristattractionService;

    // GET All Attractions
    @GetMapping("/attractions")
    public String getAllAttractions(Model model){
        model.addAttribute("attractionList",touristattractionService.getAllAttractions());
        return "attractions";
    }

    // GET Attraction By Name
    @GetMapping("/attractions/{name}")
    public String getAttractionByName(@PathVariable String name, Model model){
        model.addAttribute("attraction",touristattractionService.getAttractionByName(name));
        return "getAttraction-name";
    }

    // GET Attraction Tags
    @GetMapping("/attractions/{name}/tags")
    public String getAttractionsTags(@PathVariable String name, Model model) {
        List<Tags> listOfTags = touristattractionService.getAttractionsTags(name);
        Touristattraction touristattraction = touristattractionService.getAttractionByName(name);
        if (listOfTags.isEmpty()){
            model.addAttribute("tagList","Ikke nogle tags");
            model.addAttribute("attraction",touristattraction);
        }
        else{
            model.addAttribute("attraction",touristattraction);
            model.addAttribute("tagList",listOfTags);
        }
        return "attractionTags";
    }

    // POST Save Attraction
    @PostMapping("/attractions/save")
    public ResponseEntity<Touristattraction> saveAttraction(@RequestBody Touristattraction touristattraction){
        touristattractionService.saveAttraction(touristattraction);
        return new ResponseEntity<Touristattraction>(touristattraction, HttpStatus.OK);
    }

    // GET Add attraction
    @GetMapping("/attractions/add")
    public String showAddAttractionForm(Model model) {
        model.addAttribute("attraction", new Touristattraction());
        model.addAttribute("tags", Tags.values()); // Enum værdier til Thymeleaf
        return "addAttractionForm"; // Henviser til HTML-filen
    }

    // POST Update Attraction
    @PostMapping("/attractions/update")
    public ResponseEntity<Touristattraction> updateAttractions(@RequestBody Touristattraction touristattraction) {
        return new ResponseEntity<Touristattraction>(touristattractionService.updateAttraction(touristattraction), HttpStatus.OK);
    }

    // POST Delete Attraction
    @PostMapping("/attractions/delete/{name}")
    public ResponseEntity<Touristattraction> deleteAttraction(@PathVariable String name) {
        return new ResponseEntity<Touristattraction>(touristattractionService.deleteAttraction(name), HttpStatus.OK);
    }
}
