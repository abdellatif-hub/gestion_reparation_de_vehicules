package com.reparation.garage.controller;

import com.reparation.garage.model.Client;
import com.reparation.garage.model.Vehicule;
import com.reparation.garage.repository.ClientRepository;
import com.reparation.garage.repository.VehiculeRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/vehicules")
public class VehiculeController {

    private final VehiculeRepository vehiculeRepository;
    private final ClientRepository clientRepository;

    public VehiculeController(VehiculeRepository vehiculeRepository, ClientRepository clientRepository) {
        this.vehiculeRepository = vehiculeRepository;
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public String list(Model model) {
        preparePage(model, new Vehicule(), false);
        return "vehicules";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow();
        preparePage(model, vehicule, true);
        return "vehicules";
    }

    private void preparePage(Model model, Vehicule vehicule, boolean editMode) {
        model.addAttribute("vehicules", vehiculeRepository.findAll(Sort.by("marque")));
        model.addAttribute("clients", clientRepository.findAll(Sort.by("nom")));
        model.addAttribute("vehiculeForm", vehicule);
        model.addAttribute("editMode", editMode);
    }

    @PostMapping
    public String save(@RequestParam String marque, @RequestParam String modele, @RequestParam Long clientId) {
        Client client = clientRepository.findById(clientId).orElseThrow();

        Vehicule vehicule = new Vehicule();
        vehicule.setMarque(marque);
        vehicule.setModele(modele);
        vehicule.setClient(client);

        vehiculeRepository.save(vehicule);
        return "redirect:/vehicules";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            @RequestParam String marque,
            @RequestParam String modele,
            @RequestParam Long clientId) {

        Client client = clientRepository.findById(clientId).orElseThrow();
        Vehicule vehicule = vehiculeRepository.findById(id).orElseThrow();
        vehicule.setMarque(marque);
        vehicule.setModele(modele);
        vehicule.setClient(client);

        vehiculeRepository.save(vehicule);
        return "redirect:/vehicules";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        vehiculeRepository.deleteById(id);
        return "redirect:/vehicules";
    }
}
