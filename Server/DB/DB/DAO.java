package DB;

import java.sql.*;

public class DAO{
	String driver = "org.mariadb.jdbc.Driver";//드라이버
	Connection con;//커넥션 객체
	PreparedStatement pstmt;//sql 명령에 사용되는 객체
	ResultSet rs;//명령문세팅에 사용되는 객체
	 String name;
	public DAO() {
		//  객체 생성시, 접속을 시도함
		con = getConn();
	}
	public static class Singleton { 
		//  인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨 
		private static final DAO instance = new DAO();
	}
	public static DAO getInstance() {
		return Singleton.instance;
	}
	
	public Connection getConn() {
		//  db연결시도메서드
		try {
			Class.forName(driver);//보통 드라이버의 종류를 적게된다
		} catch (ClassNotFoundException e) {// 주로 이것은 오타가 나거나 라이브러리 미설치시 발생함
			System.out.println("드라이버 접속 실패");
		}
		try {//순서대로 db종류, 아이피, 포트, db이름, db유저아이디, db유저패스워드이다
			con = DriverManager.getConnection("jdbc:mariadb://18.189.40.201:3306/Test", "abcd", "1234");
			if (con != null) {
				System.out.println("DB 접속 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}

		return con;
	}
	
	public boolean insert(String id, String nickName , String tbName) {
		//  삽입 메서드 , 친구 추가가 디폴트 , 이후 방테이블추가 메서드등등으로 오버라이딩 해서 사용 가능
		boolean ok = false;
		Connection con = null; 
		PreparedStatement ps = null;

		try {
			//System.out.println(id + name); 콘솔확인용 
			con = getConn();
			String sql = "insert into "+ tbName +"(" + 
								"bf_id,bf_nickName) " + 
								"values(?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, nickName);
			int r = ps.executeUpdate(); 
			if(r>0){
                System.out.println("가입 성공");   
                ok=true;
            }else{
                System.out.println("가입실패");
            }

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
	public boolean search(String id, String pwd , String tbName) {
		//  select와 같은 메서드 , 로그인기능이 디폴트임 , 오버라이딩 사용가능
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			String sql = "select pwd from "+ tbName+" where id=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery(); 
			if (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) {
					System.out.println("login succeeded");
					ok = true;
				} else {
					System.out.println("Wrong password, Login Failed");
				}
			} else {
				System.out.println("UserName does not exist, Login Failed");
			}

		} catch (Exception e) {
			System.out.println(e + "예외발생");
		}
		return ok;
	}
	
	public boolean delete(String id, String name , String tbName) {
		//  행삭제 메서드 ,친구 목록 삭제가 디폴트, 오버라이딩으로 사용 가능
		boolean ok = false;
		Connection con = null; 
		PreparedStatement ps = null;

		try {
			//System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "delete from "+tbName +" where bf_id='?' and bf_nickName='?'";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, name);
			int r = ps.executeUpdate(); 
			if(r>0){
                System.out.println("삭제 성공");   
                ok=true;
            }else{
                System.out.println("삭제 실패");
            }

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
}
