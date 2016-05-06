package by.bsuir.journal.controller;

import by.bsuir.journal.model.Place;
import by.bsuir.journal.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

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
    //==============JSON===========================
    //headers="Accept=application/json"
    @RequestMapping(value = {"/place/"}, method = RequestMethod.GET)
    public ResponseEntity<List<Place>> placeList(){
        System.out.println("Try to print list");
        List<Place> places = placeService.findAllPlaces();
        if(places.isEmpty()){
            return new ResponseEntity<List<Place>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Place>>(places, HttpStatus.OK);
    }

    @RequestMapping(value = {"/place/{id}"}, method = RequestMethod.GET)
    public  ResponseEntity<Place> getPlace(@PathVariable("id") int id) {
        Place place = placeService.findById(id);
        if (place == null) {
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Place>(place, HttpStatus.OK);
    }

    @RequestMapping(value = "/place/", method = RequestMethod.POST)
    public ResponseEntity<Void> createPlace(@RequestBody Place place, UriComponentsBuilder ucBuilder) {

        if (!placeService.isPlaceNameUnique(place.getId(),place.getName())) {
            System.out.println("A Place with name " + place.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        placeService.savePlace(place);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/place/{id}").buildAndExpand(place.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Place> updatePlace(@PathVariable("id") int id, @RequestBody Place place) {
        System.out.println("Updating Place " + id);

        Place currentPlace = placeService.findById(id);

        if (currentPlace==null) {
            System.out.println("Place with id " + id + " not found");
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }

        placeService.updatePlace(currentPlace);
        return new ResponseEntity<Place>(currentPlace, HttpStatus.OK);
    }

    @RequestMapping(value = "/place/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Place> deletePlace(@PathVariable("id") int id) {
        System.out.println("Fetching & Deleting Place with id " + id);

        Place currentPlace = placeService.findById(id);
        if (currentPlace == null) {
            System.out.println("Unable to delete. Place with id " + id + " not found");
            return new ResponseEntity<Place>(HttpStatus.NOT_FOUND);
        }

        placeService.deletePlaceByName(currentPlace.getName());
        return new ResponseEntity<Place>(HttpStatus.NO_CONTENT);
    }


    //==============JSP===========================

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
