package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Service.UniversiteService;
import tn.esprit.university.reservation;
import tn.esprit.university.universite;

import java.util.Date;
import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/universite")
public class universiteController {
    @Autowired
    UniversiteService universiteService;
   @GetMapping("/retrieveAllUniversities")
    public List<universite> retrieveAllUniversities(){
        return  universiteService.retrieveAllUniversities();
    }
    @PostMapping("/addUniversity")
    @ResponseBody
    public universite addUniversity(@RequestBody universite u){
        return universiteService.addUniversity(u);
    }
    @PutMapping("/updateUniversity/{id}")
    public universite updateUniversity(@RequestBody universite u,@PathVariable Long id){
        return universiteService.updateUniversity(u,id);
    }
    @GetMapping("/retrieveUniversity/{id}")
    public universite retrieveUniversity(@PathVariable Long id){
        return  universiteService.retrieveUniversity(id);
    }
    @DeleteMapping("/removeUniversity/{id}")
    public void removeUniversity(@PathVariable Long id) {
        universiteService.removeUniversity(id);
    }

    @PutMapping("/affecterFoyerAUniversite/{id}/{nomUniversite}")
    public universite affecterFoyerAUniversite(@PathVariable long id, @PathVariable String nomUniversite){
        return universiteService.affecterFoyerAUniversite(id,nomUniversite);
    }
    @PutMapping("/desaffecterFoyerAUniversite/{id}")
    public universite desaffecterFoyerAUniversite(@PathVariable long id){
       return universiteService.desaffecterFoyerAUniversite(id);
    }


}

