package chap02;

// 
public class WriteImpl {
	private ArticleDao dao;
	
	// 생성자
	public WriteImpl(ArticleDao dao) {
		this.dao = dao;
	}
	
	public void write() {
		System.out.println("WriteImpl.write() 메서드 호출");
		dao.insert();
	}
}
