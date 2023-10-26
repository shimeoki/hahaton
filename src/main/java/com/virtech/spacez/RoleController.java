package com.virtech.spacez;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(path="/role")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(path="/add")
    public @ResponseBody String addRole(@RequestParam String name) {
        Role role = new Role();
        role.setName(name);
        roleRepository.save(role);
        return "201";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Role> getRoles() {
        return roleRepository.findAll();
    }
}