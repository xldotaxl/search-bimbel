package it.aldi.app.controller.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SearchBimbelDto {

    private String education;
    private Long provinceId;
    private Long cityId;

    private SearchBimbelDto(String education, Long provinceId, Long cityId) {
        this.education = education;
        this.provinceId = provinceId;
        this.cityId = cityId;
    }
}
