package ru.netology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.exception.NotFoundException;
import ru.netology.model.Post;
import ru.netology.repository.PostRepository;

import java.util.Collection;


public class PostService {
    private final PostRepository repository;


    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public Collection<Post> all() {
        return repository.all();
    }

    public Post getById(long id) {
        try {
            return repository.getById(id).orElseThrow(NotFoundException::new);
        } catch (NotFoundException e) {
            return null;
        }
    }

    public Post save(Post post) {
        return repository.save(post);
    }

    public void removeById(long id) {
        repository.removeById(id);
    }
}
