import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class WeathMain {

    @Expose
    private Double calctime;
    @Expose
    private Long cnt;
    @Expose
    private String cod;
    @Expose
    @SerializedName("list")
    private java.util.List<Location> list;

    public Double getCalctime() {
        return calctime;
    }

    public void setCalctime(Double calctime) {
        this.calctime = calctime;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public java.util.List<Location> getList() {
        return list;
    }

    public void setList(java.util.List<Location> list) {
        this.list = list;
    }

}
