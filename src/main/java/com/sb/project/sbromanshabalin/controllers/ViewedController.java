package com.sb.project.sbromanshabalin.controllers;

import com.sb.project.sbromanshabalin.dtos.InputViewedDto;
import com.sb.project.sbromanshabalin.dtos.ViewedDto;
import com.sb.project.sbromanshabalin.entities.Viewed;
import com.sb.project.sbromanshabalin.services.ViewedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/viewed")
public class ViewedController {
    private final ViewedService viewedService;

    @Autowired
    public ViewedController(ViewedService viewedService) {
        this.viewedService = viewedService;
    }

    /**
     * Метод создающий новые записи о просмотрах в БД.
     */
    @PostMapping
    public void saveViewed(@RequestBody InputViewedDto viewed) {
        viewedService.saveViewed(viewed);
    }
}
