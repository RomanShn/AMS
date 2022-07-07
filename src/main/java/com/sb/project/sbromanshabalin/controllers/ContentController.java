package com.sb.project.sbromanshabalin.controllers;

import com.sb.project.sbromanshabalin.dtos.ContentDto;
import com.sb.project.sbromanshabalin.dtos.InputContentDto;
import com.sb.project.sbromanshabalin.entities.Content;
import com.sb.project.sbromanshabalin.services.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/content")
public class ContentController {
    private final ContentService contentService;

    @Autowired
    public ContentController(ContentService contentService) {
        this.contentService = contentService;
    }

    /**
     * Метод создающий новые записи о контенте в БД.
     */
    @PostMapping
    public void saveContent(@RequestBody InputContentDto content) {
        contentService.saveContent(content);
    }
}
