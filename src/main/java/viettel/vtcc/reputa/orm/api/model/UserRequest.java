package viettel.vtcc.reputa.orm.api.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;


@RedisHash("UserRequest")
@Data
public class UserRequest {
//    @Id
    private String id;
    private String username;
    private String endpoint;
    private long count;
}
