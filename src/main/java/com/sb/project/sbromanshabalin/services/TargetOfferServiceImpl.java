package com.sb.project.sbromanshabalin.services;

import com.sb.project.sbromanshabalin.dtos.OfferDto;
import com.sb.project.sbromanshabalin.dtos.TargetDto;
import com.sb.project.sbromanshabalin.dtos.TargetOfferDto;
import com.sb.project.sbromanshabalin.repositories.ContentRepository;
import com.sb.project.sbromanshabalin.repositories.PageRepository;
import com.sb.project.sbromanshabalin.repositories.UsersRepository;
import com.sb.project.sbromanshabalin.repositories.ViewedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Collectors;

@Service
public class TargetOfferServiceImpl implements TargetOfferService
{
    private final PageRepository pageRepository;
    private final UsersRepository usersRepository;
    private final ContentRepository contentRepository;
    private final ViewedRepository viewedRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public TargetOfferServiceImpl(PageRepository pageRepository,
                                  UsersRepository usersRepository,
                                  ContentRepository contentRepository,
                                  ViewedRepository viewedRepository,
                                  RestTemplate restTemplate)
    {
        this.pageRepository = pageRepository;
        this.usersRepository = usersRepository;
        this.contentRepository = contentRepository;
        this.viewedRepository = viewedRepository;
        this.restTemplate = restTemplate;
    }

    /**
     * Метод, имитирующий отправку раз в сутки информацию от CDS.
     */
    @Scheduled(fixedRate = 86400000)
    public void sentTargetOfferEveryDay()
    {
        // получили уникальный список номеров страниц
        var pageNames = pageRepository.findDistinctNames();
        pageNames.forEach(pageName ->
        {
            var getUsers = usersRepository.findAll();
            ArrayList<TargetDto> targetList = new ArrayList<>();
            getUsers.forEach(users ->
            {
                var getAllContentsByPage = contentRepository.getAllContentsByPage(pageName);
                var getContetntIdsFromViewedByUserId = viewedRepository.getContetntIdsFromViewedByUserId(users.getId());
                getAllContentsByPage.removeAll(getContetntIdsFromViewedByUserId);
                var listOffers = getAllContentsByPage.stream().map(contentId ->
                                OfferDto.builder()
                                        .contentGuid(contentId)
                                        .priority("1")
                                        .build())
                        .collect(Collectors.toList());

                var targetDto = TargetDto.builder()
                        .userGuid(users.getId())
                        .offers(listOffers)
                        .build();
                targetList.add(targetDto);
            });
            var startDay = new Date();
            var targetOfferDto = TargetOfferDto.builder()
                    .page(pageName)
                    .target(targetList)
                    .startDate(startDay)
                    .endDate(new Date(startDay.getTime() + (1000 * 60 * 60 * 24)))
                    .build();

            sentTargetOffer(targetOfferDto);
        });
    }

    private void sentTargetOffer(TargetOfferDto targetOfferDto)
    {
        var url = UriComponentsBuilder.fromUri(URI.create("http://localhost:8080")).pathSegment("save").build().toUri();
        restTemplate.postForEntity(url, targetOfferDto, Void.class);
    }
}





