package viettel.vtcc.reputa.orm.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
public class UserToken {
    @JsonProperty("user_id")
    @Builder.Default
    private int userId = -1;

    @JsonProperty("token")
    private String token;
}
