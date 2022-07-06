package com.sb.project.sbromanshabalin.services;

import com.sb.project.sbromanshabalin.dtos.InputViewedDto;
import com.sb.project.sbromanshabalin.entities.Content;
import com.sb.project.sbromanshabalin.entities.Users;
import com.sb.project.sbromanshabalin.entities.Viewed;
import com.sb.project.sbromanshabalin.repositories.UsersRepository;
import com.sb.project.sbromanshabalin.repositories.ViewedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewedServiceImpl implements ViewedService
{
    private final ViewedRepository viewedRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public ViewedServiceImpl(ViewedRepository viewedRepository,
                             UsersRepository usersRepository)
    {
        this.viewedRepository = viewedRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public void saveViewed(InputViewedDto inputViewedDto)
    {
        inputViewedDto.getViewed().forEach(viewedDto ->
        {
            var users = new Users();
            users.setId(viewedDto.getUserGuid());
            var content = new Content();
            content.setId(viewedDto.getContentGuid());
            var viewed = Viewed.builder()
                    .users(users)
                    .content(content)
                    .build();

            usersRepository.save(users);
            viewedRepository.save(viewed);
        });
    }
}
