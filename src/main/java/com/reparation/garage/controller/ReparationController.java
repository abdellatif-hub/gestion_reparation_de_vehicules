package com.reparation.garage.controller;

import com.reparation.garage.model.Reparation;
import com.reparation.garage.model.Vehicule;
import com.reparation.garage.repository.ReparationRepository;
import com.reparation.garage.repository.VehiculeRepository;
import java.time.LocalDate;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reparations")
public class ReparationController {

    private final ReparationRepository reparationRepository;
    private final VehiculeRepository vehiculeRepository;

    public ReparationController(ReparationRepository reparationRepository, VehiculeRepository vehiculeRepository) {
        this.reparationRepository = reparationRepository;
        this.vehiculeRepository = vehiculeRepository;
    }

    @GetMapping
    public String list(Model model) {
        preparePage(model, new Reparation(), false);
        return "reparations";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Reparation reparation = reparationRepository.findById(id).orElseThrow();
        preparePage(model, reparation, true);
        return "reparations";
    }

    private void preparePage(Model model, Reparation reparation, boolean editMode) {
        model.addAttribute("reparations", reparationRepository.findAll(Sort.by(Sort.Direction.DESC, "dateReparation")));
        model.addAttribute("vehicules", vehiculeRepository.findAll(Sort.by("marque")));
        model.addAttribute("reparationForm", reparation);
        model.addAttribute("editMode", editMode);
    }

    @PostMapping
    public String save(
            @RequestParam Long vehiculeId,
            @RequestParam String description,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateReparation) {

        Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElseThrow();

        Reparation reparation = new Reparation();
        reparation.setVehicule(vehicule);
        reparation.setDescription(description);
        reparation.setDateReparation(dateReparation);

        reparationRepository.save(reparation);
        return "redirect:/reparations";
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable Long id,
            @RequestParam Long vehiculeId,
            @RequestParam String description,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateReparation) {

        Vehicule vehicule = vehiculeRepository.findById(vehiculeId).orElseThrow();
        Reparation reparation = reparationRepository.findById(id).orElseThrow();
        reparation.setVehicule(vehicule);
        reparation.setDescription(description);
        reparation.setDateReparation(dateReparation);

        reparationRepository.save(reparation);
        return "redirect:/reparations";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        reparationRepository.deleteById(id);
        return "redirect:/reparations";
    }
}
