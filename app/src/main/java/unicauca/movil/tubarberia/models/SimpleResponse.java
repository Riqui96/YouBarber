package unicauca.movil.tubarberia.models;

/**
 * Created by EQUIPO on 12/06/2017.
 */

public class SimpleResponse {
    private boolean sucsess;
    private String msg;

    public boolean isSucsess() {
        return sucsess;
    }

    public void setSucsess(boolean sucsess) {
        this.sucsess = sucsess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
