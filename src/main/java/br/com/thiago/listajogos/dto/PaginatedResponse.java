package br.com.thiago.listajogos.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PaginatedResponse<T> {

    @JsonIgnore
    private Integer page;
    @JsonIgnore
    private Integer size;
    @JsonIgnore
    private Long totalElements;
    @JsonIgnore
    private Long totalPage;
    @JsonIgnore
    private List<T> results;
    @JsonIgnore
    private String resultsFieldName;

    @JsonAnyGetter
    public Map<String, Object> any() {
        final var map = new LinkedHashMap<String, Object>();
        map.put(getResultsFieldName(), getResults());
        map.put("page", getPage());
        map.put("size", getSize());
        map.put("total_elements", getTotalElements());
        map.put("total_page", getTotalPage());
        return map;
    }

    @SuppressWarnings("unchecked")
    @JsonAnySetter
    public void set(String name, Object value) {
        if ("results".equalsIgnoreCase(name) || "orders".equalsIgnoreCase(name) || "courtesies".equalsIgnoreCase(name)
                || "contracts".equalsIgnoreCase(name)) {
            setResults((List<T>) value);
        }
    }

}