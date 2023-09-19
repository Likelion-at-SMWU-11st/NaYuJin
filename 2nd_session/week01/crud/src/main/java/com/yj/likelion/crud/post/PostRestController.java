package com.yj.likelion.crud.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Post")
public class PostRestController {
    private static final Logger logger= LoggerFactory.getLogger(PostRestController.class);
//    private final List<PostDto> postList;
    private final PostService postService;


    public PostRestController(@Autowired PostService postService){
        this.postService=postService;
    }

    // 1 createPost
    // http://localhost:8080/post
    // POST /post
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createPost(@RequestBody PostDto postDto){
        logger.info(postDto.toString());
//        this.postList.add(postDto);
        this.postService.createPost(postDto);

    }

    // 2 get
    // http://localhost:8080/post
    // GET /post
    @GetMapping()
    public List<PostDto> readPostAll(){
        logger.info("iin read post all");
        return this.postService.readPostAll();
    }

    // http://localhost:8080/post
    // POST /post
    // GET /post
    // GET /post/0
    // GET /post?id=0
    // PUT /post/0
    // PUT /post?id=0
    // DELETE /post/1

    @GetMapping("{id}")
    public PostDto readPost(@PathVariable("id") int id){
        logger.info("in read post");
        return this.postService.readPost(id);
    }

    // 3 update
    // PUT /post/0
    // PUT /post?id=0
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updatePost(
            @PathVariable("id") int id,
            @RequestBody PostDto postDto
    ){
        this.postService.updatePost(id,postDto);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deletePost(@PathVariable("id") int id){
        this.postService.deletePost(id);
    }

}
