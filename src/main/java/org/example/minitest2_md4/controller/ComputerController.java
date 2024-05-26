package org.example.minitest2_md4.controller;


import org.example.minitest2_md4.dto.ComputerDTO;
import org.example.minitest2_md4.exception.DuplicateCodeException;
import org.example.minitest2_md4.exception.ResourceNotFoundException;
import org.example.minitest2_md4.model.Computer;
import org.example.minitest2_md4.model.TypeComputer;
import org.example.minitest2_md4.service.IComputerService;
import org.example.minitest2_md4.service.ITypeComputerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/")
public class ComputerController {
    @Autowired
    private IComputerService computerService;
    @Autowired
    private ITypeComputerService typeComputerService;
    @GetMapping("")
    public String showAll(Model model, @RequestParam(required = false, defaultValue = "") String search,
                              @RequestParam(required = false, defaultValue = "0") int page) {
        Pageable pageable = PageRequest.of(page,2);
        Page<Computer> computers = computerService.findComputerByComputerNameContaining(search, pageable);
        model.addAttribute("search", search);
        model.addAttribute("computerPage", computers);
        return "/home";
    }
    @GetMapping("/add")
    public String showFormCreate(Model model){
        ComputerDTO computerDTO = new ComputerDTO();
        List<TypeComputer> typeComputerList=typeComputerService.findAll();
        model.addAttribute("computerDTO",computerDTO);
        model.addAttribute("typeComputerList",typeComputerList);
        return "/add";
    }
    @PostMapping("/add")
    public String addComputer(@Valid @ModelAttribute("computerDTO") ComputerDTO computerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) throws DuplicateCodeException {
        if (bindingResult.hasFieldErrors()) {
            List<TypeComputer> typeComputerList = typeComputerService.findAll();
            model.addAttribute("typeComputerList", typeComputerList);
            return "/add";
        } else {
            Computer computer = new Computer();
            BeanUtils.copyProperties(computerDTO, computer);

                computerService.save(computer);
                redirectAttributes.addFlashAttribute("status", 1);
                return "redirect:/";

        }
    }
    @GetMapping("/edit/{id}")
    public String showFormEdit(Model model, @PathVariable Long id) throws ResourceNotFoundException{
        Computer computer = new Computer();
        ComputerDTO computerDTO = new ComputerDTO();
        computer = computerService.findById(id);
        BeanUtils.copyProperties(computer, computerDTO);
        List<TypeComputer> typeComputerList = typeComputerService.findAll();
        model.addAttribute("computerDTO", computerDTO);
        model.addAttribute("typeComputerList", typeComputerList);
        return "/edit";
    }
    @PostMapping("/edit")
    public String editProduct(@Valid @ModelAttribute("computerDTO") ComputerDTO computerDTO, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) throws DuplicateCodeException {
        if (bindingResult.hasFieldErrors()) {
            List<TypeComputer> typeComputerList = typeComputerService.findAll();
            model.addAttribute("typeComputerList", typeComputerList);
            return "/edit";
        } else {
            Computer computer = new Computer();
            BeanUtils.copyProperties(computerDTO, computer);

            computerService.save(computer);
                redirectAttributes.addFlashAttribute("status", 2);
                return "redirect:/";

        }
    }
    @GetMapping("/xoa")
    public String deleteProduct(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) throws ResourceNotFoundException {
        computerService.delete(id);
        redirectAttributes.addFlashAttribute("status", 3);
        return "redirect:/";
    }




}
