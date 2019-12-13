package chap02;

public class OracleArticleDao implements ArticleDao {
	// 구현시, 오버라이딩해야함
	public void insert() {
		System.out.println("OracleArticleDao.insert() 메서드 호출");
	}
}
