package com.reverseosmosis.mouseion.repository;

import com.reverseosmosis.mouseion.model.Words;
import java.util.List;
// import java.util.Optional;
// import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface WordsRepo {

    List<Words> findByActiveTrue();

  // Derived Query - Good for simple, potentially costly for complicated
  // situations
  // Optional<Room> findByRoomBuildingAndRoomRoomNumber(Building building,
  // String roomNumber);

//   @Query(
//       value = "SELECT * from Room r WHERE r.Building_ID = ?1 and r.Room_Number = ?2",
//       nativeQuery = true)
//   Optional<Words> findByBuildingIdAndRoomNumber(Integer buildingId, String roomNumber);
}