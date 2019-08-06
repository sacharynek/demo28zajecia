package javastart28zadaniezajecia.demo.Controller;

import javastart28zadaniezajecia.demo.model.Community;
import javastart28zadaniezajecia.demo.repository.CommunityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class CommunityController {
    //@Autowired - to powoduje, ze nie trzeba w konstruktorze inicjalizować elementu
    CommunityRepository communityRepository;



    public CommunityController(CommunityRepository communityRepository){
        this.communityRepository = communityRepository;
    }

    @RequestMapping("/")
    public String displayAllCommunities(Model model){

        List<Community> communities = communityRepository.findAll();

        model.addAttribute("communities", communities);

        return "main";
    }

    @RequestMapping("/{id}")
    public String displayDetails(Model model, @PathVariable(value="id") Long id){
        Optional<Community> optional = communityRepository.findById(id);

        Community community ;
        if(optional.isPresent()){
            community = optional.get();
        } else {
            community = null;
        }

       // community = optional.orElse(null);

        model.addAttribute("community", community);

        return "details";

    }

    @GetMapping("/Delete/{id}")
    public String delete(Model model, @PathVariable(value="id") String id) {
        communityRepository.deleteById(Long.parseLong(id));
        return "redirect:/";
    }

    @RequestMapping("/AddForm")
    public String displayAddForm(Model model){

        return "addForm";
    }

    @RequestMapping("/Add")
    public String dadd(Model model, Community community){
        communityRepository.save(community);
        return "redirect:/";
    }

}
