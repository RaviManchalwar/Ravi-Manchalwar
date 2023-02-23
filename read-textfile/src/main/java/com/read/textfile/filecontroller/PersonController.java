package com.read.textfile.filecontroller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.read.textfile.entity.Person;
import com.read.textfile.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        model.addAttribute("person", new Person());
        return "upload";
    }

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            personService.savePersonsFromFile(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/person/list";
    }

    @GetMapping("/list")
    public String listPersons(Model model) {
        List<Person> persons = personService.listAllPersons();
        model.addAttribute("persons", persons);
        return "list";
    }
}

