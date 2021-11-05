package com.zeuschiu.generation.javaserver.modules;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemoInterface extends CrudRepository<Memo, Long> {
    List<Memo> getMemos();
    Memo findById(long id);
    void addMemo(Memo memo);
}
