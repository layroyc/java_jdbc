package cn.hp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import cn.hp.entity.Book;
import cn.hp.unit.DBHelper;

public class BookDaoImpl implements BookDao{

	//���
	@Override
	public int insert(Book book) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBHelper.getConn();
			//��дsql���
			String sql = "insert into book(bname,bauthor,bprice,btype,bmark) values (?,?,?,?,?)";
			//����preparedStatement,ִ��sql
			ps = conn.prepareStatement(sql);
			ps.setString(1, book.getBname());
			ps.setString(2, book.getBauthor());
			ps.setInt(3, book.getBprice());
			ps.setString(4, book.getBtype());
			ps.setString(5,book.getBmark());
			int count = ps.executeUpdate();
			return count;
		}catch (SQLException e) {
			System.out.println("����������");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
  
	//ȫ��ѯ
	@Override
	public ArrayList<Book> selectAll() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		ArrayList<Book> list = new ArrayList<Book>();
	     try {
			//��ȡ����
			conn = DBHelper.getConn();
		    //��дsql���
			String sql = "select * from book";
			//����preparedStatement,ִ��sql
			ps = conn.prepareStatement(sql);
		    rs = ps.executeQuery();
		    //��������
			Book p = null;
		    while(rs.next()){
		    //�����вι���ֱ�Ӹ�ֵ��������
		    p=new Book(
		    		rs.getInt(1),
		    		rs.getString(2),
		    		rs.getString(3),
		    		rs.getInt(4),
		    		rs.getString(5),
		    		rs.getString(6)
			      
				);
				list.add(p);
		}
		   } catch (Exception e) {
			   e.printStackTrace();
		   } finally{
			try {
			    DBHelper.close(ps, rs, conn);
				} catch (SQLException e) {
					e.printStackTrace();
			}
		}
				return list;
	}

	//����ѯ
	@Override
	public Book selectbname(String bname) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBHelper.getConn();
			//��дsql���
			String sql = "select * from book where bname=?";
			//����preparedStatement,ִ��sql
			ps = conn.prepareStatement(sql);
            ps.setString(1, bname);	
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	System.out.print(rs.getInt("id")+" ");
                System.out.print(rs.getString("bname")+" ");
                System.out.print(rs.getString("bauthor")+" ");
                System.out.print(rs.getInt("bprice")+" ");
                System.out.print(rs.getString("btype")+" ");
                System.out.print(rs.getString("bmark"));
            }
		}catch (SQLException e) {
			System.out.println("��ѯ������");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	//�޸�
	@Override
	public int update(Book Book,int id) {
		// TODO Auto-generated method stub
				Connection con=null;
				PreparedStatement ps=null;
				int c=0;
				try {
					con=DBHelper.getConn();
					String sql4="update book set bname=?,bauthor=?,btype=?,bprice=?,bmark=? where id=?";
					ps=con.prepareStatement(sql4);
					
					ps.setString(1,Book.getBname());
					ps.setString(2,Book.getBauthor());
					ps.setString(3,Book.getBtype());
					ps.setInt(4,Book.getBprice());
					ps.setString(5, Book.getBmark());
					ps.setInt(6, id);
					/*StringBuffer sb = new StringBuffer("update book set ");
					if(Book.getBname()!=null){
						sb.append("bname="+"'"+Book.getBname()+"'");
					}
					if(Book.getBauthor()!=null){
						sb.append("bauthor="+"'"+Book.getBauthor()+"'");
					}
					if(Book.getBprice()!=0){
						sb.append("bprice="+"'"+Book.getBprice()+"'");
					}
					if(Book.getBtype()!=null){
						sb.append("btyte="+"'"+Book.getBtype()+"'");
					}
					if(Book.getBmark()!=null){
						sb.append("bmark="+"'"+Book.getBmark()+"'");
					}
					sb.append("where id ="+Book.getId());
					sb.append(" and 1=1");
					System.out.println();
					ps=con.prepareStatement(sb.toString());*/
					c=ps.executeUpdate();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					try {
						DBHelper.close(ps, con);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("����SQl�쳣");
			}
		}
		return c;
	}

	//ɾ��
	@Override
	public int delete(int id) {
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn = DBHelper.getConn();
			//��дsql���
			String sql = "delete from  book where id=?";
			//����preparedStatement,ִ��sql
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			int count = ps.executeUpdate();
			return count;
		}catch (Exception e) {
			System.out.println("ɾ��������");
			return 0;
		}finally{
				try {
					DBHelper.close(ps, conn);
				} catch (SQLException e) {
				}
		}
	}
	@Override
	public Book selectbooks(int id) {
		Book book=new Book();
		Connection con=null;
		PreparedStatement ps=null;
		try {
			con=DBHelper.getConn();
			String sql2="select * from book where id=?";
			ps=con.prepareStatement(sql2);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery(); 

			while(rs.next()){
//				System.out.print(rs.getInt("id")+" ");
//				System.out.print(rs.getString("bname")+" ");
//				System.out.print(rs.getString("bauthor")+" ");
//				System.out.print(rs.getInt("bprice")+" ");
//				System.out.print(rs.getString("btype")+" ");
//				System.out.print(rs.getString("bmark")+" ");
				
				book.setId(rs.getInt("id"));
				book.setBname(rs.getString("bname"));
				book.setBauthor(rs.getString("bauthor"));
				book.setBprice(rs.getInt("bprice"));
				book.setBtype(rs.getString("btype"));
				book.setBmark(rs.getString("bmark"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				DBHelper.close(ps, con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("����SQl�쳣");
			}
		}
		return book;	
	}


}
