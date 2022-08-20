package com.P_T.API_SPRING.Controller;


import com.P_T.API_SPRING.Dto.TipoDocumentoDTO;
import com.P_T.API_SPRING.Exception.ModeloNotFoundException;
import com.P_T.API_SPRING.Model.TipoDocumento;
import com.P_T.API_SPRING.Service.ITipoDocumentoService;
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
@RequestMapping("/api/tipoDocumento")
public class TipoDocumentoController {
    @Autowired
    private ITipoDocumentoService service ;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/prueba")
    String Prueba(@RequestParam(defaultValue = "Valordefecto") String nombre){
        return  "Hola "+ nombre;
    }



    @GetMapping
    public ResponseEntity<List<TipoDocumentoDTO>> listar() throws Exception {
        List<TipoDocumentoDTO> lista = service.listar().stream().map(p -> mapper.map(p, TipoDocumentoDTO.class)).collect(Collectors.toList());

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDocumentoDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
        TipoDocumento obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }

        TipoDocumentoDTO dto = mapper.map(obj, TipoDocumentoDTO.class);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody TipoDocumentoDTO dto) throws Exception {
        TipoDocumento p = mapper.map(dto, TipoDocumento.class);
        p.setEstado(true);
        TipoDocumento obj = service.registrar(p);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdTipoDocumento()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<TipoDocumentoDTO> modificar(@Valid @RequestBody TipoDocumentoDTO dto) throws Exception {
        TipoDocumento obj = service.listarPorId(dto.getIdTipoDocumento());

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + dto.getIdTipoDocumento());
        }

        TipoDocumento p = mapper.map(dto, TipoDocumento.class);
        TipoDocumento pac = service.modificar(p);
        TipoDocumentoDTO dtoResponse = mapper.map(pac, TipoDocumentoDTO.class);
        return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        TipoDocumento obj = service.listarPorId(id);

        if(obj == null) {
            throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
        }
        service.eliminar(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
