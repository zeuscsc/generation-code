package com.zeuschiu.generation.server.controllers;

import com.zeuschiu.generation.server.models.Memo;
import com.zeuschiu.generation.server.models.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/memos")
public class MemoController {
    @Autowired
    private MemoRepository memoRepository;
    @PostMapping("/add")
    public @ResponseBody
    Map<String,String> addMemo(@RequestBody Map<String,String > json){
        String content=json.get("content");
        Memo memo=new Memo(content);
        memoRepository.save(memo);
        HashMap<String,String> response=new HashMap<>();
        response.put("success","true");
        return response;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Memo> getAllMemos(){
        return memoRepository.findAll();
    }
}
