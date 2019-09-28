package javastart28zadaniezajecia.demo.Controller;


import javastart28zadaniezajecia.demo.model.building.Building;
import javastart28zadaniezajecia.demo.model.community.Community;
import javastart28zadaniezajecia.demo.repository.BuildingRepository;
import javastart28zadaniezajecia.demo.repository.CommunityRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;
//@RequestMapping("/wspolnota")  // tak sie uwspólnia tj dodaje przedrostek do wszystkich
@Controller
public class BuildingController {

    BuildingRepository buildingRepository;
    CommunityRepository communityRepository;

    public BuildingController(BuildingRepository buildingRepository, CommunityRepository communityRepository) {
        this.buildingRepository = buildingRepository;
        this.communityRepository = communityRepository;
    }

    @RequestMapping("/addBuildingform/{id}")
    public String addBuildingForm(Model model, @PathVariable(value = "id") Long id) {

        model.addAttribute("id", id);

        return "buildingForm";
    }

    @RequestMapping("/addBuilding/{communityid}")
    public String addBuildingForm(@PathVariable Long communityid, Building building) {//jest jeszcze request Param

        Optional<Community> optional = communityRepository.findById(communityid);

        Community community = optional.orElse(null);

        building.setCommunity(community);

        buildingRepository.save(building);

        return "redirect:/";
    }

}
