package com.yj.likelion.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("post")
public class PostController {
    private static final Logger logger = LoggerFactory.getLogger(PostController.class);
    private final List<PostDto> postList; // final 선언했으니 초기화해줘야 빨간줄 없

    public PostController(){
        postList=new ArrayList<>(); // 위는 list 여기는 arraylist 쓰는 이유 이전 영상에 있음
        // 아마 interface, 구현체 ~~
    }

    @PostMapping("create")
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
        this.postList.add(postDto);
    }
}