package com.sb.project.sbromanshabalin.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ViewedDto
{
    private UUID userGuid;
    private UUID contentGuid;
}
