package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Service.IFoyerService;
import tn.esprit.university.Foyer;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/foyer")
public class foyerController {
@Autowired
    IFoyerService foyerService;
@PostMapping("/addFoyer")
    public Foyer addFoyer(@RequestBody Foyer f){

    return foyerService.addFoyer(f);
}
@GetMapping("/getAllFoyer")
    public List<Foyer> retrieveAllFoyers(){
    return foyerService.retrieveAllFoyers();
}

@PutMapping("/updateFoyer/{id}")
    public Foyer updateFoyer(@RequestBody Foyer f, @PathVariable Long id){
    return foyerService.updateFoyer(f,id);
}
@GetMapping("/retrieveFoyer/{id}")
    public Foyer retrieveFoyer(@PathVariable Long id){
    return foyerService.retrieveFoyer(id);
}
@PutMapping("/archiverFoyer/{id}")
    public void archiverFoyer(@PathVariable  Long id){
    foyerService.archiverFoyer(id);
}

@PostMapping("/ajouterFoyerEtAffecterAUniversite/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(
            @RequestBody Foyer foyer,
            @PathVariable long idUniversite) {

        Foyer addedFoyer = foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);

     return addedFoyer;
    }
}
