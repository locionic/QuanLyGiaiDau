package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import database.DBConnection;

@Path("/services/")
public class Services {
	private Statement stmt = null;
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	@POST
	@Path("/sign-in/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public boolean signIn(@FormParam("username") String username, @FormParam("password") String password) {
		try {
			try {
				conn = new DBConnection().getConnection();
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM account");
				while (rs.next()) {
					if (rs.getString("username").equals(username) && rs.getString("password").equals(password)) {
						return true;
					}
				}
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (stmt != null)
						stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}//sign in dễ t làm r, còn 4 chức năng này nữa chắc đủ r á cái này là theo bản mã VNIKEY gì á nó k cho save trừ khi mà đánh k dấu
	@GET
	@Path("/get-team/")
	@Produces(MediaType.TEXT_PLAIN)
	public void getTeamMatch() {
		//method này dùng để lấy dữ liệu từ db, dán lên page để hiển thị cho user xem các trận đấu của các team, vd: Team A: 0 ----- Team B: 1
	}
	public void SapXepTranDau() {
		//method này dùng để auto sắp các team đấu vs nhau
	}
	public void updatePlayer() {
		//này dùng để cập nhật player như là thêm thẻ vàng, đỏ, điểm đã ghi
	}
	public void updateTeamMatch() {
		//này dùng để cập nhật báng điểm của team
	}
}
