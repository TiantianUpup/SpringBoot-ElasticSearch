# SpringBoot整合ElasticSearch
- 添加的依赖
  ```
  <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-data-elasticsearch</artifactId>
  </dependency>
   ```
- 配置文件
  ```
  ##端口号
  server.port=8888

  ##es地址
  spring.data.elasticsearch.cluster-nodes = 127.0.0.1:9300
  ```
   
- Dao层
  继承ElasticsearchRepository<Article, String>类，第一个范型参数为实体类型，第二个范型参数为主键类型
  ```
  @Repository
  public interface ArticleDao extends ElasticsearchRepository<Article, String> {
  }
  ```
- Service层
  - 接口
  ```
  public interface ArticleService {
    void saveArticle();
    Article findById();
  }
  ```
  - 实现类
  ```
  @Service
  public class ArticleServiceImpl implements ArticleService {
      @Autowired
      private ArticleDao articleDao;

      @Override
      public void saveArticle() {
          articleDao.save(Article.builder().id("1").title("title").content("This is content").build());
      }

      @Override
      public Article findById() {
          return articleDao.findById("1").get();
      }
  }

  ```
  ElasticsearchRepository类里提供了很多简单的curd方法，如果查询不是特别复杂，可以直接使用
- Controller层
  ```
  @RestController
  public class ESController {
      @Autowired
      private ArticleService articleService;

      @PostMapping("/saveArticle")
      public String saveArticle() {
          articleService.saveArticle();
          return "success";
      }

      @GetMapping("/getArticle")
      public Article getArticle() {
          Article article = articleService.findById();
          return article;
      }
  }

  ```
