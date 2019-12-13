package spring;

public class MariadbArticleDao implements ArticleDao {
	@Override
	public void insert() {
		System.out.println("MariadbArticleDao.insert() 메서드 호출");
	}
}
