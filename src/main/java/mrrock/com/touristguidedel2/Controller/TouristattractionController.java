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


    @GetMapping("/attractions")
    public String getAllAttractions(Model model){
        model.addAttribute("attractionList",touristattractionService.getAllAttractions());
        return "attractions";
    }


    // GET attraction tags
    @GetMapping("/{name}/tags")
    public String getAttractionsTags(@PathVariable String name, Model model) {
        List<Tags> listOfTags = touristattractionService.getAttractionsTags(name);
        model.addAttribute(listOfTags);
        return "get-tags";
    }
    @PostMapping("/attractions/save")
    public ResponseEntity<Touristattraction> saveAttraction(@RequestBody Touristattraction touristattraction){
        touristattractionService.saveAttraction(touristattraction);
        return new ResponseEntity<Touristattraction>(touristattraction, HttpStatus.OK);
    }


    @GetMapping("/add")
    public String showAddAttractionForm(Model model) {
        model.addAttribute("attraction", new Touristattraction());
        model.addAttribute("tags", Tags.values()); // Enum værdier til Thymeleaf
        return "addAttractionForm"; // Henviser til HTML-filen
    }
}
