package vn.edu.hcmuaf.dao;

import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.statement.Query;
import vn.edu.hcmuaf.db.JDBIConnector;
import vn.edu.hcmuaf.model.Status;

import java.util.ArrayList;
import java.util.List;

public class StatusDao {

    public static List<Status> getStatusDirectory(){
        List<Status> statusList= new ArrayList<Status>();
        try (Handle handle = JDBIConnector.me().open()) {
            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
            String query = "SELECT id, `status_name`, `create` FROM status WHERE id LIKE \"KD%\"";

            Query queryObj = handle.createQuery(query);
            statusList = queryObj.map((rs, ctx) ->
                    new Status(
                            rs.getString("id"),
                            rs.getString("status_name"),
                            rs.getTimestamp("create")
                    )
            ).list();
        } catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi, trả về một danh sách trống
            return List.of();
        }
        return  statusList;
    }
    public static List<Status> getStatusByDirectory(){
        List<Status> statusList= new ArrayList<Status>();
        try (Handle handle = JDBIConnector.me().open()) {
            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
            String query = "SELECT id, `status_name`, `create` FROM status WHERE id LIKE \"DM%\"";

            Query queryObj = handle.createQuery(query);
            statusList = queryObj.map((rs, ctx) ->
                    new Status(
                            rs.getString("id"),
                            rs.getString("status_name"),
                            rs.getTimestamp("create")
                    )
            ).list();
        } catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi, trả về một danh sách trống
            return List.of();
        }
        return  statusList;
    }
    /*
    trạng thái đơn hàng chưa hoàn thành
     */
    public static List<Status> getStatusByOderNew(){
        List<Status> statusList= new ArrayList<Status>();
        try (Handle handle = JDBIConnector.me().open()) {
            // Thực hiện truy vấn để lấy dữ liệu ID từ bảng staging
            String query = "SELECT id, `status_name`, `create` FROM status WHERE id IN (\"DH04\",\"DH05\",\"DH06\",\"DH07\")";

            Query queryObj = handle.createQuery(query);
            statusList = queryObj.map((rs, ctx) ->
                    new Status(
                            rs.getString("id"),
                            rs.getString("status_name"),
                            rs.getTimestamp("create")
                    )
            ).list();
        } catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi, trả về một danh sách trống
            return List.of();
        }
        return  statusList;
    }
    public  static String getName(String id){
        String result="";
        try (Handle handle = JDBIConnector.me().open()){
            String query ="SELECT status_name FROM status WHERE id=?";

            result = handle.createQuery(query).bind(0, id)
                    .mapTo(String.class)
                    .one();

        }catch (Exception e) {
            e.printStackTrace();
            // Nếu có lỗi, trả về một danh sách trống
            return "";
        }
        return result;
    }

    public  static String getID(String name){
        String result="";
        try (Handle handle = JDBIConnector.me().open()){
            String query ="SELECT id FROM status WHERE status_name=?";

            result = handle.createQuery(query).bind(0, name)
                    .mapTo(String.class)
                    .one();

        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<Status> list = getStatusDirectory();
        for (Status s : list){
            System.out.println(s.toString());
        }
    }
}
