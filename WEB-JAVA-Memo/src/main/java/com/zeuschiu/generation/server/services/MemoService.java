package com.zeuschiu.generation.server.services;

import com.zeuschiu.generation.server.models.Memo;
import com.zeuschiu.generation.server.models.MemoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemoService implements MemoServiceInterface {
    private final MemoRepository memoRepository;

    public MemoService(MemoRepository memoRepository){
        this.memoRepository=memoRepository;
    }

    @Override
    public void addMemo(String content) {
        Memo memo=new Memo(content);
        memoRepository.save(memo);
    }

    @Override
    public Iterable<Memo> getMemos() {
        return memoRepository.findAll();
    }
}