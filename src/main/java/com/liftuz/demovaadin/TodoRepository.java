package com.liftuz.demovaadin;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RawinNgamloet on 6/5/2017.
 */
public interface TodoRepository extends JpaRepository<Todo, Long> {

}
