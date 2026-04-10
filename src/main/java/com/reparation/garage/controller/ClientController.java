package com.reparation.garage.controller;

import com.reparation.garage.model.Client;
import com.reparation.garage.repository.ClientRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String list(Model model) {
        preparePage(model, new Client(), false);
        return "clients";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Client client = clientRepository.findById(id).orElseThrow();
        preparePage(model, client, true);
        return "clients";
    }

    private void preparePage(Model model, Client client, boolean editMode) {
        model.addAttribute("clients", clientRepository.findAll(Sort.by("nom")));
        model.addAttribute("client", client);
        model.addAttribute("editMode", editMode);
    }

    @PostMapping
    public String save(@ModelAttribute Client client) {
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @ModelAttribute Client formClient) {
        Client client = clientRepository.findById(id).orElseThrow();
        client.setNom(formClient.getNom());
        client.setContact(formClient.getContact());
        clientRepository.save(client);
        return "redirect:/clients";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        clientRepository.deleteById(id);
        return "redirect:/clients";
    }
}
