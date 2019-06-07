package com.ssk.retailshop.datahelper.webapi;


import com.ssk.retailshop.model.UserInfo;
import com.ssk.retailshop.model.order.OrderDetail;
import com.ssk.retailshop.model.order.OrderMaster;
import com.ssk.retailshop.model.product.Brandy;
import com.ssk.retailshop.model.product.Product;
import com.ssk.retailshop.model.product.Promotion;
import com.ssk.retailshop.model.speaknotice.Schadule;
import com.ssk.retailshop.model.speaknotice.SpeakInform;
import com.ssk.retailshop.screen.customer.model.CreateCustomersDTO;
import com.ssk.retailshop.screen.customer.model.CustomerItem;
import com.ssk.retailshop.screen.money.model.PayslipMoneyItem;
import com.ssk.retailshop.screen.money.model.ReceiptMoneyItem;
import com.ssk.retailshop.screen.order.model.OrderItem;
import com.ssk.retailshop.screen.product.model.FragmentProductDTO;
import com.ssk.retailshop.screen.register.model.UserRegisterDTO;
import com.ssk.retailshop.screen.report.model.InventoryDTO;
import com.ssk.retailshop.screen.report.model.InventoryListDTO;
import com.ssk.retailshop.screen.report.model.ProfitLossReportItem;
import com.ssk.retailshop.screen.report.model.ProfitReportItem;

import com.ssk.retailshop.screen.shop.model.RequestShop;
import com.ssk.retailshop.screen.shop.model.ResponseShop;

import com.ssk.retailshop.screen.report.model.ReportToProductDTO;
import com.ssk.retailshop.screen.report.model.ReportToSalesManDTO;
import com.ssk.retailshop.screen.report.model.ReportToStoreDTO;
import com.ssk.retailshop.screen.report.model.ReportToTimeDTO;


import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PathApi {
    @GET("/api/getproduct")
    Call<ResultApi<List<Product>>> getProduction(@Query("page") int page, @Query("allorid") String idall);

    @GET("/api/getorder")
    Call<ResultApi<List<OrderMaster>>> getOrder(@Query("page") int page, @Query("allorid") String idall);


    @GET("/api/getorderdtl")
    Call<ResultApi<List<OrderDetail>>> getOrderDtl(@Query("allorid") String idall);


    @GET("/api/getpromotion")
    Call<ResultApi<List<Promotion>>> getPromotion(@Query("page") int page, @Query("allorid") String idall);


    @GET("/api/getpromotionbydate")
    Call<ResultApi<List<Promotion>>> getPromotionByDate(@Query("fromdate") String fromdate, @Query("todate") String todate);

    @GET("/api/getbrand")
    Call<ResultApi<List<Brandy>>> getBrand(@Query("page") int page, @Query("allorid") String idall);

    @POST("/api/login")
    @FormUrlEncoded
    Call<ResultApi<List<UserInfo>>> getStatusLogin(@Field("UserName") String username, @Field("Password") String password);

    @POST("/api/checktoken")
    @FormUrlEncoded
    Call<ResultApi<List<UserInfo>>> getUserInfo(@Field("token") String token);

    //4/4/2019

    @GET("/api/getSpeakInform")
    Call<ResultApi<List<SpeakInform>>> getSpeakInform(@Query("allorid") String idall, @Query("fromdate") String fromdate, @Query("todate") String todate, @Query("page") int page);

    @GET("/api/getSchadule")
    Call<ResultApi<List<Schadule>>> getSchadule(@Query("page") int page, @Query("allorid") String idall, @Query("fromdate") String fromdate, @Query("todate") String todate);

    //Tien
    //Register Cửa hàng
    @POST("/api/registerStore")
    Call<ResultApi<List<UserRegisterDTO>>> registerShop(@Body UserRegisterDTO username);

    //Register khách hàng
    @POST("/api/saveCustomer")
    Call<ResultApi> registerCustomers(@Header("Authorization") String auth, @Body CreateCustomersDTO username);
    //2705
    //Doanh số
    ////Theo thời gian
    @GET("api/getReportSales")
    Call<ResultApi<List<ReportToTimeDTO>>> getListReportToTime(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("fromDate") String fromDate, @Query("toDate") String toDate , @Query("type") int type, @Query("userid") String userid);

    ////Theo sản phẩm
    @GET("api/getReportProductSales")
    Call<ResultApi<List<ReportToProductDTO>>> getListReportToProduct(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize);

    ////Theo nhân viên
    @GET("api/getReportEmployeeSales")
    Call<ResultApi<List<ReportToSalesManDTO>>> getListReportToSalesMan(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("fromDate") String from, @Query("toDate") String toDate);

    ////Theo cửa hàng
    @GET("api/getReportStoreSales")
    Call<ResultApi<List<ReportToStoreDTO>>> getListReportToStore(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("fromDate") String from, @Query("toDate") String toDate);

    ////Theo tồn kho
    @GET("api/getReportInventoryTotals")
    Call<ResultApi<List<InventoryDTO>>> getInventory(@Header("Authorization") String auth, @Query("fromDate") String from, @Query("toDate") String toDate);

    ////Theo tồn kho chi tiết
    @GET("api/getReportInventoryDetail")
    Call<ResultApi<List<InventoryListDTO>>> getInventoryListDetail(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize);

    //Tiền bạc
    ////Tạo phiếu chi
    @POST("/api/createPaySlipMoney")
    Call<ResultApi<List<UserRegisterDTO>>> createPaySlipMoney(@Header("Authorization") String auth, @Body UserRegisterDTO username);

    //Quản Lý
    ////Hàng hóa get list
    @GET("api/getProducts")
    Call<ResultApi<List<FragmentProductDTO>>> getProductList(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize);

    //LocND
    //20190522
    //Khách hàng - Khách hàng
    @GET("api/getListCustomers")
    Call<ResultApi<List<CustomerItem>>> getListCustomers(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("search") String search);

    // Báo cáo - Lợi nhuận
    @GET("api/getReportProfit")
    Call<ResultApi<List<ProfitReportItem>>> getReportProfit(@Header("Authorization") String auth, @Query("page") int page, @Query("pagesize") int pageSize, @Query("fromDate") String fromDate, @Query("toDate") String toDate);

    //Báo cáo - Lãi lỗ
    @GET("api/getReportIncomeStatement")
    Call<ResultApi<List<ProfitLossReportItem>>> getReportIncomeStatement(@Header("Authorization") String auth, @Query("fromDate") String fromDate, @Query("toDate") String toDate);

    //Tiền bạc - Thu
    @GET("api/getreceiptmoney")
    Call<ResultApi<List<ReceiptMoneyItem>>> getreceiptmoney(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("search") String search);

    //Tiền bạc - Chi
    @GET("api/getreceiptmoney")
    Call<ResultApi<List<PayslipMoneyItem>>> getpayslipmoney(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("search") String search);

    //Shop - save
    @GET("api/saveshop")
    Call<ResultApi<List<ResponseShop>>> saveshop(@Header("Authorization") String auth, @Body RequestShop obj);

    //Đơn hàng - danh sách
    @GET("api/getBills")
    Call<ResultApi<List<OrderItem>>> getBills(@Header("Authorization") String auth, @Query("page") int page, @Query("pageSize") int pageSize, @Query("fromDate") String fromDate, @Query("toDate") String toDate);

}
