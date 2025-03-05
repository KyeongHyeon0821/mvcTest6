package board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardUpdateOkCommand implements BoardService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idx = request.getParameter("idx")==null ? 0 : Integer.parseInt(request.getParameter("idx"));
		String name = request.getParameter("name")==null ? "" : request.getParameter("name");
		String title = request.getParameter("title")==null ? "" : request.getParameter("title");
		String content = request.getParameter("content")==null ? "" : request.getParameter("content");
		String hostIp = request.getRemoteAddr();
		
		BoardVo vo = new BoardVo();
		vo.setIdx(idx);
		vo.setName(name);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setHostIp(hostIp);
		
		BoardDao dao = new BoardDao();
		int res = dao.setBoardUpdateOk(vo);
		
		if(res != 0) {
			request.setAttribute("message", "게시글이 수정되었습니다.");
			request.setAttribute("url", "boardList.bo");
		}
		else {
			request.setAttribute("message", "게시글 수정이 실패되었습니다.");
			request.setAttribute("url", "boardUpdate.bo?idx=" + idx);
		}
	}

}
