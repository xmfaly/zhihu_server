package tk.xmfaly.zhihu_server.heartbeat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class HeartRateRepositoryImpl implements HeartRateRepository{
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void saveHeartRate(HeartRate heartRate) {mongoTemplate.save(heartRate);}

    @Override
    public List<HeartRate> qureryHeartRatebyId(int deviceid) {
        //Query query = new Query();
        Query query = new Query();
        //Query query = new Query();
        //query.addCriteria(Criteria.where("age").lt(50).gt(20));
        //List<User> users = mongoTemplate.find(query,User.class);
        query.addCriteria(Criteria.where("deviceid").is(deviceid));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"timestamp")));
        List<HeartRate> res = mongoTemplate.find(query,HeartRate.class);
        return res;
    }
}
