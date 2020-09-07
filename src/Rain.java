import com.google.gson.annotations.SerializedName;


public class Rain {

    @SerializedName("3h")
    private Double h;

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

}
