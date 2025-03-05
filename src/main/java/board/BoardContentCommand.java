package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardContentCommand implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		
		BoardDao dao = new BoardDao();
		
		dao.setReadNumUpdate(idx); // 조회수 증가하기
		
		BoardVo vo =  dao.getBoardContent(idx); // 글 내용 조회하기
		
		request.setAttribute("vo", vo);
	}

}
