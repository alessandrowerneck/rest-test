package com.example.demo.web.rest;

import com.example.demo.entity.Grupo;
import com.example.demo.repository.GrupoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/grupos")
public class GrupoController {

    @Autowired
    private GrupoRepository _grupoRepository;

    @GetMapping("/grupo")
    public List<Grupo> get() {
        return _grupoRepository.findAll();
    }

    @RequestMapping(value = "/grupo/{id}", method = RequestMethod.GET)
    public ResponseEntity<Grupo> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Grupo> grupo = _grupoRepository.findById(id);
        if(grupo.isPresent())
            return new ResponseEntity<Grupo>(grupo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/grupo", method =  RequestMethod.POST)
    public Grupo Post(@Valid @RequestBody Grupo grupo)
    {
        return _grupoRepository.save(grupo);
    }

    @RequestMapping(value = "/grupo/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Grupo> Put(@PathVariable(value = "id") long id, @Valid @RequestBody Grupo newGrupo)
    {
        Optional<Grupo> oldGrupo = _grupoRepository.findById(id);
        if(oldGrupo.isPresent()){
            Grupo grupo = oldGrupo.get();
            grupo.setNome(newGrupo.getNome());
            _grupoRepository.save(grupo);
            return new ResponseEntity<Grupo>(grupo, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/grupo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Grupo> grupo = _grupoRepository.findById(id);
        if(grupo.isPresent()){
            _grupoRepository.delete(grupo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
