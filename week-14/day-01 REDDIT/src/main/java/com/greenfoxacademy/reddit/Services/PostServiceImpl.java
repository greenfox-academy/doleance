package com.greenfoxacademy.reddit.Services;

import com.greenfoxacademy.reddit.Models.Post;
import com.greenfoxacademy.reddit.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    PostRepository postRepository;


    @Override
    public List<Post> getAllPosts() {
        return (List<Post>) postRepository.findAll();
    }

    @Override
    public Post getPostById(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public void addNewPost(Post postToSave) {
        postRepository.save(postToSave);
    }

    @Override
    public void increaseScore(Post postToUpvote) {
        Post postToSave = postToUpvote;
        postToUpvote.incrementScore();
        postRepository.save(postToSave);
    }

    @Override
    public void decreaseScore(Post postToDownvote) {
        Post postToSave = postToDownvote;
        postToSave.decrementScore();
        postRepository.save(postToSave);
    }

    @Override
    public void deletePost(Post postToDelete) {
        postRepository.delete(postToDelete);
    }

    @Override
    public void updatePost(Post postToUpdate) {
        Post oldPost = postRepository.findById(postToUpdate.getId()).get();
        postToUpdate.setLastUpdated();
        postToUpdate.setScore(oldPost.getScore());
        postToUpdate.setTimestamp(oldPost.readTimestamp());
        postToUpdate.setOwner(oldPost.getOwner());
        postRepository.save(postToUpdate);
    }
}
