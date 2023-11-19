package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Service.IEtudiantService;
import tn.esprit.university.Etudiant;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/etudiants")
public class etudiantController {
    @Autowired
    IEtudiantService etudiantService;
@PostMapping("/addEtudiant")
public Etudiant addEtudiant(@RequestBody Etudiant e){
    return etudiantService.addEtudiant(e);
}
@GetMapping("/retrieveEtudiant/{id}")
    public Etudiant retrieveEtudiant(@PathVariable("id")Long id){

    return etudiantService.retrieveEtudiant(id);
}
    @PutMapping("/updateEtudiant/{id}")
    public Etudiant updateEtudiant(@RequestBody Etudiant e,@PathVariable Long id){
    Etudiant etudiant=etudiantService.updateEtudiant(e,id);
    return etudiant;
}
@DeleteMapping("/removeEtudiant/{id}")
    public void removeEtudiant(@PathVariable("id")Long id){
    etudiantService.removeEtudiant(id);
}


@PostMapping("/addEtudiants")
    public List<Etudiant> addEtudiants (@RequestBody List<Etudiant> etudiants){
    return etudiantService.addEtudiants(etudiants);
}
@PutMapping("/affecterEtudiantAReservation/{nomEt},{prenomEt},{idReservation}")
    public Etudiant affecterEtudiantAReservation(@PathVariable String nomEt,@PathVariable String prenomEt,@PathVariable String idReservation){
   return etudiantService.affecterEtudiantAReservation(nomEt,prenomEt,idReservation);

}
}
