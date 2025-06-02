package com.example.vamm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Document(collection = "assets")
public class Asset {
    @Id
    private String id;
    private String name;
    private String type;
    private String description;
    private BigDecimal price;
    private LocalDate eolDate;
    private int depreciationYears;
    private String taxCategory;
    private List<String> contractIds;

    public Asset() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public LocalDate getEolDate() { return eolDate; }
    public void setEolDate(LocalDate eolDate) { this.eolDate = eolDate; }

    public int getDepreciationYears() { return depreciationYears; }
    public void setDepreciationYears(int depreciationYears) { this.depreciationYears = depreciationYears; }

    public String getTaxCategory() { return taxCategory; }
    public void setTaxCategory(String taxCategory) { this.taxCategory = taxCategory; }

    public List<String> getContractIds() { return contractIds; }
    public void setContractIds(List<String> contractIds) { this.contractIds = contractIds; }
}
