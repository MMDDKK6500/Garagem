package br.dev.mmddkk.garagem.controller;

import br.dev.mmddkk.garagem.respository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClienteController {
    @Autowired
    ClienteRepository cr;
}
