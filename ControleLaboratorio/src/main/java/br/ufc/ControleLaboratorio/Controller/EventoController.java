package br.ufc.ControleLaboratorio.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.ControleLaboratorio.Model.Evento;
import br.ufc.ControleLaboratorio.Repository.EventoRepository;

@RestController
@RequestMapping("/api/evento")
public class EventoController {
	
	@Autowired
    EventoRepository eventoRepository;
	
	@GetMapping
    public List<Evento> GetAllEvento() {
        return (List<Evento>) eventoRepository.findAll();
    }
	
    @PostMapping
    public Evento save(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

}
