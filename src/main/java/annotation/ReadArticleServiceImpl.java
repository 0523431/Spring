package annotation;

import org.springframework.stereotype.Component;

import xml.Article;
import xml.ReadArticleService;

// 객체를 만들거야
// 그리고 그 이름은  readArticleService (재설정)
@Component("readArticleService")
public class ReadArticleServiceImpl implements ReadArticleService {
	@Override
	public Article getArticleAndReadCnt(int id) throws Exception {
		if(id ==0) {
			throw new Exception("id는 0이 안됨");
		}
		return new Article(id);
	}
}
