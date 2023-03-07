package com.communicationMarketing.main.Controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;






import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.communicationMarketing.main.business.dtos.GraphicalCharterDTO;
import com.communicationMarketing.main.business.ibusiness.IgraphicalCharterBusiness;
import com.communicationMarketing.main.entity.GraphicalCharter;

@RequestMapping(path = { "/GraphicalCharter" }, produces = APPLICATION_JSON_VALUE)
@RestController
public class GraphicalCharterController {
	IgraphicalCharterBusiness IgraphicalCharterBusiness;

    public GraphicalCharterController(IgraphicalCharterBusiness IgraphicalCharterBusiness){
        this.IgraphicalCharterBusiness=IgraphicalCharterBusiness;
    }

   
    @PostMapping("/add")
    public ResponseEntity<GraphicalCharter> addgraphicalCharter (@Valid @RequestBody GraphicalCharterDTO graphicalCharterDTO){
        return IgraphicalCharterBusiness.addgraphicalCharter(graphicalCharterDTO);
    }
    @GetMapping("/allgraphicalCharters")
    public ResponseEntity<List<GraphicalCharter>> findAllgraphicalCharters(){
        List<GraphicalCharter> rows = IgraphicalCharterBusiness.getAllgraphicalCharters();
        return new ResponseEntity <>(rows, HttpStatus.OK);
    }

    
    @PutMapping("/update-graphicalCharter")
    public GraphicalCharter updateGraphicalCharter(@RequestBody GraphicalCharter g){
        return IgraphicalCharterBusiness.updategraphicalCharter(g);
    }

    
    

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletegraphicalCharter(@PathVariable("id") String id){
        return IgraphicalCharterBusiness.deletegraphicalCharter(id);
    }


    @GetMapping("/graphicalCharter-by-id/{id}")
    public ResponseEntity<?> getgraphicalCharterByID (@PathVariable("id") String id){
        return IgraphicalCharterBusiness.getgraphicalChartertByID(id);
    }

    
    @GetMapping("/count-graphicalCharters")
    public long countgraphicalCharters(){
        return IgraphicalCharterBusiness.countgraphicalCharters();
    }


}

