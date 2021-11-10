package com.zeuschiu.generation.javaserver.modules;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserDb, Long> {
    @Query(value="SELECT * FROM memos_wall.users WHERE username=:username",nativeQuery = true)
    UserDb findByUsernameNative(@Param("username")String username);
    UserDb findByUsername(String username);
}
