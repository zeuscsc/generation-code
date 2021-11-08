package com.zeuschiu.generation.javaserver.modules;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Memo, Long> {
}
