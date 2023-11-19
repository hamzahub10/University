package tn.esprit.university.Controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tn.esprit.university.Service.IBlocService;
import tn.esprit.university.bloc;

import java.util.List;

@RestController
@AllArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("api/bloc")
public class blocController {
    IBlocService blocService;
    @PostMapping("/addBlock")
    public bloc addblock(@RequestBody bloc bloc){
       return blocService.addBlock(bloc);
    }


    @PostMapping("/{idBloc}/chambres")
    public bloc affecterChambresABloc(@PathVariable("idBloc") long idBloc, @RequestBody List<Long> numChambre) {
        bloc bloc = blocService.affecterChambresABloc(numChambre, idBloc);
        return bloc;
    }
    }

