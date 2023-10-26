package jar.project.timelapsev0.controllers;
import jar.project.timelapsev0.exception.ResourceNotFoundException;

import jar.project.timelapsev0.models.historicaldata;

import jar.project.timelapsev0.payload.response.MassageResponse;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import jar.project.timelapsev0.repository.historicalRepository;


import org.springframework.security.access.prepost.PreAuthorize;

import org.springframework.web.bind.annotation.*;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/apiiiiii")
@PreAuthorize("hasRole('ggggggg')")
public class historicalController {
    private static final Logger logger = LogManager.getLogger(UserController.class);
    @Autowired
    historicalRepository repository;

  @PostMapping("/add")
  public ResponseEntity<historicaldata> create(@RequestBody historicaldata Request) {
    historicaldata _model = repository.save(Request);
    return new ResponseEntity<>(_model, HttpStatus.CREATED);
  }
  @PutMapping("/update/{id}")
  public ResponseEntity<historicaldata> update(@PathVariable("id") long id, @RequestBody historicaldata Request) {
    historicaldata _model = repository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Not found historicaldata with id = " + id));
        _model.setId(Request.getId());
        _model.setDate(Request.getDate());
        _model.setSolarPower(Request.getSolarPower());
        _model.setBattery(Request.getBattery());
        _model.setTemp(Request.getTemp());
    
    return new ResponseEntity<>(repository.save(_model), HttpStatus.OK);
  }
    @GetMapping("/All")
    public ResponseEntity<List<historicaldata>> getAll() {
      List<historicaldata> camdata = new ArrayList<historicaldata>();
      System.out.println(camdata);
      repository.findAll().forEach(camdata::add);
     
      if (camdata.isEmpty()) 
      {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<>(camdata, HttpStatus.OK);
    }

    @GetMapping("/getbyid/{id}")
    public ResponseEntity<historicaldata> getbyId(@PathVariable("id") Long id ){
        
        historicaldata Data = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Not found User with id = " + id));
            
            return new ResponseEntity<>(Data, HttpStatus.OK); 
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MassageResponse> delete(@PathVariable("id") long id){
        try {
            repository.deleteById(id);
            return  ResponseEntity.ok(new MassageResponse("historicaldata with id "+id +" just got deleted!"));
          } catch (Exception e) {
            return  ResponseEntity.badRequest()
            .body(new MassageResponse("Error: historicaldata with id "+id +" dose not exist"));
          }
    }    
}
