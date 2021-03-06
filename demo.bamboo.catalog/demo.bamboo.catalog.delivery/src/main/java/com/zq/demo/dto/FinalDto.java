package com.zq.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties
public class FinalDto {

    private String key;
    private List<String> values;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("FinalDto{");
        sb.append("key='").append(key).append('\'');
        sb.append(", values=").append(String.join(", ", values));
        sb.append('}');
        return sb.toString();
    }
}
