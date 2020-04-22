package ua.lviv.ai.oop_labs.second.dataaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.ai.oop_labs.second.model.Kit;

import java.util.List;

@Repository
public interface IKitRepository extends JpaRepository<Kit, Integer> {

    List<Kit> findAllByName(String name);

    List<Kit> findAllByProducer(String producer);

    List<Kit> findAllByPriceLessThanEqual(Double price);

}