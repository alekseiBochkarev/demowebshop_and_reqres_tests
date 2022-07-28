package webshopandreqres.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ListUserData {
    @JsonProperty("id")
    private Integer idList;
    @JsonProperty("email")
    private String emailList;
    @JsonProperty("first_name")
    private String firstNameList;
    @JsonProperty("last_name")
    private String lastNameList;
    @JsonProperty("avatar")
    private String avatarList;
}
