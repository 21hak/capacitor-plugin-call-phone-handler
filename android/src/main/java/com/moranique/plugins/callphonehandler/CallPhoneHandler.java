package com.moranique.plugins.callphonehandler;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import java.net.URISyntaxException;

@NativePlugin
public class CallPhoneHandler extends Plugin {

    static String TAG = "callphonehandler";

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", value);
        call.success(ret);
    }
    private void startCall(String num) {
        Context context = getContext();
        Intent it = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + num));
        it.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(it);
    }

    @PluginMethod
    public void callPhone(PluginCall call) {
        String phoneNumber = call.getString("phoneNumber");
        this.startCall(phoneNumber);
    }
}
