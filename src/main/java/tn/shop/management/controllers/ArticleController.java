package tn.shop.management.controllers;

import tn.shop.management.entities.Article;
import tn.shop.management.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/{id}")
    public Optional<Article> getArticleById(@PathVariable int id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Article addArticle(@RequestBody Article article) {
        return articleService.saveArticle(article);
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable int id, @RequestBody Article updatedArticle) {
        return articleService.updateArticle(id, updatedArticle);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable int id) {
        articleService.deleteArticle(id);
    }
}
