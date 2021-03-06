package tk.xmfaly.zhihu_server.repository;

import org.springframework.data.repository.CrudRepository;
import tk.xmfaly.zhihu_server.entity.Equipment;

public interface EquipmentRepository extends CrudRepository<Equipment,Integer>{
    Equipment findById(String id);
    Equipment findFirstByUserInfoId(int id);
}
