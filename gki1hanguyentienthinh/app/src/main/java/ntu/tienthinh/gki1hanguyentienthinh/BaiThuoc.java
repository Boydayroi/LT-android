package ntu.tienthinh.gki1hanguyentienthinh;

public class BaiThuoc {
    private String tenBaiThuoc;
    private String congDungChinh;
    private int anhMinhHoaId;

    // Constructor
    public BaiThuoc(String tenBaiThuoc, String congDungChinh, int anhMinhHoaId) {
        this.tenBaiThuoc = tenBaiThuoc;
        this.congDungChinh = congDungChinh;
        this.anhMinhHoaId = anhMinhHoaId;
    }

    // Getters
    public String getTenBaiThuoc() { return tenBaiThuoc; }
    public String getCongDungChinh() { return congDungChinh; }
    public int getAnhMinhHoaId() { return anhMinhHoaId; }
}
