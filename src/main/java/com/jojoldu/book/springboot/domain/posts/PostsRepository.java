package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DAO 와 같다고 할 수 있는 것이 Repository
//Entity 클래스와 Repository 는 함께 위치해야함.
public interface PostsRepository extends JpaRepository<Posts,Long> { //JpaRepository<Entity 클래스, PK 타입>



}
