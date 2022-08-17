package com.P_T.API_SPRING.Controller;


import com.P_T.API_SPRING.Dto.TipoContribuyenteDTO;
import com.P_T.API_SPRING.Exception.ModeloNotFoundException;
import com.P_T.API_SPRING.Model.TipoContribuyente;
import com.P_T.API_SPRING.Service.ITipoContribuyenteService;
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
@RequestMapping("/api/tipoContribuyente")
public class TipoContribuyenteController {
    @Autowired
    private ITipoContribuyenteService service ;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/prueba")
    String Prueba(@RequestParam(defaultValue = "Valordefecto") String nombre){
        return  "Hola "+ nombre;
    }

    @GetMapping
    //@RequestMapping(value = "/" , method = RequestMethod.GET)
    public ResponseEntity<List<TipoContribuyenteDTO>> listar() throws Exception {
        List<TipoContribuyenteDTO> lista = service.listar().stream().map(p -> mapper.map(p, TipoContribuyenteDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoContribuyenteDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        TipoContribuyente obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        TipoContribuyenteDTO dto = mapper.map(obj, TipoContribuyenteDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

	/*@PostMapping
	public ResponseEntity<Paciente> registrar(@RequestBody Paciente p) throws Exception {
		Paciente obj = service.registrar(p);
		return new ResponseEntity<>(obj, HttpStatus.CREATED);
	}*/

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody TipoContribuyenteDTO dto) throws Exception {
        TipoContribuyente p = mapper.map(dto, TipoContribuyente.class);
        TipoContribuyente obj = service.registrar(p);

        //localhost:8080/TipoContribuyentes/5
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoContribuyente()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<TipoContribuyenteDTO> modificar(@Valid @RequestBody TipoContribuyenteDTO dto) throws Exception {
        TipoContribuyente obj = service.listarPorId(dto.getIdTipoContribuyente());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdTipoContribuyente());
        }

        TipoContribuyente p = mapper.map(dto, TipoContribuyente.class);
        TipoContribuyente pac = service.modificar(p);
        TipoContribuyenteDTO dtoResponse = mapper.map(pac, TipoContribuyenteDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        TipoContribuyente obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
