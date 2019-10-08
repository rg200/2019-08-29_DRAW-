package DB;

import java.sql.*;



public class DAO{
	String driver = "org.mariadb.jdbc.Driver";//드라이버
	Connection con;//커넥션 객체
	PreparedStatement pstmt;//sql 명령에 사용되는 객체
	ResultSet rs;//명령문세팅에 사용되는 객체
	 String name;
	public DAO() {//객체 생성시, 접속을 시도함
		con = getConn();
	}
	public static class Singleton { //인스턴스를 하나만 만들겠다는 생각에 추가됨 덕분에 static를 도배 안해도됨 
		private static final DAO instance = new DAO();
	}
	public static DAO getInstance() {
		return Singleton.instance;
	}
	//db연결시도메서드
	public Connection getConn() {
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
	//중복된 닉네임인지 판별 메서드
	public String checkMember(String id) {
		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		con = getConn();

		try {
			con = getConn();
			String sql = "select from TB_MEMBER where id=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet r = ps.executeQuery(); 
			if (r.next()) {
				System.out.println(id + " is already exist, try again");
			} else {
				System.out.println("UserName does not exist, you can use this id");
			}

		} catch (Exception e) {
			System.out.println(e + "-> �����߻�");
		}
		return "[DB]: Duplicate inspection complete";
	}
	//유저 삽입 메서드
	public boolean insertMember(String id, String pwd, String name) {

		boolean ok = false;
		Connection con = null; 
		PreparedStatement ps = null;

		try {
			System.out.println(id + pwd + name);
			con = getConn();
			String sql = "insert into TB_MEMBER(" + 
								"id,pwd,name) " + 
								"values(?,?,?)";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, name);
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
	}// 유저 로그인 시도시 맞는 유저인지 아이디와 패스워드대조 판별
	public boolean searchMember(String id, String pwd) {

		boolean ok = false;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = getConn();
			String sql = "select pwd, name from TB_MEMBER where id=?";

			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery(); 
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
			System.out.println(e + "-> �����߻�");
		}
		return ok;
	}
}