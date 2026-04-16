package br.dev.mmddkk.garagem.controller;

import br.dev.mmddkk.garagem.model.Vaga;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
        ModelAndView mv = new ModelAndView("estacionamento/listaVaga");
        mv.addObject("vagas", vr.findAll());
        return mv;
    }

    @RequestMapping("/vaga/{id}/editar")
    public ModelAndView editar(@PathVariable("id") Long id) {
        Vaga vaga = vr.findById(id).orElseThrow(() -> new IllegalArgumentException("Vaga não encontrada"));
        ModelAndView mv = new ModelAndView("estacionamento/formVaga");
        mv.addObject("vaga", vaga);
        return mv;
    }

    @RequestMapping("/vaga/{id}/deletar")
    public String deletar(@PathVariable("id") Long id, RedirectAttributes attributes) {
        vr.deleteById(id);
        attributes.addFlashAttribute("mensagem", "Vaga removida com sucesso!");
        return "redirect:/vaga";
    }

}
