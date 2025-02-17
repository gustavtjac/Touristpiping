package mrrock.com.touristguidedel2.Controller;



import mrrock.com.touristguidedel2.Model.Tags;
import mrrock.com.touristguidedel2.Model.Touristattraction;
import mrrock.com.touristguidedel2.Service.TouristattractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("")
public class TouristattractionController {
    @Autowired
    private TouristattractionService  touristattractionService;


    @GetMapping("/attractions")
    public String getAllAttractions(Model model){
        return "attractions";
    }


    @GetMapping("/add")
    public String showAddAttractionForm(Model model) {
        model.addAttribute("attraction", new Touristattraction());
        model.addAttribute("tags", Tags.values()); // Enum værdier til Thymeleaf
        return "addAttractionForm"; // Henviser til HTML-filen
    }
}
