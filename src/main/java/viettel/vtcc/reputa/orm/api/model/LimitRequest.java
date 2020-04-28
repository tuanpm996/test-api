package viettel.vtcc.reputa.orm.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("UserRequest")
@Data
@AllArgsConstructor
public class LimitRequest {
    @Id
    private String uri;
    private long time;
}
