package com.zeuschiu.generation.javaserver.controllers;

import com.zeuschiu.generation.javaserver.modules.Memo;
import com.zeuschiu.generation.javaserver.modules.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path="/memos")
public class MemoController {
    @Autowired
    private MemoRepository memoRepository;
    @PostMapping(path="/add")
    public @ResponseBody Map<String,String> addMemo (@RequestBody Map<String,String> json) {
        String content=json.get("content");
        Memo n = new Memo(content);
        memoRepository.save(n);
        HashMap<String, String> map = new HashMap<>();
        map.put("success","true");
        return map;
    }
    @GetMapping(path="/all")
    public @ResponseBody Iterable<Memo> getAllMemos() {
        return memoRepository.findAll();
    }
}
