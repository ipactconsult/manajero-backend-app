package com.example.litigerecouvrement.controller;


import org.springframework.web.bind.annotation.*;


import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path= {"/promise"}, produces= APPLICATION_JSON_VALUE)
@CrossOrigin(origins="*")
public class PromiseController {
   /* private final ModelMapper modelMapper;


    final PromiseIBusiness bcc ;
    public PromiseContoller(ModelMapper modelMapper, PromiseIBusiness bcc){
        this.modelMapper = modelMapper;

        this.bcc=bcc ;
    }

    @PostMapping("/add")
        public Promise createPromise(@RequestBody PromiseDTO promise){
        Promise re = modelMapper.map(promise, Promise.class);

        return bcc.createPromise(re);

    }
    @GetMapping("/all")
    public ResponseEntity<List<Promise>> findAllAction(){
        return new ResponseEntity<>(bcc.findAllPromise(), HttpStatus.OK);
    }
  @PutMapping("/update/{id}")
    public Promise editAction(@PathVariable("id") String id, @RequestBody PromiseDTO promisedto)
    {
        Promise promise = modelMapper.map(promisedto, Promise.class);


        return bcc.updatePromise(id,promise);
    }

    @DeleteMapping( "/delete/{id}")
    public String deletePromise(@PathVariable String id) {
        return bcc.deletePromise(id);
    }

    @GetMapping( "/findbyid/{id}")
    public ResponseEntity<Relance> getRelanceyid(@PathVariable("id") String id)
    {
        return bcc.findByid(id);
    }
*/
}
