package javastart28zadaniezajecia.demo.repository;

import javastart28zadaniezajecia.demo.model.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {


    @Override
    Community getOne(Long aLong);
}
