//package vn.edu.hcmuaf.dao;
//
//import ch.qos.logback.core.encoder.EchoEncoder;
//import org.jdbi.v3.core.Handle;
//import org.jdbi.v3.core.statement.Query;
//import org.jdbi.v3.core.statement.Update;
//import vn.edu.hcmuaf.db.JDBIConnector;
//import vn.edu.hcmuaf.model.Oders;
//import vn.edu.hcmuaf.model.Products;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OdersDao {
//    /*
//    lấy danh sach các đơn đặt hàng
//     */
//    public static List<Oders> getOdersAdmin() {
//        List<Oders> odersList= new ArrayList<Oders>();
//        try (Handle handle = JDBIConnector.me().open()) {
//            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
//            String query = "SELECT madonhang, makh, ngaytao, tongdh, ten, sdt, diachi, trangthai, thanhtoan FROM dondathang";
//
//            Query queryObj = handle.createQuery(query);
//            odersList = queryObj.map((rs, ctx) ->
//                    new Oders(
//                            rs.getString("madonhang"),
//                            rs.getString("makh"),
//                            rs.getTimestamp("ngaytao"),
//                            rs.getLong("tongdh"),
//                            rs.getString("ten"),
//                            rs.getString("sdt"),
//                            rs.getString("diachi"),
//                            rs.getString("trangthai"),
//                            rs.getString("thanhtoan")
//                    )
//            ).list();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Nếu có lỗi, trả về một danh sách trống
//            return List.of();
//        }
//        return odersList;
//    }
//
//
//    /*
//    lấy danh sách đơn hàng theo hình thức đơn hàng chưa hoàn thành
//     */
//    public static List<Oders> getOdersStatusNews() {
//        List<Oders> odersList= new ArrayList<Oders>();
//        try (Handle handle = JDBIConnector.me().open()) {
//            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
//            String query = "SELECT madonhang, makh, ngaytao, tongdh, ten, sdt, diachi, trangthai, thanhtoan FROM dondathang WHERE trangthai IN (\"DH04\",\"DH05\",\"DH06\")";
//
//            Query queryObj = handle.createQuery(query);
//            odersList = queryObj.map((rs, ctx) ->
//                    new Oders(
//                            rs.getString("madonhang"),
//                            rs.getString("makh"),
//                            rs.getTimestamp("ngaytao"),
//                            rs.getLong("tongdh"),
//                            rs.getString("ten"),
//                            rs.getString("sdt"),
//                            rs.getString("diachi"),
//                            rs.getString("trangthai"),
//                            rs.getString("thanhtoan")
//                    )
//            ).list();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Nếu có lỗi, trả về một danh sách trống
//            return List.of();
//        }
//        return odersList;
//    }
//    public static List<String> getID() {
//        List<String> odersList= new ArrayList<String>();
//        try (Handle handle = JDBIConnector.me().open()) {
//            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
//            String query = "SELECT madonhang FROM dondathang";
//            Query queryObj = handle.createQuery(query);
//            odersList = queryObj.mapTo(String.class).list();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Nếu có lỗi, trả về một danh sách trống
//            return List.of();
//        }
//        return odersList;
//    }
//    /*
//   lấy danh sách đơn hàng theo hình thức đơn hàng chưa hoàn thành
//    */
//    public static List<Oders> getOdersStatusCanel() {
//        List<Oders> odersList= new ArrayList<Oders>();
//        try (Handle handle = JDBIConnector.me().open()) {
//            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
//            String query = "SELECT madonhang, makh, ngaytao, tongdh, ten, sdt, diachi, trangthai, thanhtoan FROM dondathang WHERE trangthai IN (\"DH08\")";
//
//            Query queryObj = handle.createQuery(query);
//            odersList = queryObj.map((rs, ctx) ->
//                    new Oders(
//                            rs.getString("madonhang"),
//                            rs.getString("makh"),
//                            rs.getTimestamp("ngaytao"),
//                            rs.getLong("tongdh"),
//                            rs.getString("ten"),
//                            rs.getString("sdt"),
//                            rs.getString("diachi"),
//                            rs.getString("trangthai"),
//                            rs.getString("thanhtoan")
//                    )
//            ).list();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Nếu có lỗi, trả về một danh sách trống
//            return List.of();
//        }
//        return odersList;
//    }
//    public static Oders getOders(String id) {
//        Oders oders= new Oders();
//        try (Handle handle = JDBIConnector.me().open()) {
//            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
//            String query = "SELECT madonhang, makh, ngaytao, tongdh, ten, sdt, diachi, trangthai, thanhtoan FROM dondathang WHERE madonhang=?";
//
//            Query queryObj = handle.createQuery(query).bind(0,id);
//            oders = queryObj.map((rs, ctx) ->
//                    new Oders(
//                            rs.getString("madonhang"),
//                            rs.getString("makh"),
//                            rs.getTimestamp("ngaytao"),
//                            rs.getLong("tongdh"),
//                            rs.getString("ten"),
//                            rs.getString("sdt"),
//                            rs.getString("diachi"),
//                            rs.getString("trangthai"),
//                            rs.getString("thanhtoan")
//                    )
//            ).findOne().orElse(null);
//
//
//        } catch (Exception e) {
//
//        }
//        return oders;
//
//    }
//    public static List<Oders> getOdersbyKH(String id) {
//        List<Oders> oders = new ArrayList<>();
//        try (Handle handle = JDBIConnector.me().open()) {
//            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
//            String query = "SELECT madonhang, makh, ngaytao, tongdh, ten, sdt, diachi, trangthai, thanhtoan FROM dondathang WHERE makh=?";
//
//            Query queryObj = handle.createQuery(query).bind(0,id);
//            oders = queryObj.map((rs, ctx) ->
//                    new Oders(
//                            rs.getString("madonhang"),
//                            rs.getString("makh"),
//                            rs.getTimestamp("ngaytao"),
//                            rs.getLong("tongdh"),
//                            rs.getString("ten"),
//                            rs.getString("sdt"),
//                            rs.getString("diachi"),
//                            rs.getString("trangthai"),
//                            rs.getString("thanhtoan")
//                    )
//            ).list();
//
//
//        } catch (Exception e) {
//
//        }
//        return oders;
//
//    }
//
//
//    public static void updateStatusOder(String id, String status){
//        try (Handle handle=JDBIConnector.me().open()){
//            String query = "UPDATE dondathang SET trangthai=? WHERE madonhang=?";
//            Update update = handle.createUpdate(query)
//                    .bind(0, status)
//                    .bind(1, id);
//            update.execute();
//        }
//    }
//
//    public static void insertOders(String id, String makh, long total, String name, String sdt,String address, String status, String thanhtoan){
//        try (Handle handle = JDBIConnector.me().open()){
//            String query ="INSERT INTO dondathang(madonhang, makh, ngaytao, tongdh, ten, sdt, diachi, trangthai, thanhtoan) VALUES (?, ?, NOW(), ?, ?, ?, ?, ?, ?)";
//            Update update = handle.createUpdate(query)
//                    .bind(0, id)
//                    .bind(1, makh)
//                    .bind(2, total)
//                    .bind(3, name)
//                    .bind(4, sdt)
//                    .bind(5, address)
//                    .bind(6, status)
//                    .bind(7, thanhtoan);
//            update.execute();
//        }
//    }
//
//    public static void updateOder(String id, String statsu){
//        try (Handle handle=JDBIConnector.me().open()){
//            String query = "UPDATE dondathang SET trangthai=? WHERE madonhang=?";
//            Update update = handle.createUpdate(query)
//                    .bind(0, statsu)
//                    .bind(1, id);
//            update.execute();
//        }catch (Exception e){
//
//        }
//    }
//}
