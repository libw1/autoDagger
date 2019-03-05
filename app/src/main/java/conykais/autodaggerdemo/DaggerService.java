package conykais.autodaggerdemo;

import android.content.Context;

public class DaggerService {
    public static final String SERVICE_NAME = DaggerService.class.getName();

    public DaggerService() {
    }

    public static <T> T get(Context context) {
        //noinspection unchecked,ResourceType
        return (T) context.getSystemService(SERVICE_NAME);
    }

    public static <T> T get(Context context, String name) {
        //noinspection unchecked,ResourceType
        return (T) context.getSystemService(name);
    }
}
