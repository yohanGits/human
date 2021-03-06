package service;

import java.util.List;

import dao.ReplyDao;
import vo.Reply;

public class ReplyServiceImpl implements ReplyService{
	private ReplyDao dao = new ReplyDao();
	@Override
	public List<Reply> list(Long bno) {
		return dao.list(bno);
	}
	
	public Reply get(Long rno) {
		return dao.select(rno);
		
	}

	public void remove(Long rno) {
		dao.delete(rno);
	}

	@Override
	public void setNull(String id) {
		dao.idNull(id);
	}

	@Override
	public void write(Reply reply) {
		dao.insert(reply);
	}

	@Override
	public void removeAll(Long bno) {
		dao.deleteAll(bno);
	}

	@Override
	public void modifyReply(Reply reply) {
		dao.updaterep(reply);
	}
	
}
