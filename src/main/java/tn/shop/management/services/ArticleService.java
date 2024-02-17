package tn.shop.management.services;

import tn.shop.management.entities.Article;
import tn.shop.management.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(int id) {
        return articleRepository.findById(id);
    }

    public Article saveArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(int id, Article updatedArticle) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            return articleRepository.save(updatedArticle);
        }
        return null; // Gérer l'erreur si l'article n'est pas trouvé
    }

    public void deleteArticle(int id) {
        articleRepository.deleteById(id);
    }
}
