package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardDeleteCommand implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		
		BoardDao dao = new BoardDao();
		int res = dao.setBoardDelete(idx);
		
		if(res != 0) {
			request.setAttribute("message", "게시글이 삭제되었습니다.");
			request.setAttribute("url", "boardList.bo");
		}
		else {
			request.setAttribute("message", "게시글 삭제가 실패되었습니다.");
			request.setAttribute("url", "boardContent.bo?idx" + idx);
		}
	}

}
