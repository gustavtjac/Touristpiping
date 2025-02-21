package mrrock.com.touristguidedel2.Controller;

import mrrock.com.touristguidedel2.Model.Cities;
import mrrock.com.touristguidedel2.Model.Tags;
import mrrock.com.touristguidedel2.Model.Touristattraction;
import mrrock.com.touristguidedel2.Service.TouristattractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    public String saveAttraction(@RequestBody Touristattraction touristattraction){
        if (touristattraction.getId()!=null){
            touristattraction.setId(UUID.randomUUID());
            touristattractionService.saveAttraction(touristattraction);
        }
        else{
            touristattractionService.updateAttraction(touristattraction);
        }

        return "redirect:/attractions";
    }

    // GET Add attraction
    @GetMapping("/attractions/add")
    public String showAddAttractionForm(Model model) {
        model.addAttribute("attraction", new Touristattraction());
        model.addAttribute("cities", Cities.values());
        model.addAttribute("tags", Tags.values()); // Enum værdier til Thymeleaf
        return "manage"; // Henviser til HTML-filen
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
