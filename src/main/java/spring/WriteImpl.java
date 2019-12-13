package spring;

public class WriteImpl {
	private ArticleDao dao;
	// dao : xml에서 주입한 MariadbArticleDao 객체 저장
	public WriteImpl(ArticleDao dao) {
		this.dao = dao;
	}
	
	// 핵심로직
	public void write() {
		System.out.println("WriteImpl.write() 메서드 호출");
		dao.insert();
	}
}
