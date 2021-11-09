package service;

import java.util.List;

import dao.BoardDao;
import vo.Attach;
import vo.Board;
import vo.Criteria;

public class BoardServiceImpl implements BoardService{
	private BoardDao dao = new BoardDao();
	@Override
	// 트랜잭션
	public Long write(Board board) {
		// 글 작성 > 후 글 번호 반환
		Long bno = dao.insert(board);
		
		// 각 첨부파일에 글 번호 부여
		for(Attach attach : board.getAttachs()){
			attach.setBno(bno);
		//	첨부 파일 작성
		dao.writeAttach(attach);
		}
		return bno;
	}

	@Override
	public Board read(Long bno) {
		Board board = dao.read(bno);
		board.setAttachs(dao.readAttach(bno));
		return board;
	}

	@Override
	public List<Board> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public List<Board> list(Criteria cri) {
		List<Board> list = dao.list(cri);
		list.forEach(b ->b.setAttachs(dao.readAttach(b.getBno())));
		return list;
	}

	@Override
	public void modify(Board board) {
		// TODO Auto-generated method stub
		dao.update(board);
	}

	@Override
	public void remove(Long bno) {
		// TODO Auto-generated method stub
		dao.delete(bno);
	}

	@Override
	public String findOriginBy(String uuid) {
		return dao.findOriginBy(uuid);
	}

	public int getCount(Criteria cri) {
		return dao.getCount(cri);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Attach> readAttachByPath(String path) {
		return dao.readAttachByPath(path);
	}

	@Override
	public void removeAll(Long bno) {
		dao.deleteAll(bno);
	}

	@Override
	public void setNull(String id) {
		dao.idNull(id);
	}
	
	
}
