package com.technews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository

public interface Vote extends JpaRepository<Vote,Integer> {
    /**@Query, right above the method we just declared. This annotation will take a single argument,
     * which will be the specific query we want to use ("SELECT count(*) FROM Vote v where v.postId = :id"*/
    @Query("SELECT count(*) FROM Vote where v.postId = :id")
    int countVotesByPostId(@Param("id") Integer id);
}
