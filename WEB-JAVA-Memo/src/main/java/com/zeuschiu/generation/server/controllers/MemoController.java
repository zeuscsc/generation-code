package com.zeuschiu.generation.server.controllers;

import com.zeuschiu.generation.server.models.Memo;
import com.zeuschiu.generation.server.models.MemoRepository;
import com.zeuschiu.generation.server.services.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/memos")
@CrossOrigin("*")
public class MemoController {
    private final MemoService memoService;

    public MemoController(@Autowired MemoService memoService){
        this.memoService=memoService;
    }

    @PostMapping("/add")
    public @ResponseBody
    Map<String,String> addMemo(@RequestBody Map<String,String > json){
        String content=json.get("content");
        memoService.addMemo(content);
        HashMap<String,String> response=new HashMap<>();
        response.put("success","true");
        return response;
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<Memo> getAllMemos(){
        return memoService.getMemos();
    }
}
