package ru.vsu.L8.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.L8.db.Template;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void getAll() {
        System.out.println(userRepository.findAll());
    }
    @Transactional
    public void deleteById(int id) {
        userRepository.deleteById(id);
    }
    @Transactional
    public void insert(Template template) {
        userRepository.save(template);
    }
    @Transactional
    public Template update(Integer id, String name) {
        Optional<Template> tempOpt = userRepository.findById(id);

        if(tempOpt.isEmpty()) {
            throw new RuntimeException("Not found with id: " + id);
        }

        Template template = tempOpt.get();
        template.setName(name);

        return userRepository.save(template);
    }
    @Transactional
    public void addNewName(String name){
        Template template = new Template();
        template.setName(name);

        userRepository.save(template);
    }
}
