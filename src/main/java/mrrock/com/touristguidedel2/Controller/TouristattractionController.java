package mrrock.com.touristguidedel2.Controller;


import mrrock.com.touristguidedel2.Service.TouristattractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /** Method to handle name requests **/
    @GetMapping("/{name}")
    public String getAttraction(@PathVariable String name, Model model){
        model.addAttribute("attraction",touristattractionService.getAttraction(name));
        return "singleattraction";
    }


}
