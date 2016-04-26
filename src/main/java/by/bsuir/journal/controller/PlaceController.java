package by.bsuir.journal.controller;

import by.bsuir.journal.model.Place;
import by.bsuir.journal.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping
//@SessionAttributes("types")
public class PlaceController {
    @Autowired
    PlaceService placeService;

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = {"/placeslist"}, method = RequestMethod.GET)
    public String placesList(ModelMap model) {
        List<Place> places = placeService.findAllPlaces();
        model.addAttribute("places", places);
        return "placeslist";
    }

    @RequestMapping(value = {"/places-create"}, method = RequestMethod.GET)
    public String newPlace(ModelMap model) {
        Place place = new Place();
        model.addAttribute("place", place);
        model.addAttribute("edit", false);
        return "createPlace";
    }

    @RequestMapping(value = {"/places-create"}, method = RequestMethod.POST)
    public String savePlace(@Valid Place place, ModelMap model, BindingResult result) {
        if (result.hasErrors()) {
            return "createPlace";
        }
        //todo check unique name
        placeService.savePlace(place);

        return "redirect:/placeslist";
    }

    @RequestMapping(value = {"/places-edit-{name}"}, method = RequestMethod.GET)
    public String editPlace(@PathVariable String name, ModelMap model) {
        Place place = placeService.findByName(name);
        model.addAttribute("place", place);
        model.addAttribute("edit", true);
        return "createPlace";
    }

    @RequestMapping(value = {"/places-edit-{name}"}, method = RequestMethod.POST)
    public String updatePlace(@Valid Place place, ModelMap model, BindingResult result, @PathVariable String name) {

        placeService.updatePlace(place);
        return "redirect:/placeslist";
    }

    @RequestMapping(value = {"/places-delete-{name}"}, method = RequestMethod.GET)
    public String deletePlace(@PathVariable String name) {
        Place place = placeService.findByName(name);
        placeService.deletePlaceByName(name);
        return "redirect:/placeslist";
    }

//    @ModelAttribute("types")
//    public List<String> initializeProfiles() {
//        List<String> types = new ArrayList<String>() ;
//        types.add("RESTAURANT");
//        types.add("CLUB");
//        types.add("THEATER");
//        types.add("GALLERY");
//
//        return types;
//    }
}
