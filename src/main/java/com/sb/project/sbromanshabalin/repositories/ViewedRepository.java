package com.sb.project.sbromanshabalin.repositories;

import com.sb.project.sbromanshabalin.entities.Viewed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ViewedRepository extends JpaRepository<Viewed, UUID> {
    /**
     * Метод, получения количества просмотров по Id юзера.
     */
    @Query(value = "select Cast(v.id as varchar) from viewed v " +
            "where v.user_id = ?1 ;",
            nativeQuery = true)
    List<UUID> getContetntIdsFromViewedByUserId(UUID userId);
}
