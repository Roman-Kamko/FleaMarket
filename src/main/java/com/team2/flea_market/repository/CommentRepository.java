package com.team2.flea_market.repository;

import com.team2.flea_market.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {

    List <Comment> findAllByAd_Id (Integer id);

}
