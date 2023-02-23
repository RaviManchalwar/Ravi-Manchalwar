package com.read.textfile.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.read.textfile.entity.Person;
import com.read.textfile.entity.PersonId;
import com.read.textfile.repository.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private int serialNumber = 0;

    public void savePersonsFromFile(MultipartFile file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                savePerson(line);
            }
        }
    }

    private void savePerson(String line) {
        String[] parts = line.split("-");
        String dobStr = parts[0];
        String name = parts[1];
        int yearOfService = Integer.parseInt(parts[2]);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyy");
        LocalDate dob = LocalDate.parse(dobStr, formatter);

        Person person = new Person();
        person.setPersonId(new PersonId(dob, serialNumber()));
        person.setName(name);
        person.setYearOfService(yearOfService);

        personRepository.save(person);

        
    }
    
    public List<Person> listAllPersons() {
        return personRepository.findAll();
    }

	private int serialNumber() {
		// TODO Auto-generated method stub
		return serialNumber++;
	}
}



