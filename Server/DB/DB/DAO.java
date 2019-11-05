package DB;

import java.sql.*;

public class DAO {
	String driver = "org.mariadb.jdbc.Driver";// 드라이버
	Connection con = null;// 커넥션 객체
	PreparedStatement pstmt = null;// sql 명령에 사용되는 객체
	ResultSet rs = null;// 명령문세팅에 사용되는 객체
	String name;

	public DAO() {
		// 객체 생성시, 접속을 시도함
		con = getConn();
	}

	public static class Singleton {
		// 인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨
		private static final DAO instance = new DAO();
	}

	public static DAO getInstance() {
		return Singleton.instance;
	}

	public Connection getConn() {
		// db연결시도메서드
		try {
			Class.forName(driver);// 보통 드라이버의 종류를 적게된다
		} catch (ClassNotFoundException e) {// 주로 이것은 오타가 나거나 라이브러리 미설치시 발생함
			System.out.println("드라이버 접속 실패");
		}
		try {// 순서대로 db종류, 아이피, 포트, db이름, db유저아이디, db유저패스워드이다
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

	public boolean insert(String id, String nickName, String tbName) {
		// 삽입 메서드 , 친구 추가가 디폴트 , 이후 방테이블추가 메서드등등으로 오버라이딩 해서 사용 가능
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
			con = getConn();
			String sql = "insert into " + tbName + "(" + "bf_id,bf_nickName) " + "values(?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickName);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("가입 성공");
				ok = true;
			} else {
				System.out.println("가입실패");
				dbclose();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean select(String id, String pwd) {
		// select와 같은 메서드 , 로그인기능이 디폴트임 , 오버라이딩 사용가능
		boolean ok = false;
		try {
			con = getConn();// 내부 조인 사용함

			String sql = "select pwd, name from TB_MEMBER where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // ���� -> ����
			if (rs.next()) {
				if (pwd.equals(rs.getString("pwd"))) {
					System.out.println("login succeeded");
					name = rs.getString("name");
					ok = true;
				} else {
					System.out.println("Wrong password, Login Failed");
				}
			} else {
				System.out.println("UserName does not exist, Login Failed");
			}
		} catch (Exception e) {
			System.out.println(e + "예외발생");
			dbclose();
		}
		return ok;
	}

	public boolean delete(String id, String name, String tbName) {
		// 행삭제 메서드 ,친구 목록 삭제가 디폴트, 오버라이딩으로 사용 가능
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "delete from " + tbName + " where bf_id=? and bf_nickName=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
				ok = true;
			} else {
				System.out.println("삭제 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public void dbclose() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}

class BFDAO extends DAO {
	public boolean insert(String id, String nickName, String tbName) {
		// 친구 추가
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
			con = getConn();
			String sql = "insert into " + tbName + "(" + "bf_id,bf_nickName) " + "values(?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickName);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("추가 성공");
				ok = true;
			} else {
				System.out.println("추가 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean delete(String id, String nickName, String tbName) {
		// 행삭제 메서드 ,친구 목록 삭제가 디폴트, 오버라이딩으로 사용 가능
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "delete from " + tbName + " where bf_id=? and bf_nickName=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickName);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
				ok = true;
			} else {
				System.out.println("삭제 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean select(String id, String pwd, String tbName) {
		// 접속 현황 테이블의 접속 여부를 조인하여 친구 목록 불러오기
		boolean ok = false;
		try {
			con = getConn();
			String sql = "select BF.bf_nickName,STATE.member_state from TB_BF BF inner join TB_STATE STATE on BF.bf_id=STATE.st_id and BF.bf_id=?";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			dbclose();
		} catch (Exception e) {
			System.out.println(e + "예외발생");
		}
		return ok;
	}
}

class STDAO extends DAO {
	public boolean insert(String id, int member_state, int roomNum, String tbName) {
		// 접속인원테이블추가(회원가입시 필수)
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
			con = getConn();
			String sql = "insert into " + tbName + "(" + "st_id,member_state,roomNum) " + "values(?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, member_state);
			pstmt.setInt(3, roomNum);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("추가 성공");
				ok = true;
			} else {
				System.out.println("추가 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean select(String tbName) {
		// 접속 인원 목록 불러오기
		boolean ok = false;
		try {
			con = getConn();
			String sql = "select * from " + tbName;

			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			dbclose();
		} catch (Exception e) {
			System.out.println(e + "예외발생");
		}
		return ok;
	}

	public boolean delete(String id, String nickName, String tbName) {
		// 회원탈퇴시 필수
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "delete from " + tbName + " where st_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
				ok = true;
			} else {
				System.out.println("삭제 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}

	public boolean update(String id, String tbName, int op1, int op2) {
		// 인게임내 회원 로그아웃,로그인, 룸입장, 룸퇴장등등 기반으로 필수
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "update " + tbName + "set member_state =? , roomNum= ?" + " where st_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, op1);
			pstmt.setInt(2, op2);
			pstmt.setString(3, id);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("수정 성공");
				ok = true;
			} else {
				System.out.println("수정 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
}

class GRDAO extends DAO {
	public boolean insert(String id, String nickName, String tbName) {
		// 최초가입시 필수 추가
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
			con = getConn();
			String sql = "insert into " + tbName + "("
					+ "gr_id,gr_traitor,gr_sheriff,gr_aide,gr_desperado,gr_roundsum) " + "values(?,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, 0);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, 0);
			pstmt.setInt(5, 0);
			pstmt.setInt(6, 0);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("추가 성공");
				ok = true;
			} else {
				System.out.println("추가 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
}

class MEMDAO extends DAO {
	public boolean getAge(String tbName) {
		// 나이 계산 메소드
		boolean ok = false;
		con = getConn();

		try {
			con = getConn();
			String sql = "select floor(datediff (now(), birth)/365) as age";

			pstmt = con.prepareStatement(sql);
			ResultSet r = pstmt.executeQuery();
			if (r.next()) {
				if (rs.getInt("age") > 20) {
					System.out.println("login succeeded");
					ok = true;
				} else {
					System.out.println("Your age is not allowed , Please checkout our Policy");
				}
			}
			dbclose();

		} catch (Exception e) {
			System.out.println(e + "-> 예외발생");
		}
		return ok;

	}

	public boolean getRed(String id) {
		// 중복 검사 메소드
		boolean ok = false;
		con = getConn();

		try {
			con = getConn();
			String sql = "select id from TB_MEMBER where id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				System.out.println(rs.getString("id") + " is already exist, try again");
			} else {
				System.out.println("UserName does not exist, you can use this id");
				ok = true;
			}
			dbclose();

		} catch (Exception e) {
			System.out.println(e + "-> 예외발생");
		}
		return ok;
	}
}

class ROOMDAO extends DAO {
	public boolean insert(String id, String nickName,int manNum, String tbName) {
		//  룸테이블 추가 메소드 , 사용후 접속 현황 테이블 업데이트 해야함
		boolean ok = false;

		try {
			// System.out.println(id + name); 콘솔확인용
			con = getConn();
			String sql = "insert into " + tbName + "(" + "ro_ch,ro_num,ro_people) " + "values(?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, nickName);
			pstmt.setInt(3, manNum);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("추가 성공");
				ok = true;
			} else {
				System.out.println("추가 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
	public boolean delete(String id, String nickName, String tbName) {
		// 회원탈퇴시 필수
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "delete from " + tbName + " where st_id=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
				ok = true;
			} else {
				System.out.println("삭제 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ok;
	}
	public boolean update(String id, String tbName, int op1, int op2) {
		// 인게임내 회원 룸입장, 룸퇴장을 위해 존재함, 인원수 업데이트가 주로 쓰일거라 생각함
		boolean ok = false;

		try {
			// System.out.println(id + pwd + name); 테스트콘솔확인용
			con = getConn();
			String sql = "update " + tbName + "set ro_people =?" + " where ro_ch=? and ro_num=?";

			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, op1); // 변경된 사람수
			pstmt.setInt(2, op2); //  찾는 방의 채널
			pstmt.setString(3, id); //  찾는 방의 번호
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("수정 성공");
				ok = true;
			} else {
				System.out.println("수정 실패");
			}
			dbclose();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ok;
	}
}