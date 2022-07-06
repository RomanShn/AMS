package com.sb.project.sbromanshabalin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TargetDto
{
    private UUID userGuid;
    private List<OfferDto> offers;
}
