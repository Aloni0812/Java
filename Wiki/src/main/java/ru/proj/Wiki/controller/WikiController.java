package ru.proj.Wiki.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.proj.Wiki.model.Wiki;
import ru.proj.Wiki.servise.WikiServise;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Wiki")
@AllArgsConstructor
public class WikiController {
    private final WikiServise service;

    @GetMapping
    public List<Wiki> findAllWIKI() {
        return service.findAllWiki();
    }

    @PostMapping("save_wiki")
    public String saveStudent(@RequestBody Wiki wiki) {
        service.saveWiki(wiki);
        return "Wiki successfully saved";
    }

    @GetMapping("/{request}")
    public Wiki findByRequest(@PathVariable String request) {
        return service.findByRequest(request);
    }

    @PutMapping("update_wiki")
    public Wiki updateWiki(@RequestBody Wiki wiki) {
        return service.updateWiki(wiki);
    }

    @DeleteMapping("delete_Wiki/{request}")
    public void deleteWiki(@PathVariable String request) {
        service.deleteWiki(request);
    }
}

