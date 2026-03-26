package br.dev.mmddkk.garagem.controller;

import br.dev.mmddkk.garagem.model.Vaga;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.dev.mmddkk.garagem.respository.*;

@Controller
public class VagaController {

    @Autowired
    private VagaRepository vr;

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mv = new ModelAndView("estacionamento/formVaga");
        mv.addObject("vaga", new Vaga());
        return mv;
    }

    @RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
    public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {

        if (result.hasErrors()) {
            attributes.addFlashAttribute("mensagem", "Verifique os campos...");
            return "redirect:/cadastrarVaga";
        }

        vr.save(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
        return "redirect:/cadastrarVaga";

    }

    @RequestMapping("/vaga")
    public ModelAndView listaVagas() {
        ModelAndView mv = new ModelAndView("estacionamento/formVaga");
        mv.addObject("vagas", vr.findAll());
        return mv;
    }

    @RequestMapping("/editarVaga")
    public ModelAndView editarVaga(long codigo) {
        Vaga vaga = vr.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("estacionamento/formVaga");
        mv.addObject("vaga", vaga);
        return mv;
    }

    @RequestMapping("/deletarVaga")
    public String deletarVaga(long codigo, RedirectAttributes attributes) {
        Vaga vaga = vr.findByCodigo(codigo);
        vr.delete(vaga);
        attributes.addFlashAttribute("mensagem", "Vaga removida com sucesso!");
        return "redirect:/vaga";
    }

}
