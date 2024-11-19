package com.inditex.hiring.domain.models.vo;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductPartNumber {
    final String partNumber;

    public ProductPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getPartNumber() {return this.partNumber;}

    public Map<String, String> splitProductPartNumber() {

        Map<String, String> partNumberDetails = new HashMap<>();
                partNumberDetails.put("talla", partNumber.substring(0, 2));
                partNumberDetails.put("modelo", partNumber.substring(3, 6));
                partNumberDetails.put("calidad", partNumber.substring(6, 9));
                return partNumberDetails;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductPartNumber that = (ProductPartNumber) o;
        return Objects.equals(partNumber, that.partNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(partNumber);
    }
}



