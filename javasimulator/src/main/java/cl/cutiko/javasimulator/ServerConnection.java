package cl.cutiko.javasimulator;

import android.os.Handler;

/**
 * Created by cutiko on 23-03-18.
 */

public class ServerConnection {



    public ServerConnection toDirection(String url) {
        return this;
    }

    public ServerConnection upload(Object object) {
        return this;
    }

    public ServerConnection upload(Object object, final ServerResponse callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (System.currentTimeMillis()%2 == 0) {
                    callback.error("Server Error");
                } else {
                    callback.success();
                }
            }
        }, 2000);
        return this;
    }

    public interface ServerResponse {

        void error(String error);
        void success();

    }

}
