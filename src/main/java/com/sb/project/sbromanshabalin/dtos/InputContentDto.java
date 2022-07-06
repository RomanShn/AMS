package com.sb.project.sbromanshabalin.dtos;

import com.sb.project.sbromanshabalin.entities.Content;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InputContentDto
{
    private List<ContentDto> content;
}
