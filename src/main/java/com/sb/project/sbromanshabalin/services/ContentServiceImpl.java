package com.sb.project.sbromanshabalin.services;

import com.sb.project.sbromanshabalin.dtos.InputContentDto;
import com.sb.project.sbromanshabalin.entities.Content;
import com.sb.project.sbromanshabalin.entities.Page;
import com.sb.project.sbromanshabalin.repositories.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ContentServiceImpl implements ContentService {
    private final ContentRepository contentRepository;

    @Autowired
    public ContentServiceImpl(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    /**
     * Метод добавляющий записи в репозиторий контента.
     */
    @Override
    public void saveContent(InputContentDto inputContentDto) {
        inputContentDto.getContent().parallelStream().forEach(contentDto ->
        {
            var pages = contentDto.getPages().stream()
                    .map(page -> Page.builder()
                            .name(page.getPageName())
                            .build())
                    .collect(Collectors.toList());
            var content = Content.builder()
                    .id(contentDto.getContentGuid())
                    .pages(pages)
                    .build();
            contentRepository.save(content);
        });
    }
}
