package xml;

public interface ArticleDao {
	void insert(Article article);
	void updateReadCount(int id, int i);
}
