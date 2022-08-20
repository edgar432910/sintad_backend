package com.P_T.API_SPRING.Controller;


import com.P_T.API_SPRING.Dto.EntidadDTO;
import com.P_T.API_SPRING.Exception.ModeloNotFoundException;
import com.P_T.API_SPRING.Model.Entidad;
import com.P_T.API_SPRING.Service.IEntidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/entidad")
public class EntidadController {
    @Autowired
    private IEntidadService service;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/prueba")
    String Prueba(@RequestParam(defaultValue = "ValorDefecto") String nombre){
        return "hola"+ nombre;
    }


    @GetMapping
    public ResponseEntity<List<EntidadDTO>> listar() throws Exception {
        List<EntidadDTO> lista = service.listar().stream().map(p -> mapper.map(p, EntidadDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntidadDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Entidad obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        EntidadDTO dto = mapper.map(obj, EntidadDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody EntidadDTO dto) throws Exception {
        Entidad p = mapper.map(dto, Entidad.class);
        p.setEstado(true);
        Entidad obj = service.registrar(p);


        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdEntidad()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<EntidadDTO> modificar(@Valid @RequestBody EntidadDTO dto) throws Exception {
        System.out.println("DTO_ID : " +dto.getIdEntidad());
        Entidad obj = service.listarPorId(dto.getIdEntidad());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdEntidad());
        }

        Entidad p = mapper.map(dto, Entidad.class);
        Entidad pac = service.modificar(p);
        EntidadDTO dtoResponse = mapper.map(pac, EntidadDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Entidad obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
