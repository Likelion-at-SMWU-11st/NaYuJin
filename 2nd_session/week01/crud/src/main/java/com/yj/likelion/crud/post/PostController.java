package com.yj.likelion.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("read-all")
    public List<PostDto> readPostAll(){
        logger.info("in read all");
        return this.postList;
    }

    @GetMapping("read-one")
    public PostDto readPostOne(@RequestParam("id") int id){
        logger.info("in read one");
        return this.postList.get(id);
    }

    @PostMapping("update")
    public void updatePost(
            @RequestParam("id") int id,
            @RequestBody PostDto postDto
    ){
        PostDto targetPost = this.postList.get(id);
        if(postDto.getTitle()!=null){
            targetPost.setTitle(postDto.getTitle());
        }
        if(postDto.getContent()!=null){
            targetPost.setContent(postDto.getContent());
        }
        this.postList.set(id, targetPost);
    }
}
