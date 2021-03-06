package com.greenfoxacademy.reddit.Services;

import com.greenfoxacademy.reddit.Models.AmendedPost;
import com.greenfoxacademy.reddit.Models.Post;
import com.greenfoxacademy.reddit.Models.User;
import com.greenfoxacademy.reddit.Models.Vote;
import com.greenfoxacademy.reddit.Repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.stereotype.Service;

import java.lang.annotation.Annotation;

@Service
public class VoteService implements JsonPath {

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    PostServiceImpl postService;

    @Autowired
    UserServiceImpl userService;

    public void voting(Vote vote) {
        voteRepository.save(vote);
    }

    public Vote getVoteByUserAndPost(String username, Long postId) {
        return voteRepository.findByUserAndPost(userService.getUserByUsername(username), postService.getPostById(postId));
    }

    public void cancelVote(Vote voteToDelete) {
        if (voteToDelete.isItUpVote()) {
            postService.decreaseScore(voteToDelete.getPost());
        } else {
            postService.increaseScore(voteToDelete.getPost());
        }
        voteRepository.delete(voteToDelete);
    }

    public AmendedPost getPersonalVoteToo(User user, Post post) {
        AmendedPost amendedPost;
        if (voteRepository.findByUserAndPost(user, post) == null) {
            amendedPost = new AmendedPost(post, null);
        } else {
            boolean personalVote = voteRepository.findByUserAndPost(user, post).isItUpVote();
            amendedPost = new AmendedPost(post, personalVote);
        }
        return amendedPost;
    }

    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
