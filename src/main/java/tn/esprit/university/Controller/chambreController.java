package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Service.ChambreService;
import tn.esprit.university.TypeChambre;
import tn.esprit.university.chambre;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/chambre")

public class chambreController {
    ChambreService chambreService;

@PostMapping("/addChambres")
    public List<chambre> addChambres(@RequestBody List<chambre> chambres) {

    return chambreService.addChambres(chambres);
}
    @GetMapping("/GetChambresParBlocNom/{nombloc}")
            public List<chambre> getChambresParNomBloc(@PathVariable  String nombloc) {
        return chambreService.getChambresParNomBloc(nombloc);
    }
        @GetMapping("/nbrChambreParTypeEtBloc/{type},{idbloc}")
                public long nbrChambreParTypeEtBloc(@PathVariable TypeChambre type,@PathVariable long idbloc){
    return chambreService.nbrChambreParTypeEtBloc(type,idbloc);
        }
    }




