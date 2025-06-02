package com.example.vamm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document(collection = "contracts")
public class Contract {
    @Id
    private String id;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
    private List<String> assetIds;

    public Contract() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }

    public LocalDate getEndDate() { return endDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getAssetIds() { return assetIds; }
    public void setAssetIds(List<String> assetIds) { this.assetIds = assetIds; }
}
