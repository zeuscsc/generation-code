package com.zeuschiu.generation.javaserver.controllers;

import com.zeuschiu.generation.javaserver.modules.Memo;
import com.zeuschiu.generation.javaserver.modules.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/memos")
public class MemoController {
    @Autowired
    private MemoRepository memoRepository;
    @PostMapping(path="/add")
    public @ResponseBody
    MemoResponse MemoResponse (@RequestBody Map<String,String> json) {
        String content=json.get("content");
        Memo n = new Memo(content);
        memoRepository.save(n);
        return new MemoResponse(true);
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Memo> getAllMemos() {
        return memoRepository.findAll();
    }
}

