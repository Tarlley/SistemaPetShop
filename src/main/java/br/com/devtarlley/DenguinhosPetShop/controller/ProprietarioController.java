package br.com.devtarlley.DenguinhosPetShop.controller;

import br.com.devtarlley.DenguinhosPetShop.domains.dto.ProprietarioDto;
import br.com.devtarlley.DenguinhosPetShop.mapper.ProprietarioMapper;
import br.com.devtarlley.DenguinhosPetShop.services.ProprietarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/proprietarios")
@Api(value = "API REST Pet")
@CrossOrigin(origins = "*")
public class ProprietarioController {

    private final ProprietarioMapper proprietarioMapper;
     private final ProprietarioService service;

    public ProprietarioController(ProprietarioMapper proprietarioMapper, ProprietarioService service) {
        this.proprietarioMapper = proprietarioMapper;
        this.service = service;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna um proprietario pelo id informado pelo usuario")
    public ResponseEntity<?> find(@PathVariable Integer id){
        return service.find(id);
     }

     @GetMapping
     @ApiOperation(value = "Retorna uma lista de proprietario ")
     public ResponseEntity<?> findAll(){
         List<ProprietarioDto> listDto = proprietarioMapper.toDto(service.findAll());
             return ResponseEntity.status(HttpStatus.OK).body(listDto);

     }

     @RequestMapping(method = RequestMethod.POST)
     @ApiOperation(value = "Salva um novo proprietario")
     public ResponseEntity<Void> salvarProprietario(@Valid @RequestBody ProprietarioDto proprietarioDto){
         URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                 .path("/{id}").buildAndExpand(service.salvarProprietario(proprietarioDto)).toUri();
         return ResponseEntity.created(uri).build();
     }

    @DeleteMapping("/{id}")
    @ResponseBody
    @ApiOperation(value = "Deleta um proprietario pelo Id informado")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
