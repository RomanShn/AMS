package com.sb.project.sbromanshabalin.services;

import com.sb.project.sbromanshabalin.dtos.ContentDto;
import com.sb.project.sbromanshabalin.dtos.InputContentDto;
import com.sb.project.sbromanshabalin.entities.Content;

import java.util.List;

public interface ContentService {
    /**
     * Метод сохранения сущности content
     */
    void saveContent(InputContentDto contentDto);
}
