package cordova.plugin.outsystems;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//Widget Android
import android.widget.Toast;

/**
 * This class echoes a string called from JavaScript.
 */
public class PluginOutsystems extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("coolMethod")) {
            String message = args.getString(0);
            this.coolMethod(message, callbackContext);
            return true;
        }
        return false;
    }

    private void coolMethod(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            //Crear el widget con nuestro mensaje ingresado
            Toast toast = Toast.makeText(cordova.getActivity(),message,Toast.LENGTH_SHORT);
            //Mostrar el widget
            toast.show();
            //Enviar un resultado callback success
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
