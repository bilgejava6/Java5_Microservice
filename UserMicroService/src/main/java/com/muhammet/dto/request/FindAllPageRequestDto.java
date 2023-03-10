package com.muhammet.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FindAllPageRequestDto {
    String direction;
    Integer currentPage;
    int pageSize;
    String sortingParameter;
}
