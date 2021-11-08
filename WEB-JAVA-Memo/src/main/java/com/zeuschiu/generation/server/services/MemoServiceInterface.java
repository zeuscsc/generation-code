package com.zeuschiu.generation.server.services;

import com.zeuschiu.generation.server.models.Memo;

public interface MemoServiceInterface {
    void addMemo(String content);
    Iterable<Memo> getMemos();
}
