package org.springframework.samples.petclinic.feeding;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface FeedingRepository extends CrudRepository<Feeding, Integer> {
    List<Feeding> findAll();
    @Query("SELECT ft FROM FeedingType ft")
    List<FeedingType> findAllFeedingTypes();
    @Query("SELECT ft FROM FeedingType ft WHERE ft.name=?1")
    FeedingType findFeedingType(String name);
    @Query("SELECT ft FROM FeedingType ft WHERE ft.id=?1")
    FeedingType findFeedingTypeById(Integer id);
    Optional<Feeding> findById(int id);
    Feeding save(Feeding p);
}
