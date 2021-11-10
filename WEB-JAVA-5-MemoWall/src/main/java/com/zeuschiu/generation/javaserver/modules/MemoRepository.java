package com.zeuschiu.generation.javaserver.modules;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends CrudRepository<Memo, Long> {
}
