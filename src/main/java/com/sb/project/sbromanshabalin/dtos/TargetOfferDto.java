package com.sb.project.sbromanshabalin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Компания (отправка)происходит по количеству страниц {@link com.sb.project.sbromanshabalin.entities.Page}
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TargetOfferDto
{
    private String page;
    private Date startDate;
    private Date endDate;
    private List<TargetDto> target;
}
// Select p.pageName,  from page p
