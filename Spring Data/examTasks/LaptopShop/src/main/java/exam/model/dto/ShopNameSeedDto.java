package exam.model.dto;

import com.google.gson.annotations.Expose;

public class ShopNameSeedDto {
    @Expose
    private String name;

    public ShopNameSeedDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
